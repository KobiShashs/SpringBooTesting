package com.johnbryce.demo.repo;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.beans.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
//uses H2
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ForumRepositoryUnitTest {
    @Autowired
    	private ForumRepository repo;

    	@Test
    	public void testEmpty() {
    		assertTrue(repo.count() == 0);
    	}

    	@Test
    	public void testWithTwoForums() {
    		Person p1 = new Person();
    		p1.setName("Newbe 1");
    		p1.setGender("male");
    		p1.setAge(-10);

    		Person p2 = new Person();
    		p2.setName("Newbe 2");
    		p2.setGender("Female");
    		p2.setAge(-10);

    		Collection<Person> ppl1 = new ArrayList<Person>();
    		ppl1.add(p1);
    		ppl1.add(p2);

    		Forum f1 = new Forum("New Forum", ppl1);
    		repo.save(f1);

    		Person p3 = new Person();
    		p3.setName("Newbe 3");
    		p3.setGender("male");
    		p3.setAge(-10);

    		Person p4 = new Person();
    		p4.setName("Newbe 4");
    		p4.setGender("Female");
    		p4.setAge(-10);

    		Collection<Person> ppl2 = new ArrayList<Person>();
    		ppl2.add(p3);
    		ppl2.add(p4);

    		Forum f2 = new Forum("New Forum", ppl2);
    		repo.save(f2);

    		assertEquals(2, repo.count());
    	}
}
