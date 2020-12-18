/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


abstract class Assistant {
    private static Connection connection=null;
    static java.sql.Connection getInstance() throws SQLException, ClassNotFoundException 
    {
        if(connection==null){
          Class.forName("com.mysql.jdbc.Driver");
          connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/section_o3?"+"user=root");
        }
        return connection;
    }

    static void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
