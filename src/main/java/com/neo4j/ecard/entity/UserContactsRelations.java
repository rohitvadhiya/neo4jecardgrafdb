package com.neo4j.ecard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class UserContactsRelations
{
    @Id
    @GeneratedValue
    private Long id;
    @TargetNode
    private UserContacts userContacts;
}
