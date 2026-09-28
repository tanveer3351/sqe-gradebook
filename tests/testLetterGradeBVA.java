import gradebook.GradeBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class testLetterGradeBVA {

    private final GradeBook gradeBook = new GradeBook();

    @Test
    void testLetterGradeInvalidBVA(){

        assertEquals("F",gradeBook.letterGrade(0));
        assertEquals("F",gradeBook.letterGrade(1));

        assertEquals("F",gradeBook.letterGrade(58));
        assertEquals("F",gradeBook.letterGrade(59));
        assertEquals("D",gradeBook.letterGrade(60));
        
        assertEquals("D",gradeBook.letterGrade(68));
        assertEquals("D",gradeBook.letterGrade(69));
        assertEquals("C",gradeBook.letterGrade(70));

        assertEquals("C",gradeBook.letterGrade(78));
        assertEquals("C",gradeBook.letterGrade(79));
        assertEquals("B",gradeBook.letterGrade(80));

        assertEquals("B",gradeBook.letterGrade(88));
        assertEquals("B",gradeBook.letterGrade(89));
        assertEquals("A",gradeBook.letterGrade(90));

        assertEquals("A",gradeBook.letterGrade(99));
        assertEquals("A",gradeBook.letterGrade(100));
        
    }


     @Test
    void testLetterGradeInvalidBVAMin() {
        assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.letterGrade(-1)
        );
    }

    @Test
    void testLetterGradeInvalidBVAMax(){
        assertThrows(
            IllegalArgumentException.class,
            () -> gradeBook.letterGrade(101)
        );
    }



}