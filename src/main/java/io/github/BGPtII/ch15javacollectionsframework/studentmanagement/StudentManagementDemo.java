package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.studentmanagement;

public class StudentManagementDemo {

    public static void main(String[] args) {
        StudentManagement sM = new StudentManagement();
        sM.addStudent("Bob", "Joe");
        sM.addStudent("Mary", "Joe", LetterGrade.A);
        sM.addStudent("Billy", "Bob", LetterGrade.D_MINUS);
        sM.addStudent("Bob", "Applesauce");
        sM.addStudent("Steve", "Garlic", LetterGrade.C_PLUS);
        sM.addStudent("Sally", "Soo", LetterGrade.B_MINUS);
        sM.addStudent("Sally", "Silly", LetterGrade.C_MINUS);
        sM.addStudent("Tom", "Foolery", LetterGrade.D_PLUS);
        sM.addStudent("Fiona", "Tims");
        sM.addStudent("Kevin", "Nambles", LetterGrade.A_PLUS);
        System.out.println(sM.getStudentInformation());
        System.out.println();

        sM.changeGrade(5, LetterGrade.F);
        sM.removeStudent(1000);
        sM.removeStudent(8);
        sM.changeGrade(0, LetterGrade.F);
        System.out.println(sM.getStudentInformation());
    }
}
