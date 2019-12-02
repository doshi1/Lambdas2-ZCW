import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class MainTest {

    Person  tp1, tp2, tp3, tp4, tp5;
    ArrayList<Person> myPeeps = new ArrayList<>(0);

    @Before
    public void setUp() throws Exception {
        tp1 = new Person("miral", LocalDate.of(2000, Month.JANUARY,22), Person.Sex.FEMALE,"mdoshi@xyz.com");
        tp2 = new Person("neel", LocalDate.of(2001, Month.FEBRUARY,1), Person.Sex.MALE,"omni@xyz.com");
        tp3 = new Person("meghal", LocalDate.of(1992, Month.MARCH,2), Person.Sex.MALE,"hgi@xyz.com");
        tp4 = new Person("jim", LocalDate.of(19933, Month.JULY,20), Person.Sex.MALE,"def@xyz.com");
        tp5 = new Person("jeel", LocalDate.of(1989, Month.DECEMBER,18), Person.Sex.FEMALE,"abc@xyz.com");
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp5);
    }
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printPersonsLocalClass1() {
        String expected = "Person Object{ Name: miral, Birthday: 2000-01-22 , Gender: FEMALE, EmailAddress: mirsdoshi@xyz.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        Main.printPersons(myPeeps, new checkForOver18());
        Assert.assertEquals(expected,systemOutRule.getLog());
    }

    @Test
    public void printPersonsLocalClass2() {
        String expected = "Person Object{ Name: Appolonia, Birthday: 1970-08-12, Gender: FEMALE, EmailAddress: Appy@gmail.com}";
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() > 35;
            }
        }
        Main.printPersons(myPeeps, new checkForOver18());
    }



    @Test
    public void printPersonsAnonymousClass() {
        String expected = "Person Object{ Name: Caesar, Birthday: 2001-03-07, Gender: MALE, EmailAddress: Cdogg@gmail.com}";
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        Main.printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
        Assert.assertEquals(expected,systemOutRule.getLog());

    }

    @Test
    public void printPersonsAnonymousClass2() {
        String expected = "Person Object{ Name: Caesar, Birthday: 2001-03-07, Gender: MALE, EmailAddress: Cdogg@gmail.com}\n\nPerson Object{ Name: Cleopatra, Birthday: 2003-05-22, Gender: FEMALE, EmailAddress: Cleo@gmail.com}\n\n";
        Main.printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
        Assert.assertEquals(expected, systemOutRule.getLog());
    }


    @Test
    public void printPersonsLambda () {
        String expected = "Person Object{ Name: Appolonia, Birthday: 1970-08-12, Gender: FEMALE, EmailAddress: Appy@gmail.com}\n\n";
        Main.printPersons(myPeeps, person -> person.getAge() >= 45 && person.getGender() == Person.Sex.FEMALE);
        Assert.assertEquals(expected, systemOutRule.getLog());
    }
}
