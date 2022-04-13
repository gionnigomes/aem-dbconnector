package com.adobe.learning.core.dao;

import com.adobe.learning.core.models.UserModel;
import com.adobe.learning.core.service.DatabaseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = UserDao.class)
public class UserDaoImpl implements UserDao {

    @Reference
    private DatabaseService databaseService;

    @Override
    public List<UserModel> getUsers() {
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
}
