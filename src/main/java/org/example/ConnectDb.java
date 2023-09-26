package org.example;

import java.sql.*;

public class ConnectDb {
    public static Statement connect() throws SQLException {
        String usl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "sharipov";
        String password = "123";
        return DriverManager.getConnection(usl, username, password).createStatement();
    }
}
