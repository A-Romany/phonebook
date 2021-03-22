package service;

import persistance.Person;
import persistance.PhonebookSystemDAO;

import java.util.List;

public class PhonebookSystemService {
    private PhonebookSystemDAO phonebookSystemDAO;

    public PhonebookSystemService() {
        this.phonebookSystemDAO = new PhonebookSystemDAO();
    }

    public void addPerson(Person person){
        phonebookSystemDAO.addPerson(person);
    }

    public List<Person> getPersons(){
        System.out.println("here");
        List<Person> persons;
        persons = phonebookSystemDAO.getPersons();
        return persons;
    }
}
