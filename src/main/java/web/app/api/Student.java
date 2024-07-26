package web.app.api;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor for the Student class without id
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor for the Student class with id
    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Returns the id of the student
    public int getId() {
        return id;
    }

    // Sets the id of the student
    public void setId(int id) {
        this.id = id;
    }

    // Returns the first name of the student
    public String getFirstName() {
        return firstName;
    }

    // Sets the first name of the student
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Returns the last name of the student
    public String getLastName() {
        return lastName;
    }

    // Sets the last name of the student
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the email of the student
    public String getEmail() {
        return email;
    }

    // Sets the email of the student
    public void setEmail(String email) {
        this.email = email;
    }
}