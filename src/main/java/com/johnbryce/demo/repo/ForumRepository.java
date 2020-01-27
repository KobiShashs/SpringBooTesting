package com.johnbryce.demo.repo;

import com.johnbryce.demo.beans.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum,Long> {
}
