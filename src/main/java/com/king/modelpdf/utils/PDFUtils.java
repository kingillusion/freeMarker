package com.king.modelpdf.utils;

import com.king.modelpdf.vo.TemplateVo;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * pdf处理工具类
 */
public class PDFUtils {
    private static final String BASE_PATH = "basePath";
    private static final String CATALOGUE_NUM_DETAIL = "catalogueNumDetail";

    /**
     *
     * @param configurer
     * @param templateName
     * @param map
     * @return
     */
    private static Document generateDoc(FreeMarkerConfigurer configurer,
                                        String templateName, Map<String,Object> map){
        Template tp;
        try {
            tp = configurer.getConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try(BufferedWriter writer = new BufferedWriter(stringWriter)){
            try{
                tp.process(map,writer);
                writer.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(stringWriter.toString().getBytes()));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param configurer
     * @param templateVos
     * @param out
     * @param mapList
     * @throws Exception
     */
    private static void generateAll(FreeMarkerConfigurer configurer,List<TemplateVo> templateVos,
                                    OutputStream out,List<Map<String,Object>> mapList)throws Exception{
        if(CollectionUtils.isEmpty(mapList)){
            throw  new RuntimeException("生成PDF数据为null");
        }

        ITextRenderer renderer = new ITextRenderer();
        //创建第一个模板赋值，剩余模板追加
        Document doc = generateDoc(configurer,templateVos.get(0).getTemplateName(),mapList.get(0));
        renderer.setDocument(doc,null);
        try {
            ITextFontResolver iTextFontResolver = renderer.getFontResolver();
            iTextFontResolver.addFont("static/fonts/simhei.ttf", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        }catch (Exception e){
            throw  new RuntimeException("加载字体异常");
        }
        renderer.layout();
        renderer.createPDF(out,false);
        int pdfNUm = 0;
        boolean firstPdfBol = true;
        for (int i = 0; i < templateVos.size(); i++) {
            String templateName = templateVos.get(i).getTemplateName();
            for (int j = 0; j < templateVos.get(i).getNum(); j++) {

                if(firstPdfBol && templateVos.get(0).getNum()>=1){
                    firstPdfBol = false;
                    continue;
                }
                pdfNUm++;
                try {
                    Document docAppend = generateDoc(configurer,templateName,mapList.get(pdfNUm));
                    renderer.setDocument(docAppend,null);
                    renderer.layout();
                    renderer.writeNextDocument();
                }catch (Exception e){
                    e.printStackTrace();
                    throw new RuntimeException("生成PDF写入模板失败！");
                }
            }
        }
        renderer.finishPDF();
    }

    /**
     * PDF下载
     * @param configurer  freemarker配置
     * @param templateVos  模板
     * @param mapList 模板参数集合
     * @param response
     * @param fileName
     */
    public static void download(FreeMarkerConfigurer configurer, List<TemplateVo> templateVos,List<Map<String,Object>> mapList,
                                HttpServletResponse response, String fileName){

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        try {
            response.setHeader("Content-Disposition","attachment;fileName="+
                    new String(fileName.getBytes("gb2312"),"ISO8859-1"));
        }catch (Exception e){
            e.printStackTrace();
        }
        try (ServletOutputStream out = response.getOutputStream()){
            generateAll(configurer,templateVos,out,mapList);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();;
        }
    }

    /**
     * 预览PDF
     * @param configurer
     * @param templateVos
     * @param mapList
     * @param response
     */
    public static void preView(FreeMarkerConfigurer configurer, List<TemplateVo> templateVos,List<Map<String,Object>> mapList,
                               HttpServletResponse response){
        try(ServletOutputStream outputStream = response.getOutputStream()){
            int sum = 0;
            if(CollectionUtils.isEmpty(templateVos) || CollectionUtils.isEmpty(mapList)){
                throw new Exception("生成PDF失败！！");
            }

            for (TemplateVo templateVo : templateVos) {
                sum += templateVo.getNum();
            }
            if(sum != mapList.size()) throw new Exception("生成PDF调用模板次数与PDF页面不一致！");
            generateAll(configurer,templateVos,outputStream,mapList);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void save(FreeMarkerConfigurer configurer, List<TemplateVo> templateVos,List<Map<String,Object>> mapList,
                            HttpServletResponse response, String fileName,String savePdfUrl){
        try{
            int sum = 0;
            if(CollectionUtils.isEmpty(templateVos) || CollectionUtils.isEmpty(mapList)){
                throw new Exception("生成PDF失败！");
            }
            for (TemplateVo templateVo : templateVos) {
                sum += templateVo.getNum();
            }
            if(sum != mapList.size()) throw new Exception("生成PDF调用模板次数与PDF页面不一致！");

            if(StringUtils.isBlank(savePdfUrl)){
                throw new RuntimeException("PDF创建失败！");
            }
            File file = new File(savePdfUrl);
            if(!file.exists()){
                if(!file.mkdir()){
                    throw new RuntimeException("创建PDF文件夹失败！");
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(savePdfUrl.concat(fileName)).getAbsoluteFile());
            generateAll(configurer,templateVos,fileOutputStream,mapList);
            fileOutputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("PDF保存失败！");
        }
    }
}
