package com.jin.springboot.controller;

import com.jin.springboot.entity.Website;
import com.jin.springboot.model.ResultInfo;
import com.jin.springboot.service.WebsiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/website")
@Api(tags = "website API management")
public class WebsiteController {


    @Autowired
    private WebsiteService websiteService;



    // http://localhost:8080/website/getAll
    @RequestMapping("/getAll")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select all websites")
    public List<Website> getAll() {
        System.out.println("WebsiteController.getAll()");
        List<Website> websiteList = websiteService.getAll();

        System.out.println("websiteList => " + websiteList);
        return websiteList;
    }





    // http://localhost:8080/website/getById?id=9
    @RequestMapping("/getById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select one website by id")
    @ApiImplicitParam(name = "id", value = "website id", required = true, paramType = "path")
    public Website getById(@RequestParam(name = "id") Integer id) {
        System.out.println("WebsiteController.getById()");
        Website website = websiteService.getById(id);

        System.out.println("website => " + website);
        return website;
    }






    // http://localhost:8080/website/getByName?iname=Apple
    @RequestMapping("/getByName")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select one website by name")
    @ApiImplicitParam(name = "id", value = "website id", required = true, paramType = "path")
    public Website getByName(@RequestParam(name = "name") String name) {
        System.out.println("WebsiteController.getByName()");
        Website website = websiteService.getByName(name);

        System.out.println("website => " + website);
        return website;
    }






    // update one row by id, and return this row to updateSuccess.jsp
    @RequestMapping("/updateById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => update one website by id")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public Website updateById(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "url") String url,
                              @RequestParam(name = "country") String country) {
        System.out.println("WebsiteController.updateById()");

        Website website = new Website(id, name, url, country);

        System.out.println(website);

        websiteService.updateById(website);

        Website website1 = websiteService.getById(id);

        System.out.println("website => " + website1);
        return website1;
    }





    // add one row, and return this row to addSuccess.jsp
    @RequestMapping("/add")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => add one website")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public List<Website> add(@RequestParam(name = "id") Integer id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "url") String url,
                             @RequestParam(name = "country") String country) {
        System.out.println("WebsiteController.add()");

        Website website = new Website(id, name, url, country);

        System.out.println(website);

        websiteService.add(website);

        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
        List<Website> websiteList = new ArrayList<Website>();
        websiteList.add(website);

        return websiteList;
    }








    // http://localhost:8080/website/deleteById/9
    @RequestMapping("/deleteById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => delete one website")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public List<Website> deleteById(@RequestParam(name = "id") Integer id) {

        System.out.println("WebsiteController.deleteById()");
        websiteService.deleteById(id);

        return websiteService.getAll();
    }







    // add one row, and return this row to addSuccess.jsp
    @PostMapping("/add02")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => add one website")
    public List<Website> add02(@Valid Website website) { // @Valid: 表示对该参数进行校验
        System.out.println("WebsiteController.add02()");

        ResultInfo resultInfo = new ResultInfo();

        System.out.println(website);

        websiteService.add(website);

        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
        List<Website> websiteList = new ArrayList<Website>();
        websiteList.add(website);

        return websiteList;
    }







    // http://localhost:8080/website/getById2/10
    @RequestMapping("/getById02/{id}")
//    @GetMapping("/getById02/{id}")
    @ResponseBody // 直接输出json，不跳转
    public Website getById02(@PathVariable Integer id) {
        System.out.println("WebsiteController.getById02()");
        Website website = websiteService.getById(id);

        return website;
    }








    /**
     * 以下是跳转页面的代码，还没解决
     */

    // http://localhost:8080/website/getAll02, 暂时还没解决跳转取值的问题
    @RequestMapping("/getAll02")
    public String getAll02(HttpServletRequest request) {
        System.out.println("WebsiteController.getAll02()");

        List<Website> websiteList = websiteService.getAll();
        System.out.println("websiteList => " + websiteList);

        request.setAttribute("websiteList", websiteList);
        return "getAllSuccess"; // getAllSuccess.jsp
    }




}