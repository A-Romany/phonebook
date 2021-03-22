package service;

import persistance.Person;

public class ValidateSystem {

    public static boolean validatePerson (Person person){
        boolean validatePerson=false;
        while (!validatePerson) {
            if (person.getLastName() == null || person.getLastName() == "") {
                System.out.println("Please enter last name!!!");

                break;
            } else if (person.getName() == null || person.getName() == "") {
                System.out.println("Please enter name!!!");
                break;
            } else if (person.getAge() == null ||  person.getAge() < 10 || person.getAge() > 100) {
                System.out.println("Please enter correct AGE");
                break;
//            } else if (person.getPhoneNumber() == null || person.getPhoneNumber().length() != 10) {
//                System.out.println("Please enter correct PhoneNumber!");
//                break;
            } else if (person.getGender() != 'M' && person.getGender() != 'F') {
                System.out.println("Please enter correct Gender!");
                break;
            } else validatePerson = true;
        }
        return validatePerson;
    }
}
