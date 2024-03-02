package com.neo4j.ecard.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContactsRelationReq
{
    private String number;
    private String name;
    private boolean flag;
}
