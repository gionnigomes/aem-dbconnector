package com.adobe.learning.core.service;

import com.adobe.learning.core.models.User;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService  {


    @Override
    public List<User> getAllUser() {
        User user = new User();
        return user.getUsers();
    }

    @Override
    public List<User> verifyUserNull(SlingHttpServletRequest req) {
        try {

            User user = new User();
            List<User> userList = new ArrayList<>();
            String name = req.getParameter("username");

            if (name == null || name.isEmpty()) {
                userList = user.getUsers();
                List<User> userTemp = new ArrayList<>();
                userTemp = userList;
                return userTemp;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    @Override
    public String strToJson(String str) {
        return new Gson().toJson(str);
    }
}
