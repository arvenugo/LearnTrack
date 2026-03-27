**Why use ArrayList instead of Array?**

Array is mainly used when the size of the collection is fixed.
In the case of this project , the number of students , courses and enrollments is continuously changing during run time (dynamic). Array List is more suited for this purpose . 
Also ArrayList already has built in predefined methods for adding, removing elements from the list . This helps with writing cleaner code.

**Where static members are used?**

Static variables and static methods are mainly used in the service and util classes. 
The arrayList maintaining list of students , courses and enrollments in the service classes has been defined as static keeping in mind that only one copy of the list is needed for the entire application.
All the methods of the service classes have been made static to perform operation on the static list and for cleaner code.

In the IDGenerator , the ID counter has been made static as this variable needs to be incremented each time an object of student/course/enrollment is created. This variable is shared among all the objects of the class.

**Where inheritance is used?**

Student and Trainer classes are inheriting from Person class. This has helped in keeping common variables/attributes/methods in the base class (Person). This is being reused by the derived classes Student/Trainer.

