package com.adobe.learning.core.service;

import com.adobe.learning.core.models.UserModel;
import org.apache.sling.api.SlingHttpServletRequest;

import java.util.List;

public interface UserService {

    List<UserModel> getUserDB();
    List<UserModel> getUsers();
    List<UserModel> verifyUserNull(SlingHttpServletRequest req);
    String strToJson(Object obj);
    void addUser(UserModel user);
}
