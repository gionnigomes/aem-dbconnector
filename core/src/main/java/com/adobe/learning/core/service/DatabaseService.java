package com.adobe.learning.core.service;

import java.sql.Connection;

public interface DatabaseService {
    Connection getConnection();
}
