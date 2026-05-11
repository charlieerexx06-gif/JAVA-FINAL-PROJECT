package Entity;

public class Person {
    protected String name;
    protected String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}