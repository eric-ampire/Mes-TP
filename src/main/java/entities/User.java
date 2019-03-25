package entities;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String adresse;
    private int age;

    private static List<User> oldUsers = new ArrayList<>();
    private static File file = new File("/home/eric-ampire/Projets/Programming/tpjava/src/main/resources/users.json");
    private static Gson gsonBuilder = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public User(String name, String adresse, int age) {
        this.name = name;
        this.adresse = adresse;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    private static List<User> getJsonContent(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        User[] users = gsonBuilder.fromJson(fileReader, User[].class);

        return Arrays.asList(users);
    }

    private static void rewriteTheFile(List<User> users) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        // Mettre le contenu du fichier json dans un arrayList
        String newContentFile = gsonBuilder.toJson(users);
        fileWriter.append(newContentFile);
        fileWriter.flush();
    }

    public void delete() throws Exception {
        oldUsers = getJsonContent(file);

        // Suppression de l'element
        ArrayList<User> users = new ArrayList<>(oldUsers);
        users.remove(this);

        // Mise a jour du fichier
        rewriteTheFile(users);
    }

    public boolean update(User newUser) throws Exception {
        oldUsers = getJsonContent(file);

        if (oldUsers.contains(this)) {
            int indexOldUser = oldUsers.indexOf(this);
            oldUsers.add(indexOldUser, newUser);

            return true;
        }

        return false;
    }

    public void insert() throws Exception {
        oldUsers = getJsonContent(file);

        // Ajout d'un nouvelle element
        ArrayList<User> users = new ArrayList<>();
        users.add(this);
        users.addAll(oldUsers);

        // Mise a jour du fichier
        rewriteTheFile(users);
    }

    public static void showAll() throws Exception {
        oldUsers = getJsonContent(file);
        for (User user: oldUsers) {
            System.out.println(user.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                name.equals(user.name) &&
                adresse.equals(user.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adresse, age);
    }

    @Override
    public String toString() {
        return "Nom : " + this.name + ", Adresse : " + this.adresse + ", Age: " + this.age;
    }
}
