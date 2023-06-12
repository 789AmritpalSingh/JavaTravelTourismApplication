package traveltourism.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // picking Driver class from library jar file
            connection = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem",
                    "root", "Amrit@2002");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
