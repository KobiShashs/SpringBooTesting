package com.johnbryce.demo.dao;

import com.johnbryce.demo.beans.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonDAOUnitTest {

        @Autowired
    	private PersonDAO repo;

    	@Test
    	public void testPersonInvalidAge() {
    		Person p = new Person();
    		p.setName("Newbe");
    		p.setGender("male");
    		p.setAge(-10);
    		assertEquals(-999, repo.addPerson(p));
    	}

    	@Test
    	public void testPersonValidAge() {
    		Person p = new Person();
    		p.setName("Newbe");
    		p.setGender("male");
    		p.setAge(44);
    		assertEquals(1, repo.addPerson(p));
    	}

}
