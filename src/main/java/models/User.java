package models;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                "lastName='" + getLastName() + '\'' +
                "email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}