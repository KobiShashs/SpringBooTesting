package com.johnbryce.demo.client;

import com.johnbryce.demo.beans.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@JsonTest
public class ClientControllerUnitTest {

    @Autowired
    	private JacksonTester<Person> test;

    	@Test
    	public void testPersonJsonInfo() {
    		// perform both structural & content checks on JSON
    		try {
    			Person toCheckAgainst = new Person();
    			toCheckAgainst.setId((long) 2);
    			toCheckAgainst.setName("Eden");
    			toCheckAgainst.setAge(40);
    			toCheckAgainst.setGender(null);

    			// fetch REAL person from DB as JSON through REST
    			URL url = new URL("http://localhost:8080/person/info/2");
    			String json = "";
    			try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
    				json = in.readLine();
    				System.out.println("Got from server: " + json);
    			} catch (Exception e) {
    				fail("Failed connecting to REAL server");
    			}
    			// check structure & content
    			test.parse(json).assertThat().hasFieldOrProperty("age").hasFieldOrProperty("gender")
    					.isEqualTo(toCheckAgainst);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
}
