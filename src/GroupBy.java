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
        groupUserNameByAge.forEach((age, userNames) -> System.out.println(age + " : " + userNames));
    }
}
