package main;


import java.util.Scanner;
import dao.StudentDAO;
import Model.Student;

    public class MainApp {

        public static void main(String[] args) throws Exception {

            Scanner sc = new Scanner(System.in);
            StudentDAO dao = new StudentDAO();

            while (true) {

                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Update Student");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        dao.addStudent(new Student(name, age, course));
                        break;

                    case 2:
                        dao.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        dao.deleteStudent(id);
                        break;

                    case 4:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String newName = sc.nextLine();
                        dao.updateStudent(uid, newName);
                        break;

                    case 5:
                        System.exit(0);
                }
            }
        }
    }

