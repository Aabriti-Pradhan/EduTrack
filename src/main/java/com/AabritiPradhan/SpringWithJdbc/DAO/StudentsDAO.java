package com.AabritiPradhan.SpringWithJdbc.DAO;

import com.AabritiPradhan.SpringWithJdbc.Model.StudentsModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentsDAO {

    public void addStudents(StudentsModel students) throws SQLException;
    public void viewStudents();
    public void updateStudentsInfo(String changeColumn, StudentsModel studentsModel);
    public void deleteStudent(StudentsModel studentsModel);
}
