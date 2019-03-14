import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static Gson gsonBuilder = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void main(String...args) throws Exception {
        User user = new User("Eric", "Adfd", 232);
        writeToJson(user);
    }

    private static void writeToJson(User user) throws Exception {
        File file = new File("/home/eric-ampire/Projets/Programming/tpjava/src/main/resources/users.json");
        List<User> oldUsers = getJsonContent(file);

        // Ajout d'un nouvelle element
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.addAll(oldUsers);

        FileWriter fileWriter = new FileWriter(file);

        // Mettre le contenu du fichier json dans un arrayList
        String newContentFile = gsonBuilder.toJson(users);
        fileWriter.append(newContentFile);
        fileWriter.flush();
    }

    private static List<User> getJsonContent(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        User[] users = gsonBuilder.fromJson(fileReader, User[].class);

        return Arrays.asList(users);
    }
}
