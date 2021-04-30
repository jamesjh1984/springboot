package com.jin.springboot.controller;


import com.jin.springboot.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartApplication.class})
@AutoConfigureMockMvc
public class TestWebsiteController {

    private static Logger logger = LoggerFactory.getLogger(TestWebsiteController.class);


    @Autowired
    private MockMvc mockMvc;


    // WebsiteController.getAll()
    @Test
    public void test01() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/website/getById/2"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        logger.info("response status: {}", mvcResult.getResponse().getStatus());
        logger.info("response content: {}",mvcResult.getResponse().getContentAsString());

    }

}
