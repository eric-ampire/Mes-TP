
import entities.User;

public class Main {

    public static void main(String...args) throws Exception {
        User user = new User("Eric", "Adfd", 232);
        User anotherUser = new User("Ampire", "Adfdf", 12);

        user.insert();
        user.delete();
        user.update(anotherUser);

        User.showAll();
    }
}
