package com.king.modelpdf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PDFService {

    void generatePdf(HttpServletRequest request, HttpServletResponse response,String basePath);
}
