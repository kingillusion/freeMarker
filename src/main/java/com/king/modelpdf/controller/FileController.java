package com.king.modelpdf.controller;

import com.king.modelpdf.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FileController {

    @RequestMapping("/download")
    public void dealFile(HttpServletRequest request, HttpServletResponse response){


    }


    public static void main(String[] args) {
        User u = new User();
        u.setName("lll");
    }
}
