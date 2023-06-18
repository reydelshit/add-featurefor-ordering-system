
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhonl
 */
public class DBCONNECTION {
    public static Connection getConnection(){
         
        try{
            String dbRoot = "jdbc:mysql://";
            String hostName = "localhost:3306/";
            String dbName = "orderingsystem";
            String dbUrl = dbRoot+hostName+dbName;
            
            String hostUsername = "root";
            String hostPassword = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
            
            JOptionPane.showMessageDialog(null, "Connected to Database");
            
            return myConn;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Connection Error");
            
            return null;
        }
    }
    static Connection conns(){
        throw new UnsupportedOperationException("Not supported yet.");
    }


    }

    

    