package addressbookservice.util;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/address_book__service?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "PRAbhu@mysql";

    private DBConnection() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("DB Connection Failed", e);
        }
    }
}
