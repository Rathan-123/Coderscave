import java.util.*;

// Class to represent a Student
class Student1 {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Map<String, Integer> courses; // Course ID to Grade mapping

    public Student1(String studentId, String firstName, String lastName, String email, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courses = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void enrollCourse(String courseId) {
        courses.put(courseId, null); // Initialize grade as null
    }

    public void setGrade(String courseId, int grade) {
        if (courses.containsKey(courseId)) {
            courses.put(courseId, grade);
        } else {
            System.out.println("Student is not enrolled in the course with ID: " + courseId);
        }
    }

    public Map<String, Integer> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phoneNumber + "\n" +
                "Courses: " + courses;
    }
}

// Class to represent a Course
class Course1 {
    private String courseId;
    private String courseName;

    public Course1(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + "\n" +
                "Course Name: " + courseName;
    }
}

// Class to represent the Student Information System
class StudentInformationSystem1 {
    private List<Student1> students;
    private List<Course1> courses;

    public StudentInformationSystem1() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student1 student) {
        students.add(student);
    }

    public void addCourse(Course1 course) {
        courses.add(course);
    }

    public void enrollStudent(String studentId, String courseId) {
        Student1 student = findStudentById(studentId);
        if (student != null) {
            student.enrollCourse(courseId);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void setGrade(String studentId, String courseId, int grade) {
        Student1 student = findStudentById(studentId);
        if (student != null) {
            student.setGrade(courseId, grade);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private Student1 findStudentById(String studentId) {
        for (Student1 student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student1 student : students) {
            System.out.println(student);
            System.out.println("--------------------");
        }
    }

    public void displayCourses() {
        for (Course1 course : courses) {
            System.out.println(course);
            System.out.println("--------------------");
        }
    }
}

public class StudentInformationSystemApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInformationSystem1 sis = new StudentInformationSystem1();

        // Adding courses to the system
        Course1 mathCourse = new Course1("MATH101", "Mathematics");
        Course1 csCourse = new Course1("CS101", "Computer Science");
        sis.addCourse(mathCourse);
        sis.addCourse(csCourse);

        // Adding students to the system
        Student1 student1 = new Student1("1001", "John", "Doe", "john.doe@example.com", "123-456-7890");
        Student1 student2 = new Student1("1002", "Jane", "Smith", "jane.smith@example.com", "987-654-3210");
        sis.addStudent(student1);
        sis.addStudent(student2);

        // Enrolling students in courses
        sis.enrollStudent("1001", "MATH101");
        sis.enrollStudent("1002", "CS101");

        // Setting grades for students
        System.out.print("Enter grade for student John Doe (MATH101): ");
        int mathGrade = scanner.nextInt();
        sis.setGrade("1001", "MATH101", mathGrade);

        System.out.print("Enter grade for student Jane Smith (CS101): ");
        int csGrade = scanner.nextInt();
        sis.setGrade("1002", "CS101", csGrade);

        // Displaying student and course information
        System.out.println("\nStudent Information:");
        sis.displayStudents();

        System.out.println("\nCourse Information:");
        sis.displayCourses();

        scanner.close();
    }
}
