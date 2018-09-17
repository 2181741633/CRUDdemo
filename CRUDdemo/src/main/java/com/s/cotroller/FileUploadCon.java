package com.s.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileUploadCon {
    @RequestMapping("/fileupload")
    public void load(String name, MultipartFile file, HttpServletRequest request) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String contextPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        String filename = file.getOriginalFilename();

        String formatname = simpleDateFormat.format(new Date())
                + (int) (Math.random() * 1000)
                + filename.substring(filename.lastIndexOf(".")).trim();
        try {
            file.transferTo(new File(contextPath,formatname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
