package phonebook;

import persistance.Person;
import service.PhonebookSystemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhonebookSystemService service1 = new PhonebookSystemService();

        req.getRequestDispatcher("addPerson.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PhonebookSystemService phonebookSystemService = new PhonebookSystemService();




        //TODO
        //1. new PhonebookSystemService;
        //2. PhonebookSystemService create method addPerson
        //3. DAO create method addPerson, update
        //4. All person add

        //1. store user data to db
            //1. create method addPerson in DAO
            //2. create method addPerson in service
            //3. call service.addPerson from servlet
        //2. forward user to the "OK" page
            //1. create "OK" page
            //2. forward user (research)


        Person person = new Person();
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String name = req.getParameter("name");
        boolean nameB=false;

        if (name == null || name.trim().isEmpty()) {
            messages.put("name", "Please enter name");
        } else if (!name.matches("\\p{Alnum}+")) {
            messages.put("name", "Please enter letter  characters only");
        } else {
            person.setName(name);
            nameB=true;
        }
        person.setLastName(req.getParameter("lastName"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        person.setGender((req.getParameter("genderList").charAt(0)));
        person.setPhoneNumber(req.getParameter("phoneNumber"));

        if(nameB) {
            phonebookSystemService.addPerson(person);
        }
        else
            doGet(req, resp);
        //req.getRequestDispatcher("okAddPerson.jsp").forward(req,resp);

        req.setAttribute("messages", messages);
        req.setAttribute("personListInJSP", phonebookSystemService.getPersons()); //FIXME find out how to forward user on /persons
        req.getRequestDispatcher("allPersons.jsp").forward(req,resp);
        //TODO (if invalid) 1. Return form back to user
            //if invalid count
        //TODO 2. if invalid, there is a message on the form
        //TODO 3 and so on - if invalid surname - put a corresponding message on the form

    }
}
