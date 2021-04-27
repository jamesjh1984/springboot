package com.jin.springboot.controller;

import com.jin.springboot.entity.Website;
import com.jin.springboot.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/website")
public class WebsiteController {


    @Autowired
    private WebsiteService websiteService;



    // http://localhost:8080/website/getAll
    @RequestMapping("/getAll")
    @ResponseBody // 直接输出json，不跳转
    public List<Website> getAll() {
        System.out.println("WebsiteController.getAll()");
        List<Website> websiteList = websiteService.getAll();

        System.out.println("websiteList => " + websiteList);
        return websiteList;
    }





    // http://localhost:8080/website/getById/1
//    @RequestMapping("/getById/{id}")
    @GetMapping("/getById/{id}")
    @ResponseBody // 直接输出json，不跳转
    public Website getById(@PathVariable Integer id) {
        System.out.println("WebsiteController.getById()");
        Website website = websiteService.getById(id);

        return website;
    }










    /**
     * 以下是跳转页面的代码，还没解决
     */

//    // http://localhost:8080/website/getAll02, 暂时还没解决跳转取值的问题
//    @RequestMapping("/getAll02")
//    public String getAll02(HttpServletRequest request) {
//        System.out.println("WebsiteController.getAll02()");
//
//        List<Website> websiteList = websiteService.getAll();
//        System.out.println("websiteList => " + websiteList);
//
//        request.setAttribute("websiteList", websiteList);
//        return "success.html"; // success.html
//    }
//
//
//
//
//
//
//
//    // add one row, and return this row to addSuccess.jsp
//    @RequestMapping("/add")
//    public String add(Website website, HttpServletRequest request) {
//        System.out.println("WebsiteController.add()");
//        websiteService.add(website);
//
//        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
//        List<Website> websiteList = new ArrayList<Website>();
//        websiteList.add(website);
//        request.setAttribute("websiteList", websiteList);
//        return "success.html"; // success.html
//    }
//
//
//
//
//
//    // update one row by id, and return this row to updateSuccess.jsp
//    @RequestMapping("/updateById")
//    public String updateById(Website website, HttpServletRequest request) {
//        System.out.println("WebsiteController.updateById()");
//        websiteService.updateById(website);
//
//        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
//        List<Website> websiteList = new ArrayList<Website>();
//        websiteList.add(website);
//        request.setAttribute("websiteList", websiteList);
//        return "success.html"; // success.html
//    }
//
//
//
//    // get one row by id, and return this row to getByIdSuccess.jsp
//    @RequestMapping("/getById")
//    public String getById(Integer id, HttpServletRequest request) {
//        System.out.println("WebsiteController.getById()");
//        Website website = websiteService.getById(id);
//
//        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
//        List<Website> websiteList = new ArrayList<Website>();
//        websiteList.add(website);
//        request.setAttribute("websiteList", websiteList);
//        return "success.html"; // success.html
//    }
//
//
//
//
//    // delete one row by id, and return this row to deleteSuccess.jsp
//    @RequestMapping("/deleteById")
//    public String deleteById(Integer id, HttpServletRequest request) {
//
//        // before delete, call getById() to return this row
//        Website website = websiteService.getById(id);
//
//        System.out.println("WebsiteController.deleteById()");
//        websiteService.deleteById(id);
//
//        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
//        List<Website> websiteList = new ArrayList<Website>();
//        websiteList.add(website);
//        request.setAttribute("websiteList", websiteList);
//        return "success.html"; // success.html
//    }
//
//





}