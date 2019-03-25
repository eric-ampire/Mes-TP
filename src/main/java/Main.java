import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String...args) throws Exception {
        User user = new User("Eric", "Adfd", 232);
        user.delete();
        user.insert();

        User.showAll();
    }
}
