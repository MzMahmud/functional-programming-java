import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    public static long lastId = 0;
    public long id;
    public String name;
    public LocalDate dateOfBirth;
    public String school;

    public User(String name, LocalDate dateOfBirth, String school) {
        this.id = ++lastId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.school = school;
    }

    int getAge(){
        return  dateOfBirth.until(LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", school='" + school + '\'' +
                '}';
    }
}
