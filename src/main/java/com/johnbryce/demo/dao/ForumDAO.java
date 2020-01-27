package com.johnbryce.demo.dao;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.repo.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ForumDAO {

    @Autowired
    	private ForumRepository repo;

    	public long addForum(Forum f) {
    		return repo.save(f).getId();
    	}

    	public Iterable<Forum> getAll() {
    		return repo.findAll();
    	}

    	public Forum getById(long id) {
    		return repo.findById(id).orElse(null);
    	}
}
