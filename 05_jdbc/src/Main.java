// 1.import package
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //2. load and register
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        //3. create connection
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "0000";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        try {
            //4. create statement
            Statement statement = connection.createStatement();

            //5. execute statement
            ResultSet result = statement.executeQuery("SELECT * from students");

            //6. process the results
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int marks = result.getInt("marks");

                System.out.println(id + " " + name + " " + marks);
            }

            //7. Close
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
