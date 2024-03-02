package com.neo4j.ecard.payload;

import com.neo4j.ecard.entity.UserContactsRelations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContactsListReq {
    private List<UserContactsRelations> listofnumber;
}
