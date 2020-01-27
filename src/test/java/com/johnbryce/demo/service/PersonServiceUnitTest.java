package com.johnbryce.demo.service;

import com.johnbryce.demo.repo.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class PersonServiceUnitTest {

    //  @Autowired will inject the real thing...
    	@MockBean
    	private PersonRepository repo;

    	// this bean depends on 'repo' - and will have it mocked...
    	@Autowired
    	private PersonStatistics ps;

    	@Test
    	public void testPersonAvgByForum() {
    		System.out.println("DB repo is mocked:  " + ps.avgAge());
    		assertTrue(ps.avgAge() == 0);
    	}
}
