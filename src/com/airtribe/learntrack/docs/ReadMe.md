**Project Description**

LearnTrack is a console menu based Student & Course Management System built using Core Java.
It will allow admins to manage:Students ,Courses & Enrollments


**How to compile and run**

Bash 
1.Go to project root dir 
2.javac menu.java 
3.java Menu

**Class Diagram**

```mermaid
classDiagram

%% ================= ENTITY =================

class Person {
  id
  firstName
  lastName
  email
}

class Student {
  batch
  active
}

class Trainer {
  trainerId
}

class Course {
  id
  courseName
  description
  durationInWeeks
  active
}

class Enrollment {
  id
  studentId
  courseId
  enrollmentDate
  status
}

Person <|-- Student
Person <|-- Trainer

%% ================= SERVICE =================

class StudentService {
  students
  addStudent()
  findStudent()
  listStudents()
  deactivateStudent()
}

class CourseService {
  courses
  addCourse()
  listCourses()
  activateCourse()
  deactivateCourse()
}

class EnrollmentService {
  enrollments
  enrollStudent()
  getEnrollments()
  cancelEnrollment()
  completeEnrollment()
}

%% ================= UTIL =================

class IdGenerator {
  studentIdCounter
  courseIdCounter
  enrollmentIdCounter
  getNextStudentId()
  getNextCourseId()
  getNextEnrollmentId()
}

%% ================= EXCEPTION =================

class EntityNotFoundException {
  message
}

%% ================= CONSTANTS =================

class CommonConstants {
  values
}

class AppConstants {
  values
}

class MenuOptions {
  values
}

%% ================= UI =================

class Menu {
  main()
}

%% ================= RELATIONSHIPS =================

StudentService --> Student
CourseService --> Course
EnrollmentService --> Enrollment

Enrollment --> Student
Enrollment --> Course

Menu --> StudentService
Menu --> CourseService
Menu --> EnrollmentService

StudentService --> IdGenerator
CourseService --> IdGenerator
EnrollmentService --> IdGenerator

StudentService --> EntityNotFoundException
CourseService --> EntityNotFoundException
EnrollmentService --> EntityNotFoundException

Menu --> MenuOptions
Menu --> AppConstants
Menu --> CommonConstants
