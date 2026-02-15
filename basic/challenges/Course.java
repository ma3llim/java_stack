public class Course {
    private String courseName;
    private String[] enrolledStudents;
    private int studentCount = 0;
    private static int maxCapacity = 30;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new String[maxCapacity];
    }

    public void enrollStudent(String studentName) {
        if (studentCount >= maxCapacity) {
            System.out.println("Cannot enroll " + studentName + ". Course is full!");
            return;
        }

        enrolledStudents[studentCount++] = studentName;
        System.out.println(studentName + " enrolled in " + courseName);
    }

    public void unEnrollStudent(String studentName) {
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (enrolledStudents[i].equals(studentName)) {
                found = true;

                // Shift elements left
                for (int j = i; j < studentCount - 1; j++) {
                    enrolledStudents[j] = enrolledStudents[j + 1];
                }

                enrolledStudents[--studentCount] = null;
                System.out.println(studentName + " removed from " + courseName);
                break;
            }
        }

        if (!found) {
            System.out.println(studentName + " not found.");
        }
    }

    public static void setMaxCapacity(int capacity) {
        if (capacity > 0) {
            maxCapacity = capacity;
            System.out.println("Max capacity set to " + maxCapacity);
        } else {
            System.out.println("Invalid capacity!");
        }
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Students Enrolled:");

        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + enrolledStudents[i]);
        }

        System.out.println("Total: " + studentCount + "/" + maxCapacity);
    }

    public static void main(String[] args) {
        Course.setMaxCapacity(2);

        Course javaCourse = new Course("Core Java");

        javaCourse.enrollStudent("Sameer");
        javaCourse.enrollStudent("Ravi");
        javaCourse.enrollStudent("Anita");

        javaCourse.displayCourseInfo();

        javaCourse.unEnrollStudent("Ravi");

        javaCourse.displayCourseInfo();
    }
}