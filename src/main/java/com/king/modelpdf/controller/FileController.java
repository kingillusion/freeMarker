package com.king.modelpdf.controller;

import com.king.modelpdf.service.PDFService;
import com.king.modelpdf.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.net.MalformedURLException;

@RestController
public class FileController {

    @Autowired
    private PDFService pdfService;
    @RequestMapping("/download")
    public void dealFile(HttpServletRequest request, HttpServletResponse response){
        try {
            String isPrint = request.getParameter("isPrint");
            String pdfId = request.getParameter("pdfId");
            //Tomcat路径
            //String path = request.getSession().getServletContext().getRealPath("/static/");
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static";
            if(path==null){
                //Weblogic路径
                path = request.getSession().getServletContext().getResource("/sattic/").getPath();
            }
            if(StringUtils.isNotBlank(pdfId)){
                Writer witer = response.getWriter();
                witer.close();
                return;
            }
            if("1".equals(isPrint)){
                response.setHeader("Content-disposition","inline");
            }else{
                response.setHeader("Content-disposition","attachment");
            }
            response.setContentType("application/pdf");
            pdfService.generatePdf(request,response,path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
