import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    final static String URL = "jdbc:postgresql://localhost:5432/demo";
    final static String USER = "postgres";
    final static String PASSWORD = "0000";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }


    public static void main() {
        Connection dbConnection = getConnection();
        if(dbConnection != null){
            System.out.println("Database Connected Successfully");
        }
    }
}