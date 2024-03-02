package com.neo4j.ecard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Node(labels = {"Numbers"})
public class UserContacts {
    @NotNull
    @Id
    private String number;
    private boolean flag;
    private List<UserContactsRelations> userContactsList;
}
