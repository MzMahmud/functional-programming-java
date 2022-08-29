package com.moazmahmud;

import java.time.LocalDate;
import java.util.Comparator;

public class User implements Comparable<User> {
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

    int getAge() {
        return dateOfBirth.until(LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "com.moazmahmud.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public int compareTo(User other) {
        // (com.moazmahmud.User u) -> u.name is important because without it java has no clue about the type of the Comparator<T>
        return Comparator.comparing((User u) -> u.name)
                         .thenComparingInt(User::getAge)
                         .thenComparing(u -> u.school)
                         .thenComparingLong(u -> u.id)
                         .compare(this, other);
    }
}
