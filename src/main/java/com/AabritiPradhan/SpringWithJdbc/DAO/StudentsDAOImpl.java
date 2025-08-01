package com.AabritiPradhan.SpringWithJdbc.DAO;

import com.AabritiPradhan.SpringWithJdbc.Model.StudentsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component

public class StudentsDAOImpl implements StudentsDAO {

    @Autowired
    private DataSource dataSource; //Injecting bean of Database Connectivity

    //Creating add method

    @Override
    public void addStudents(StudentsModel students) throws SQLException {
        try(Connection conn = dataSource.getConnection()){ //checking if the database is connected successfully
            String query = "Insert into jdbcstudents (id, name, email, marks) value (?,?,?,?)"; //writing the query
            PreparedStatement prepStm = conn.prepareStatement(query); //preparing the query
            prepStm.setInt(1, students.getS_ID());      //giving the value to the ?'s
            prepStm.setString(2, students.getName());
            prepStm.setString(3, students.getEmail());
            prepStm.setInt(4, students.getMarks());
            prepStm.execute();                                        //executing the query
            System.out.println("Added Successfully!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void viewStudents() {
        try(Connection conn = dataSource.getConnection()){
            String query = "select * from jdbcstudents";
            PreparedStatement prepStmt = conn.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Email: " + rs.getString(3));
                System.out.println("Marks: " + rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateStudentsInfo(String changeColumn, StudentsModel sm) {

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement prepStmt = null;
            if(changeColumn.equalsIgnoreCase("name")){
                String query = "update jdbcstudents set name = ? where id = ?";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, sm.getName());
                prepStmt.setInt(2, sm.getS_ID());
            } else if (changeColumn.equalsIgnoreCase("email")) {
                String query = "update jdbcstudents set email = ? where id = ?";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, sm.getEmail());
                prepStmt.setInt(2, sm.getS_ID());
            } else if (changeColumn.equalsIgnoreCase("marks")) {
                String query = "Update jdbcstudents set marks = ? where id = ?";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setInt(1, sm.getMarks());
                prepStmt.setInt(2, sm.getS_ID());
            }else {
                System.out.println("This column does not exist!");
            }

            if(prepStmt != null){
                prepStmt.execute();
                System.out.println("Updated successfully!");
            }
            else {
                System.out.println("An error occurred while updating!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteStudent(StudentsModel studentsModel) {
        try(Connection conn = dataSource.getConnection()){
            String query = "Delete from jdbcstudents where id = ?";
            PreparedStatement prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, studentsModel.getS_ID());
            prepStmt.execute();
            System.out.println("Deleted successfully!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
