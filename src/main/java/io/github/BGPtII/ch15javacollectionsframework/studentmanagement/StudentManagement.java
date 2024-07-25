package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.studentmanagement;

import java.util.HashMap;
import java.util.TreeMap;

public class StudentManagement {

    private TreeMap<Student, LetterGrade> studentToGrade;
    private HashMap<Integer, Student> idToStudent;

    public StudentManagement() {
        studentToGrade = new TreeMap<>();
        idToStudent = new HashMap<>();
    }

    private boolean addStudentHelper(String firstName, String lastName, LetterGrade letterGrade) {
        Student s = new Student(firstName, lastName);
        if (idToStudent.put(s.getId(), s) == null) {
            studentToGrade.put(s, letterGrade);
        }
        return false;
    }

    public boolean addStudent(String firstName, String lastName) {
        return addStudentHelper(firstName, lastName, LetterGrade.UNDEFINED);
    }

    public boolean addStudent(String firstName, String lastName, LetterGrade letterGrade) {
        return addStudentHelper(firstName, lastName, letterGrade);
    }

    public boolean removeStudent(int id) {
        Student s = idToStudent.get(id);
        if (s == null) {
            return false;
        }
        idToStudent.remove(id);
        studentToGrade.remove(s);
        return true;
    }

    public boolean changeGrade(int id, LetterGrade letterGrade) {
        Student s = idToStudent.get(id);
        if (s == null) {
            return false;
        }
        studentToGrade.put(s, letterGrade);
        return true;
    }

    public String getStudentInformation() {
        StringBuilder studentInformation = new StringBuilder();
        for (Student student : studentToGrade.keySet()) {
            studentInformation.append(student).append(": Current Grade = ").append(studentToGrade.get(student)).append("\n");
        }
        return studentInformation.toString();
    }

}
