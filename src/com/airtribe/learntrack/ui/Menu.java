package com.airtribe.learntrack.ui;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;


import java.util.*;

public class Menu {

        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

            int choice=0;

            do {
                try
                {
                System.out.println("\n*****===== MAIN MENU =====******");
                System.out.println("1. Student Management");
                System.out.println("2. Course Management");
                System.out.println("3. Enrollment Management");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {

                        case MenuOptions.MAIN_STUDENT :
                            studentMenu();
                             break;
                        case MenuOptions.MAIN_COURSE :
                            courseMenu();
                            break;
                        case MenuOptions.MAIN_ENROLLMENT :
                            enrollmentMenu();
                             break;
                        case MenuOptions.MAIN_EXIT :
                            System.out.println("Exiting...");
                            break;
                        default :

                            System.out.println("Invalid choice!");
                            sc.nextLine();

                    }
                }
                catch(Exception exception)
                {
                    System.out.println("Invalid input received . Try again from start..");
                    sc.nextLine();
                }

            } while (choice != MenuOptions.MAIN_EXIT);
        }


        static void studentMenu() {
            int choice;
            do {
                System.out.println("\n*****---Student Menu ---*****");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Deactivate Student");
                System.out.println("5. Back");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case MenuOptions.STUDENT_ADD :
                        addStudent();
                         break;
                    case MenuOptions.STUDENT_VIEW :
                        StudentService.viewAllStudents();
                        break;
                    case MenuOptions.STUDENT_SEARCH :
                        searchStudent();
                        break;
                    case MenuOptions.STUDENT_DEACTIVATE :
                        deactivateStudent();
                        break;
                    case MenuOptions.STUDENT_BACK:
                        System.out.println("Going back to main menu");
                        break;
                    default:
                        System.out.println("Invalid Option. Going back to main menu.");
                        break;

                }

            } while (choice != MenuOptions.STUDENT_BACK);
        }

        static void addStudent() {
            sc.nextLine();
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();


            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();

            System.out.print("Enter email ID: ");
            String email = sc.nextLine();

            System.out.print("Enter batch: ");
            String batch = sc.nextLine();

            if(email!=null) {
                StudentService.addStudent(firstName, lastName, email, batch);
            }
            else
            {
                StudentService.addStudent(firstName, lastName, batch);
            }
        }

        static void searchStudent() {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

           StudentService.lookUpStudent(id);
        }

        static void deactivateStudent() {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

          StudentService.deActivateStudent(id);
        }


        static void courseMenu() {
            int choice;
            do {
                System.out.println("\n*****--- Course Menu ---*****");
                System.out.println("1. Add Course");
                System.out.println("2. View Courses");
                System.out.println("3. Activate Course");
                System.out.println("4. Deactivate Course");
                System.out.println("5. Back");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case MenuOptions.COURSE_ADD : addCourse();
                    break;
                    case MenuOptions.COURSE_VIEW :
                        CourseService.listAllCourses();
                        break;
                    case MenuOptions.COURSE_ACTIVATE:
                        activateCourse();
                        break;
                    case MenuOptions.COURSE_DEACTIVATE:
                        deActivateCourse();
                        break;
                    case MenuOptions.COURSE_BACK:
                        System.out.println("Back to main menu...");
                        break;
                    default:
                        System.out.println("Invalid Option . Try again...");
                        sc.nextLine();
                }

            } while (choice != MenuOptions.COURSE_BACK);
        }

        static void addCourse() {
            sc.nextLine();

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Duration in weeks: ");
            int duration = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Course Description: ");
            String desc = sc.nextLine();

            CourseService.addCourse(duration,name,desc);
        }

    static void activateCourse()
    {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        CourseService.activeOrDeactivateCourse(id,true);
    }

    static void deActivateCourse()
    {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        CourseService.activeOrDeactivateCourse(id,false);
    }



        static void enrollmentMenu() {
            int choice;
            do {
                System.out.println("\n--- Enrollment Menu ---");
                System.out.println("1. Enroll Student");
                System.out.println("2. View Enrollments for Student");
                System.out.println("3. Complete Enrollment");
                System.out.println("4. Cancel Enrollment");
                System.out.println("5. Back");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case MenuOptions.ENROLL_ADD :
                        enrollStudent();
                        break;
                    case MenuOptions.ENROLL_VIEW :
                        viewEnrollments();
                        break;
                    case MenuOptions.ENROLL_COMPLETE:
                        completeEnrollment();
                        break;
                    case MenuOptions.ENROLL_CANCEL:
                        cancelEnrollment();
                        break;
                    case MenuOptions.ENROLL_BACK :
                        System.out.println("Back to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid option..Try again.");
                        sc.nextLine();

                }

            } while (choice != MenuOptions.ENROLL_BACK);
        }

        static void enrollStudent() {
            sc.nextLine();
            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();

            System.out.print("Enter Course ID: ");
            int cid = sc.nextInt();

            EnrollmentService.enrollStudent(cid,sid, new Date());
        }

        static void viewEnrollments() {
            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();

            EnrollmentService.viewAllEnrollmentsOfStudent(sid);
        }

        static void completeEnrollment() {
            System.out.print("Enter enrollment ID: ");
            int id = sc.nextInt();
            EnrollmentService.completeEnrollment(id);
        }

    static void cancelEnrollment() {
        System.out.print("Enter enrollment ID: ");
        int id = sc.nextInt();
        EnrollmentService.cancelEnrollment(id);
    }

}
