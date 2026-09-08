package gradebook;

public class ManualTest {
    public static void main(String[] args) {

        Student s = new Student("Ali", "101");
        

        s.addScore(0);
        
        
       

        GradeBook gb = new GradeBook();
        gb.addStudent(s);

        System.out.println("Scores: " + s.getScores());
        System.out.println("Sum: " + gb.sumScores(s));
        System.out.println("Average: " + gb.avgScores(s));
    }
}