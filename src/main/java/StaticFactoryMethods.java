import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User {

    private static volatile User instance = null;

    private final String name;
    private final String email;
    private final String country;

    public static User createWithDefaultCountry(String name, String email) {
        return new User(name, email, "Argentina");
    }

    public static User getSingletonInstance(String name, String email, String country) {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User(name, email, country);
                }
            }
        }
        return instance;
    }

}



public class StaticFactoryMethods {

    public static void main(String[] args) {

        User user = User.createWithDefaultCountry("John", "john@domain.com");
        System.out.println(user);

        User user2 = User.getSingletonInstance("John", "john@domain.com", "Argentina");

        System.out.println(user2);


    }
}
