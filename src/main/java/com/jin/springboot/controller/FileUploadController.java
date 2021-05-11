package com.jin.springboot.controller;

import com.jin.springboot.utils.UploadUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {


    // Method 1: HttpServletRequest
    @RequestMapping("/upload01")
    public String upload01(HttpServletRequest request) throws IOException {
        String fileDesc = request.getParameter("fileDesc");
        System.out.println("fileDesc => " + fileDesc);
        String uploadFile = request.getParameter("uploadFile");
        System.out.println("uploadFile => " + uploadFile);

        request.getInputStream();

        return "success";
    }






    // Method 2: commons-fileupload, copy to webapp/upload folder
    @RequestMapping("/upload02")
    public String upload02(String fileDesc, MultipartFile uploadFile, HttpSession session) throws IOException {
//        System.out.println(fileDesc);
//        System.out.println(uploadFile.getOriginalFilename());

        // 1. get file name
        String fileName = uploadFile.getOriginalFilename();
        System.out.println("fileName => " + fileName);

        // 2. get file URL and webapp/upload path, then create a new file
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext => " + servletContext);
        String uploadPath = servletContext.getRealPath("upload");
        System.out.println("uploadPath => " + uploadPath);

        File targetFilePath = new File(uploadPath + '/' + fileName);
        System.out.println("targetFilePath => " + targetFilePath.toString());

        // 3. write to this new file
        uploadFile.transferTo(targetFilePath);


        return "success";
    }








    // Method 3: commons-fileupload, copy to webapp/upload folder, generate random directory and file name
    @RequestMapping("/upload03")
    public String upload03(String fileDesc, MultipartFile uploadFile, HttpSession session) throws IOException {
//        System.out.println(fileDesc);
//        System.out.println(uploadFile.getOriginalFilename());

        // 1. get a random file name
        String fileName = UploadUtils.getUUIDName(uploadFile.getOriginalFilename()); // get a random file name
        System.out.println("fileName => " + fileName);

        // 2. get a random directory path, then create a new file
        ServletContext servletContext = session.getServletContext();
        String uploadPath = servletContext.getRealPath("upload");
        System.out.println("uploadPath => " + uploadPath);

        File randomDirectoryPath = new File(uploadPath + '/' + UploadUtils.getDir()); // get a random directory name
        System.out.println("randomDirectoryPath => " + randomDirectoryPath.toString());
        if(!randomDirectoryPath.exists()) {
            randomDirectoryPath.mkdirs();
        }

        File targetFilePath = new File(randomDirectoryPath + "/" + fileName);
        System.out.println("targetFilePath => " + targetFilePath.toString());

        // 3. write to this new file
        uploadFile.transferTo(targetFilePath);


        return "success";
    }






    // Method 4: com.sun.jersey, upload to remote file server
    @RequestMapping("/upload04")
    public String upload04(String fileDesc, MultipartFile uploadFile, HttpSession session) throws IOException {

        // 1. define remote file server url
        String fileServerUrl = "http://localhost:8081/upload/";

        // 2. get a random file name
        String fileName = UploadUtils.getUUIDName(uploadFile.getOriginalFilename()); // get a random file name
        System.out.println("fileName => " + fileName);

        // 3. create Client
        Client client = Client.create();

        // 4. get connection
        WebResource resource = client.resource(fileServerUrl + fileName);
        System.out.println("resource => " + resource.toString());

        // 5. upload file
        resource.put(uploadFile.getBytes());


        return "success";
    }






    // 还未实现，之后研究客户端和服务器交互，可能会有solution
    // Method 5: com.sun.jersey, upload to remote file server, generate random directory and file name
//    @RequestMapping("/upload05")
//    public String upload05(String fileDesc, MultipartFile uploadFile, HttpSession session) throws IOException {
//
//        // 1. define remote file server url
//        String fileServerUrl = "http://localhost:8081/upload/";
//
//        // 2. get a random file name
//        String fileName = UploadUtils.getUUIDName(uploadFile.getOriginalFilename()); // get a random file name
//        System.out.println("fileName => " + fileName);
//
//
//
//        // 3. get a random directory path, then create a new file
//        File randomDirectoryPath = new File(fileServerUrl + '/' + UploadUtils.getDir()); // get a random directory name
//        System.out.println("randomDirectoryPath => " + randomDirectoryPath.toString());
//        if(!randomDirectoryPath.exists()) {
//            randomDirectoryPath.mkdirs();
//        }
//
//        File targetFilePath = new File(randomDirectoryPath + "/" + fileName);
//        System.out.println("targetFilePath => " + targetFilePath.toString());
//
//
//        // 4. create Client
//        Client client = Client.create();
//
//        // 5. get connection
//        WebResource resource = client.resource(targetFilePath.toString());
//        System.out.println("resource => " + resource.toString());
//
//        // 6. upload file
//        resource.put(uploadFile.getBytes());
//
//        return "success";
//    }



}
