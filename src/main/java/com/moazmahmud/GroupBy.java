package com.moazmahmud;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupBy {
    public static void main(String[] args) {
        Util.users.stream()
                  .map(user -> user.name + " " + user.getAge())
                  .forEach(System.out::println);

        Map<Integer, List<User>> groupUsersByAge = Util.users.stream()
                                                             .collect(groupingBy(User::getAge));
        groupUsersByAge.forEach((age, users) -> System.out.println(age + " : " + users));


        // group users by age
        //      for each group
        //          convert the List<User> into List<String>
        Map<Integer, List<String>> groupUserNameByAge =
                Util.users.stream()
                          .collect(groupingBy(
                                  User::getAge,
                                  collectingAndThen(
                                          toList(),
                                          users -> users.stream()
                                                        .map(user -> user.name)
                                                        .collect(toList())
                                  )
                          ));
        System.out.println("groupUserNameByAge with collectingAndThen");
        groupUserNameByAge.forEach((age, userNames) -> System.out.println(age + " : " + userNames));

        // above work can be simplified into
        // group by age, map grouped users to name and make a list
        groupUserNameByAge = Util.users.stream()
                                       .collect(groupingBy(
                                               User::getAge,
                                               mapping(user -> user.name, toList())
                                       ));
        System.out.println("groupUserNameByAge with mapping");
        groupUserNameByAge.forEach((age, userNames) -> System.out.println(age + " : " + userNames));

        Map<String, String> commaSeperatedUserNamesBySchool =
                Util.users.stream()
                          .collect(groupingBy(
                                  user -> user.school,
                                  mapping(user -> user.name, joining(","))
                          ));
        System.out.println("commaSeperatedUserNamesBySchool with mapping");
        commaSeperatedUserNamesBySchool.forEach((school, userNames) -> System.out.println(school + " : " + userNames));
    }
}
