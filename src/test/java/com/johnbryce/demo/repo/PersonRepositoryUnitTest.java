package com.johnbryce.demo.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
//uses H2
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonRepositoryUnitTest {

    @Autowired
    	private PersonRepository repo;

    	@Test
    	public void testPersonAvgRange() {
    		assertTrue(repo.findPersonBetweenAge(100, 0).size() == 0);
    	}

    	@Test
    	public void testPersonCounts() {
    		assertTrue(repo.count() == 0);
    	}

}
