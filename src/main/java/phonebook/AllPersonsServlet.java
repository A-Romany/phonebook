package phonebook;

import persistance.Person;
import service.PhonebookSystemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllPersonsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhonebookSystemService service1 = new PhonebookSystemService();

        List<Person> personList = service1.getPersons();

        req.setAttribute("personListInJSP", personList);

        req.getRequestDispatcher("allPersons.jsp").forward(req,resp);
    }
}
