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

import static org.junit.Assert.assertThat;

public class PersonTest {
    Person tp1;


    @Test
    public void testConstructorWithParameters() {
        // Given
        Integer expectedAge = 37;
        String expectedName = "Waldo";
        LocalDate birthdayExpected = LocalDate.parse("07-08-1982");
        Person.Sex expectedSex = Person.Sex.MALE;
        String emailExpected = "wheresWaldo@gmail.com";

        // When
        Person person = new Person(expectedName, birthdayExpected, expectedSex, emailExpected);

        // Then

        String actualName = person.getName();
        Integer actualAge = person.getAge();
        Person.Sex actualSex = person.getGender();
        String actualEmail = person.getEmailAddress();
        LocalDate actualBirthday = person.getBirthday();

        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSex, actualSex);
        Assert.assertEquals(emailExpected, actualEmail);
        Assert.assertEquals(birthdayExpected, actualBirthday);
    }

    @Before
    public void setUp() throws Exception {
        tp1 = new Person("John Doe", LocalDate.of(1976, Month.JANUARY, 10), Person.Sex.MALE, "johndoe@gmail.com");
    }

    @Test
    public void setName() {
        String expectedName = "Ricardo Montana";
        tp1.setName("Ricardo Montana");
        String actual = tp1.getName();
        Assert.assertEquals(expectedName, actual);
    }

    @Test
    public void setBirthday() {
        LocalDate expected = LocalDate.of(1993, Month.APRIL, 22);
        tp1.setBirthday(expected);
        LocalDate actual = tp1.getBirthday();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setGender() {
        Person.Sex expected = Person.Sex.FEMALE;
        tp1.setGender(expected);
        Person.Sex actual = tp1.getGender();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setEmailAddress() {
        String expectedEmail = "JD455@hotmail.com";
        tp1.setEmailAddress(expectedEmail);
        String actualEmail = tp1.getEmailAddress();
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void print () {
        tp1.printPerson();
    }
}
