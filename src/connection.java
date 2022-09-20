import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    private static Connection con;
    public static Connection getCon(){
        try {
            if(con==null){
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_fees","root","Krushna");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}

