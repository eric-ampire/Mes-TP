package entities;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String adresse;
    private int age;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
