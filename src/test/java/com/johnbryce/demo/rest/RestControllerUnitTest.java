package com.johnbryce.demo.rest;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RestControllerUnitTest {


   @Autowired
       private MockMvc mvc;

       @Test
       public void testPersonAvgWSValue() {
           try {
               ResultActions ra = mvc.perform(get("/person/age/avg"));
               ra.andExpect(status().isOk()).andExpect(content().string("0.0"))
                       .andExpect(content().contentType(MediaType.APPLICATION_JSON));
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       @Test
       public void testPersonAvgWSMatch() {
           try {

               ResultActions ra = mvc.perform(get("/person/age/avg"));
               BaseMatcher<String> bm = new BaseMatcher<String>() {

                   @Override
                   public void describeTo(Description d) {
                       d.appendText("Checking person avg age double value");
                   }

                   @Override
                   public boolean matches(Object value) {
                       if (value instanceof String) {
                           return Double.parseDouble((String) value) >= 0;
                       }
                       return false;
                   }
               };
               ra.andExpect(status().isOk()).andExpect(content().string(bm));
           } catch (Exception e) {
               e.printStackTrace();
           }

       }



}
