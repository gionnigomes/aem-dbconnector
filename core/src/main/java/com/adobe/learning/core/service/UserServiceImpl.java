package com.adobe.learning.core.service;

import com.adobe.learning.core.models.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = UserService.class)
public class UserServiceImpl implements UserService {

    @Reference
    private DatabaseService databaseService;

 /*   @Override
    public List<UserModel> getAllUser() {
        UserModel user = new UserModel();
        return user.getUsers();
    }*/

    @Override
    public List<UserModel> getUserDB() {
        try (Connection connection = databaseService.getConnection()) {
            String sql = "SELECT * FROM user_table";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.execute();
                try (ResultSet rs = ps.getResultSet()) {
                    List<UserModel> userList = new ArrayList<>();
                    while (rs.next()) {
                        UserModel user = new UserModel();
                        user.setNome(rs.getString(1));
                        user.setIdade(rs.getInt(2));
                        userList.add(user);
                        //resp.getWriter().write("name=" + rs.getString(1) + " age=" + rs.getInt(2) + "\n");
                    }
                    return userList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserModel> verifyUserNull(SlingHttpServletRequest req) {
        try {

            UserModel user = new UserModel();
            List<UserModel> userList = new ArrayList<>();
            String name = req.getParameter("username");

            if (name == null || name.isEmpty()) {
                userList = user.getUsers();
                List<UserModel> userTemp = new ArrayList<>();
                userTemp = userList;
                return userTemp;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    @Override
    public String strToJson(Object obj) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(obj);
    }

    @Override
    public void addUser(UserModel user) {

    }


}
