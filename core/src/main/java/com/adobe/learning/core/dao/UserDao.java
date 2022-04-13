package com.adobe.learning.core.dao;

import com.adobe.learning.core.models.UserModel;

import java.util.List;

public interface UserDao {

    List<UserModel> getUsers();

}
