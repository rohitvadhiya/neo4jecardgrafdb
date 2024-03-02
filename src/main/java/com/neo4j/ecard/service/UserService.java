package com.neo4j.ecard.service;

import com.neo4j.ecard.entity.User;
import com.neo4j.ecard.entity.UserContacts;
import com.neo4j.ecard.entity.UserContactsRelations;
import com.neo4j.ecard.payload.UserContactsListReq;
import com.neo4j.ecard.payload.UserContactsRelationReq;
import com.neo4j.ecard.payload.UserRequest;
import com.neo4j.ecard.repo.UserContactsRepository;
import com.neo4j.ecard.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UserContactsRepository userContactsRepo;


    public User createUser(UserRequest userRequest) {

        String currentUserreqnum = userRequest.getNumber();
        String currentUserReqName = userRequest.getName();
        List<UserContactsRelationReq> reqcontactslist = userRequest.getUserContacts();
        List<UserContacts> dbcontactlist = userContactsRepo.findAll();
        List<UserContactsRelations> listofrelations = new ArrayList<>();
        List<UserContactsRelationReq> userContactsRelationReqs = new ArrayList<>();

        User user = new User();
        if (findContact(currentUserreqnum, dbcontactlist)) {

            for (UserContactsRelationReq userRequestcontacts : userRequest.getUserContacts()) {
                UserContacts userContacts = new UserContacts();
                userContacts.setNumber(userRequestcontacts.getNumber());
                userContacts.setName(userRequestcontacts.getName());
                userContacts.setFlag(false);
                userContactsRepo.save(userContacts);

                UserContactsRelations userContactsRelations = new UserContactsRelations();
                userContactsRelations.setUserContacts(userContacts);
                listofrelations.add(userContactsRelations);
            }
            for (UserContacts userContacts : dbcontactlist) {
                if (userContacts.getNumber().equals(currentUserreqnum)) {
                    userContacts.setNumber(currentUserreqnum);
                    userContacts.setName(currentUserReqName);
                    userContacts.setFlag(true);
                    userContacts.setUserContactsList(listofrelations);
                    userContactsRepo.save(userContacts);
                }
            }
        } else {
            for (UserContactsRelationReq userRequestcontacts : userRequest.getUserContacts()) {
                UserContacts userContacts = new UserContacts();
                userContacts.setNumber(userRequestcontacts.getNumber());
                userContacts.setName(userRequestcontacts.getName());
                userContacts.setFlag(false);
                userContactsRepo.save(userContacts);

                UserContactsRelations userContactsRelations = new UserContactsRelations();
                userContactsRelations.setUserContacts(userContacts);
                listofrelations.add(userContactsRelations);
            }
            user.setNumber(userRequest.getNumber());
            user.setName(userRequest.getName());
            user.setFlag(true);
            user.setUserContacts(listofrelations);
            userRepo.save(user);
        }
        return user;

    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public boolean findContact(String currentuser, List<UserContacts> userContacts) {
        for (UserContacts userContacts1 : userContacts) {
            if (userContacts1.getNumber().equals(currentuser)) {
                return true;
            }
        }
        return false;
    }


//    public boolean userContactUpdate(Long id) {
//        Optional<UserContacts> user = userContactsRepo.findById(id);
//        user.get().setFlag(true);
//        return true;
//    }

//    public Long checkrequser(UserRequest userRequest) {
//        String currentUserreqnum = userRequest.getNumber();
//        List<UserContactsRelationReq> reqcontactslist = userRequest.getUserContacts();
//        List<UserContacts> dbcontactlist = userContactsRepo.findAll();
//
//        // fetch userdbcontacts
//        for (UserContacts dbuser : dbcontactlist) {
//
//            //find usereq presert in db or not
//            if (dbuser.getNumber().equals(currentUserreqnum)) {
//                return dbuser.getId();
//            }
//
//        }
//        return null;
//    }

}
