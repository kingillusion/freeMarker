package com.king.modelpdf.service.impl;

import com.king.modelpdf.service.PDFService;
import com.king.modelpdf.utils.PDFUtils;
import com.king.modelpdf.vo.TemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PDFServiceImpl implements PDFService {

    @Autowired
    private FreeMarkerConfigurer configurer;
    @Override
    public void generatePdf(HttpServletRequest request, HttpServletResponse response,String basePath) {
        String path = basePath;
        //String path = "file:/F:/Doc";
        List<TemplateVo> templateVos = new ArrayList<>();
        List<Map<String,Object>> mapList = new ArrayList<>();
        ordinaryPage(templateVos,mapList,"index.ftl",path,request,response);
        PDFUtils.preView(configurer,templateVos,mapList,response);
    }
    private void ordinaryPage(List<TemplateVo> templateVos,List<Map<String,Object>> mapList,String templateName,
                              String basePath,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("basePath",basePath);
        templateVos.add(new TemplateVo(templateName,1));
        mapList.add(dataMap);
    }
}
