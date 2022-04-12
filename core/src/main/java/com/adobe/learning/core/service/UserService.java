package com.adobe.learning.core.service;

import com.adobe.learning.core.models.User;
import org.apache.sling.api.SlingHttpServletRequest;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    List<User> verifyUserNull(SlingHttpServletRequest req);
    String strToJson(String str);
}
