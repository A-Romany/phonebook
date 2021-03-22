package persistance;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String lastName;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private Character gender;
    @Column
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person(String lastName, String name, Integer age, Character gender, String phoneNumber) {
        this.lastName = lastName;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }
}
