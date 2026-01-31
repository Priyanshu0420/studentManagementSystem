package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static String url="jdbc:postgresql://localhost:5432/studentDB";
    private static String user="postgres";
    private static String pass="admin@123";
    public static Connection fetchDB() throws SQLException{

        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("DRIVER not found "+e.getMessage());
        }

        return DriverManager.getConnection(url, user, pass);
        
    }
}


