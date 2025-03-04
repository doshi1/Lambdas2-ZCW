import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Person> peopleList = new ArrayList<>();


    public enum Sex{
        MALE,FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public Integer getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void printPerson(){
        System.out.println(String.format("Person Object {Name: %s, Birthday: %s, Gender: %s, EmailAddress: %s}\n", name, birthday, gender,emailAddress));
    }
}
