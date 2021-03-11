package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest(classes = CrudDemoApplication.class)
class CrudDemoApplicationTests {

    private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void getAllEmpRecordShould() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/emp/allRecord";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assert (status == 200);
    }

    @Test
    public void getEmpByEmpIdShould() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String url = "/emp/" + 2 + "";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assert (status == 200);
    }

    @Test
    public void getEmpFieldShould() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String url = "/emp/field";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assert (status == 200);
    }

//    @Test
//    public void testCreateEmpShould() throws Exception {
//        String data = objectMapper.writeValueAsString(new TestDataSource().getDataForTest());
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        String url = "/emp";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(url).accept(MediaType.APPLICATION_JSON_VALUE).content(data)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println(mvcResult.getResponse().getStatus());
////        assert (status == 200);
//    }
//
//    @Test
//    public void testCreateNewEmpShould() throws Exception {
//        String data = objectMapper.writeValueAsString(new TestDataSource().getDataForTest());
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        String url = "/emp";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON_VALUE).content(data)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println(mvcResult.getResponse().getStatus());
//    }
}
