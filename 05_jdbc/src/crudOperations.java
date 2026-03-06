import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class crudOperations {
    // create new a row
    public void createStudent(int id, String name, int marks){
        String query = "INSERT INTO students values(?,?,?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setInt(3, marks);

            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // reading a data
    public void readStudents(){
        String query = "SELECT * FROM students";

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getInt("marks"));
            }

            result.close();
            st.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // update the row
    public void updateStudent(int id, String name, int marks) {
        String query = "UPDATE students SET name=?, marks=? WHERE id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, marks);
            ps.setInt(3, id);

            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // delete the row
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        crudOperations crud = new crudOperations();

        // create
        crud.createStudent(3, "john",80);
        crud.createStudent(4, "paul",86);
        crud.createStudent(5, "uday",80);
        crud.createStudent(6, "jeevan",75);

        // read
        crud.readStudents();
        System.out.println();

        // UPDATE
        crud.updateStudent(5, "Johnny", 90);
        System.out.println();

        // DELETE
        crud.deleteStudent(5);
        System.out.println();

        // read again
        crud.readStudents();
    }
}