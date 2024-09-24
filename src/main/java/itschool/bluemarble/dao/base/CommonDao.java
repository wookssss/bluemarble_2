package itschool.bluemarble.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class CommonDao {
    // DB 접속 정보
    final static private String dbDriver = "org.postgresql.Driver";
    final static private String dbURL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    final static private String dbUser = "postgres";
    final static private String dbPassword = "1234";

    // 1. Connection 모듈화(연결)
    protected static Connection connect() throws SQLException {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Database driver loading failed");
        }

        try {
            Connection connection = DriverManager.getConnection(dbURL,dbUser,dbPassword);
            System.out.println("DB Connection [성공]");
            return connection;
        } catch (SQLException e){
            throw new SQLException("Fail to connect to database",e);
        }
    }
}
