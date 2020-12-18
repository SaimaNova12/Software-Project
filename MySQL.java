
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQL {
   Statement statement=null;
   PreparedStatement preparedStatement=null;
   ResultSet result=null;
   Connection connect=null;
   Scanner sc = null;
   
   void databaseOperation(){
       try{
           connect = Assistant.getInstance();
           sc = new Scanner(System.in);
           
           //statement = connect.createStatement();
           //result = statement.executeQuery("SELECT * FROM students");
           preparedStatement = connect.prepareStatement("SELECT *FROM students WHERE blood=?");
           
           while(true){
           System.out.println("Insert a blood group of existing data\n");
           preparedStatement.setString(1,sc.nextLine());
           //System.out.println("Insert a id of existing data\n");
           //preparedStatement.setString(2,sc.nextLine());
           result = preparedStatement.executeQuery();
           
           if(result.next()){
           while(result.next()){
              
               
               System.out.println("Blood:"+result.getString("blood"));
               
               System.out.println("Obtainted marks:"+result.getString("obtained_marks"));
               
               System.out.println("Position:"+result.getString("position"));
           
  
           }
           }
           
           else 
          System.out.println("No Result Found");
           }
       
       } catch (ClassNotFoundException | SQLException ex){
           System.out.println("MyError:"+ex);
       }
       
       finally{
           Assistant.close();
       }
   }
}
