package com.AabritiPradhan.SpringWithJdbc;

import com.AabritiPradhan.SpringWithJdbc.DAO.StudentsDAO;
import com.AabritiPradhan.SpringWithJdbc.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class SpringWithJdbcApplication {

	public static void main(String[] args) throws SQLException {

		ConfigurableApplicationContext context = SpringApplication.run(SpringWithJdbcApplication.class, args);
		Scanner sc = new Scanner(System.in);
		StudentsService ssd = context.getBean(StudentsService.class);

		String[] list = {"1. Add Students", "2. View Students", "3. Update Students", "4. Delete Student"};

		System.out.println("Welcome to the EduTrack!");
		System.out.println("This is the project I made using Spring core concepts and JDBC");
		System.out.println("-------------------------------------------");
		System.out.println("What do you want to do today?");
		System.out.println("-------------------------------------------");
		for(int i=0; i< list.length; i++){
			System.out.println(list[i]);
		}
		System.out.println("-------------------------------------------");

		boolean dontStop = true;

		while (dontStop){
			try {
				System.out.print("Your choice: ");
				int choose = sc.nextInt();
				sc.nextLine();
				System.out.println("-------------------------------------------");

				if(choose == 1){
					System.out.print("Enter ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Email: ");
					String email = sc.nextLine();

					System.out.print("Enter Marks: ");
					int marks = sc.nextInt();
					sc.nextLine();

					ssd.addStudent(id, name, email, marks);
				} else if (choose == 2) {
					ssd.viewStudent();
				} else if (choose == 3) {
					System.out.print("What do you want to change? ");
					String column = sc.nextLine();

					System.out.print("What is the ID of the student you want to change that data of? ");
					int id = sc.nextInt();
					sc.nextLine();

					String newValueString;
					int newValueInt;

					System.out.print("New value: ");
					if(column.equalsIgnoreCase("name") || column.equalsIgnoreCase("email")){
						newValueString = sc.nextLine();
						ssd.updateStudentString(column, id, newValueString);
					} else if (column.equalsIgnoreCase("marks")) {
						newValueInt = sc.nextInt();
						sc.nextLine();
						ssd.updateStudentInt(column, id, newValueInt);
					}else {
						System.out.println("This column does not exist, please try again!");
					}
				} else if (choose == 4) {
					System.out.print("What is the ID of the student you want to delete? ");
					int id = sc.nextInt();
					sc.nextLine();

					ssd.deleteStudent(id);
				}else {
					System.out.println("Choose either 1 or 2 or 3 or 4");
				}

				System.out.print("Do you still have another task?(yes/no) ");
				String anotherTask = sc.nextLine();

				if(anotherTask.equalsIgnoreCase("yes")){
					dontStop = true;
				} else if (anotherTask.equalsIgnoreCase("no")) {
					dontStop = false;
				}else {
					System.out.println("You did not type yes, so EduTrack has to stop! :(");
					dontStop = false;
				}
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
	}
}
