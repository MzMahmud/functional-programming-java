import java.util.Comparator;

import static java.util.Comparator.*;

public class MaxMin {
    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println("users");
        System.out.println(Util.users);
        User youngestUser = Util.users.stream()
                                      .max(comparing(user -> user.dateOfBirth))
                                      .orElse(null);
        System.out.println("youngestUser");
        System.out.println(youngestUser);

        User oldestUser = Util.users.stream()
                                    .min(comparing(user -> user.dateOfBirth))
                                    .orElse(null);
        System.out.println("oldestUser");
        System.out.println(oldestUser);

        System.out.println("user names");
        Util.users.stream()
                  .map(u -> u.name)
                  .forEach(System.out::println);

        Comparator<String> firstStrLenThenReverseStr =
                comparingInt(String::length).thenComparing(comparing(Object::toString).reversed());

        String firstLongestName = Util.users.stream()
                                            .map(user -> user.name)
                                            .max(firstStrLenThenReverseStr)
                                            .orElseThrow(NoSuchFieldException::new);
        System.out.println("firstLongestName " + firstLongestName);

        String lastLongestName = Util.users.stream()
                                            .map(user -> user.name)
                                            .max(comparingInt(String::length).thenComparing(String::compareTo))
                                            .orElseThrow(NoSuchFieldException::new);
        System.out.println("lastLongestName " + lastLongestName);
    }
}
