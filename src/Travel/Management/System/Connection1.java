package Travel.Management.System;


import java.sql.*; // Is for the Connection class


//This class will connect our login credential frame to our database
//JDBC : Java Database Connectivity
//Steps in JDBC : 
//1. Register driver class
//2. Create Connection string
//3. Create statement
//4. Execute queries
//5. Close Connection
public class Connection1 {
    Connection c;
    Statement s;
    public Connection1(){
        try{
            //Class class has a static method forName()
            Class.forName("com.mysql.jdbc.Driver");
            //com.mysql.jdbc.Driver is situated inside the library mysql-connector-java-8.0.23.jar
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root","password90-");
            //Driver.Manager.getConnection("API_name:Language_name://IPaddress:port_number/database_name","user","pass");
            s = c.createStatement();
        }catch(Exception e){
            
        }
    }
}
