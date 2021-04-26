package com.jin.springboot.controller;

import com.jin.springboot.entity.Website;
import com.jin.springboot.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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



    @RequestMapping("/getAll")
    @ResponseBody
    public List<Website> getAll(HttpServletRequest request) {
        System.out.println("WebsiteController.getAll()");
        List<Website> websiteList = websiteService.getAll();
        System.out.println("websiteList => " + websiteList);
        return websiteList;
    }




//
//    @RequestMapping("/getAll")
////    @ResponseBody
//    public String getAll(HttpServletRequest request) {
//        System.out.println("WebsiteController.getAll()");
//        List<Website> websiteList = websiteService.getAll();
//        System.out.println("websiteList => " + websiteList);
//
//        request.setAttribute("websiteList", websiteList);
//        return "getAllSuccess";
//    }
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
//        return "addSuccess";
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
//        return "updateSuccess";
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
//        return "getByIdSuccess";
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
//        return "deleteSuccess";
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @RequestMapping("/save")
//    public String save(String name) {
//        System.out.println("WebsiteController.save() --> name: " + name);
//        return "success";
//    }
//
//
//
//
//    /**
//     *   POJO type
//     */
//    @RequestMapping("/update")
//    public String update(Website website) {
//        System.out.println("WebsiteController.update() --> " + website);
//        return "success";
//    }
//
//
//
//
//
//    /**
//     *   List<String> in POJO
//     */
//    @RequestMapping("/create1")
//    public String create1(Website website) {
//        System.out.println("WebsiteController.create1() --> " + website);
//        return "success";
//    }
//
//
//
//
//
//
//    /**
//     *   Map<String, String> in POJO
//     */
//    @RequestMapping("/create2")
//    public String create2(Website website) {
//        System.out.println("WebsiteController.create2() --> " + website);
//        return "success";
//    }
//
//
//
//
//
//
//    @RequestMapping("/count")
//    public String count(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//        String name= request.getParameter("name");
//        System.out.println(name);
//        System.out.println(request);
//        System.out.println(response);
//        System.out.println(session);
//        return "success";
//    }
//
//
//
//
//
//
//    @RequestMapping("/testRequestParam")
//    public String testRequestParam(@RequestParam(name = "name") String userName, @RequestParam(name = "age") Integer ageNumber) {
//        System.out.println("WebsiteController.testRequestParam() --> name: " + userName + ", age: " + ageNumber);
//        return "success";
//    }
//
//
//
//
//
//
//
//
//    @RequestMapping("/testPathVariable/{id}")
//    public String testPathVariable(@PathVariable("id") String ids) {
//        System.out.println("WebsiteController.testPathVariable() --> id: " + ids);
//        return "success";
//    }
//
//
//
//
//    /**************************
//     *   Response
//     *************************/
//    @RequestMapping("/testReturnString")
//    public String testReturnString() {
//        System.out.println("WebsiteController.testReturnString()");
//        return "success";
//    }
//
//
//
//
//
//
//    @RequestMapping("/testReturnVoid")
//    public void testReturnVoid(HttpServletResponse response) {
//        System.out.println("WebsiteController.testReturnVoid()");
//    }
//
//
//
//
//
//    @RequestMapping("/testModelAndView")
//    public ModelAndView testModelAndView() {
//        System.out.println("WebsiteController.testModelAndView()");
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("key","value ModelAndView");
//        mv.setViewName("testModelAndView");
//        return mv;
//    }
//
//
//
//
//
//    /**************************
//     *   Forward
//     *************************/
//    @RequestMapping("/testForward2Page")
//    public String testForward2Page() {
//        System.out.println("WebsiteController.testForward2Page()");
//        return "forward:/WEB-INF/page/success.jsp";
//    }
//
//
//
//    @RequestMapping("/testForward2Controller")
//    public String testForward2Controller() {
//        System.out.println("WebsiteController.testForward2Controller()");
//        return "forward:/website/testModelAndView";
//    }
//
//
//
//
//
//
//
//    /**************************
//     *   Redirect
//     *************************/
//    @RequestMapping("/testRedirect2Page")
//    public String testRedirect2Page() {
//        System.out.println("WebsiteController.testRedirect2Page()");
//        return "redirect:/redirect.jsp";
//    }
//
//
//
//    @RequestMapping("/testRedirect2Controller")
//    public String testRedirect2Controller() {
//        System.out.println("WebsiteController.testRedirect2Controller()");
//        return "redirect:/website/testModelAndView";
//    }
//
//
//
//
//
//
//
//
//
//    /**************************
//     *   Return json
//     *************************/
//    @RequestMapping("/testReturnJSON")
////    @ResponseBody
//    public Website testReturnJSON() {
//        System.out.println("WebsiteController.testReturnJSON()");
//        Website website = new Website();
//        website.setId(7);
//        website.setName("Test");
//        website.setUrl("www.test.com");
//        website.setCountry("JP");
//        return website;
//    }



}