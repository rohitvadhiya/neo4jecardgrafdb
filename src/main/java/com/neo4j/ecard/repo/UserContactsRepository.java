package com.neo4j.ecard.repo;

import com.neo4j.ecard.entity.UserContacts;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContactsRepository extends Neo4jRepository<UserContacts, String> {
}
