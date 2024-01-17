package demo;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Person {
    @Id
    private String uniqueID = UUID.randomUUID().toString();
    private String sanitaryCardNumber;
    private String firstName;
    private String lastName;

    private int age;
    private float height;

    private float weight;
    private String description;

    protected Person() {}

    public Person(String sanitaryCardNumber, String firstName, String lastName,
                  int age, String description, float height, float weight) {
        this.sanitaryCardNumber = sanitaryCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.description = description;
        this.height = height;
        this.weight = weight;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getSanitaryCardNumber() {
        return sanitaryCardNumber;
    }

    public void setSanitaryCardNumber(String sanitaryCardNumber) {
        this.sanitaryCardNumber = sanitaryCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uniqueID='" + uniqueID + '\'' +
                ", sanitaryCardNumber='" + sanitaryCardNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
