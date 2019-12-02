import org.junit.Before;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class PrintOlderThenTest{

    Person  tp1, tp2, tp3, tp4, tp5;
    ArrayList<Person> myPeeps = new ArrayList<>(0);
   // PrintOlderThan myRoster;

    @Before
    public void setUp() throws Exception {
        tp1 = new Person("miral", LocalDate.of(2000, Month.JANUARY, 22), Person.Sex.FEMALE, "mdoshi@xyz.com");
        tp2 = new Person("neel", LocalDate.of(2001, Month.FEBRUARY, 1), Person.Sex.MALE, "omni@xyz.com");
        tp3 = new Person("meghal", LocalDate.of(1992, Month.MARCH, 2), Person.Sex.MALE, "hgi@xyz.com");
        tp4 = new Person("jim", LocalDate.of(19933, Month.JULY, 20), Person.Sex.MALE, "def@xyz.com");
        tp5 = new Person("jeel", LocalDate.of(1989, Month.DECEMBER, 18), Person.Sex.FEMALE, "abc@xyz.com");
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp5);
    }
}
