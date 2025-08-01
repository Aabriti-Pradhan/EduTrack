package com.AabritiPradhan.SpringWithJdbc.Service;

import com.AabritiPradhan.SpringWithJdbc.DAO.StudentsDAOImpl;
import com.AabritiPradhan.SpringWithJdbc.Model.StudentsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component

public class StudentsService {

    StudentsModel studentsModel = new StudentsModel();

    @Autowired
    private StudentsDAOImpl studentsDAO;

    //if choose ==1
    public void addStudent(int id, String name, String email, int marks) throws SQLException {
        studentsModel.setS_ID(id);
        studentsModel.setName(name);
        studentsModel.setEmail(email);
        studentsModel.setMarks(marks);

        studentsDAO.addStudents(studentsModel);
    }

    //if choose == 2
    public void viewStudent(){
        studentsDAO.viewStudents();
    }

    //if choose == 3 and column is name or email
    public void updateStudentString(String column, int id, String newValue){
        studentsModel.setS_ID(id);

        if(column.equalsIgnoreCase("name")){
            studentsModel.setName(newValue);
        } else if (column.equalsIgnoreCase("email")) {
            studentsModel.setEmail(newValue);
        }

        studentsDAO.updateStudentsInfo(column, studentsModel);
    }

    //if choose == 3 and column is marks
    public void updateStudentInt(String column, int id, int newValue){
        studentsModel.setS_ID(id);
        studentsModel.setMarks(newValue);

        studentsDAO.updateStudentsInfo(column, studentsModel);
    }

    public void deleteStudent(int id){
        studentsModel.setS_ID(id);

        studentsDAO.deleteStudent(studentsModel);
    }
}
