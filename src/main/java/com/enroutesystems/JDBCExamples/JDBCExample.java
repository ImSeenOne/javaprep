package com.enroutesystems.JDBCExamples;

import com.mysql.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JDBCExample {
     public static void main (String[] args) {

         log.info("Initiliazing DB Connection");

         Connection con = JDBCExample.openConnection("root","","enterprise");
         PersonEntity person = new PersonEntity("Justin", "Odisho");

         if(JDBCExample.preparedInsert(person, con)) {
             log.info("Person succesfully created and persisted using prepared statement");
         } else {
             log.error("Person not created nor saved");
         }

         person.setName("Adolf"); person.setLastname("Hitler");

         if(JDBCExample.insert(person,con)) {
             log.info("Person successful (but insecurely) created and persisted using regular statement");
         } else {
             log.error("Person not created nor saved");
         }

         ResultSet rs = JDBCExample.selectRS(con);
         log.info("Listing database records via ResultSet...");
         try {
             log.info("ID\tName\tLastname");
             while(rs.next())
                 log.info(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
         } catch (SQLException e) {
             log.error(e.toString());
         }

         log.info("Retrieving metadata from ResultSet...");
         try {
             ResultSetMetaData rsmd = rs.getMetaData();
             log.info("\tColumn quantity:");
             log.info("\t\t" + Integer.toString(rsmd.getColumnCount()));
             log.info("\tColumn names:");
             String columns = "\t\t";
             for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                 String comma = (i < rsmd.getColumnCount()) ? ", " : ".";
                 columns = columns + "`" + rsmd.getColumnLabel(i) + "`" + comma;
             }
             log.info(columns);
         } catch (SQLException e) {
             log.error(e.toString());
         }



     }

     private static ResultSet selectRS(Connection con) {
         ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees");
        } catch (SQLException e) {
            log.error((e.toString()));
        }
        return rs;
     }

     private static boolean insert(PersonEntity entity, Connection con) {
         String query = "INSERT INTO `employees` (`name`, `lastname`) VALUES ('"+entity.getName()+"','" + entity.getLastname() + "');";
         try {
             Statement stmt = con.createStatement();
             stmt.executeUpdate(query);
         } catch (SQLException e) {
             log.error(e.toString());
             return false;
         }
         return true;
     }

     private static boolean preparedInsert(PersonEntity entity, Connection con) {

         String query = "INSERT INTO employees(`name`, `lastname`) VALUES( ?, ?)";

         try {
             PreparedStatement preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, entity.getName());
             preparedStatement.setString(2, entity.getLastname());
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             log.error(e.toString());
             return false;
         }
         return true;
     }

     private static Connection openConnection(String username, String password, String database) {
         Connection con = null;
         try{
             con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/" + database, username, password);
         }catch(Exception e) {
             log.error(e.toString());
             return null;
         }
         return con;
     }
}
