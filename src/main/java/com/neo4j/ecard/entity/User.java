package com.neo4j.ecard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node(labels = {"Number"})
public class User {
    @Id
    private String number;
    private boolean flag;
    @Relationship(type = "User_Friend", direction = Relationship.Direction.OUTGOING)
    private List<UserContactsRelations> userContacts;
}
