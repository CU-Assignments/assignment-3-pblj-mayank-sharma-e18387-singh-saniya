class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String courseName;
    private int totalSeats;
    private int enrolledStudents;
    private String prerequisite;

    public Course(String courseName, int totalSeats, String prerequisite) {
        this.courseName = courseName;
        this.totalSeats = totalSeats;
        this.prerequisite = prerequisite;
        this.enrolledStudents = 0;
    }

    public void enroll(String studentName, boolean hasPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= totalSeats) {
            throw new CourseFullException("Error: The course " + courseName + " is full.");
        }

        if (!hasPrerequisite) {
            throw new PrerequisiteNotMetException("Error: " + studentName + " has not completed the prerequisite " + prerequisite + " for " + courseName + ".");
        }

        enrolledStudents++;
        System.out.println(studentName + " has successfully enrolled in " + courseName + ".");
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        try {
            advancedJava.enroll("Alice", false);  // Prerequisite not met
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }

        try {
            advancedJava.enroll("Bob", true);  // Successful enrollment
            advancedJava.enroll("Charlie", true);  // Successful enrollment
            advancedJava.enroll("David", true);  // Course full
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
    }
}
