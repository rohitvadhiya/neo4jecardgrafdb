package com.neo4j.ecard.repo;

import com.neo4j.ecard.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    User findByNumber(String num);

}
