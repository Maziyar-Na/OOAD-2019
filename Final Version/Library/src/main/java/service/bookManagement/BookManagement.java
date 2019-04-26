//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: adding and deleting a book requests by Employee comes here
//use of Java's Reflection capability

package service.bookManagement;

import domain.BookVO;
import domain.Library;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Path("/bookmanagement")
public class BookManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addBook(BookVO bvo) throws  IllegalAccessException, InstantiationException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        Person p = Library.getInstance().getPerson(username);
        Class employee = p.getClass();
        Object obj = employee.newInstance();
        String methodName = "addItem";
        try {
            Method method = employee.getMethod(methodName, BookVO.class);
            Integer rv = (Integer)method.invoke(obj, bvo);
            if(rv == -1)
                return false;
            else
                return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteBook(BookVO bvo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        Person p = Library.getInstance().getPerson(username);
        Class employee = p.getClass();
        Object obj = employee.newInstance();
        String methodName = "deleteItem";
        bvo.setAvailable(0);
        bvo.setType(1);
        try {
            Method method = employee.getMethod(methodName, BookVO.class);
            Integer rv = (Integer)method.invoke(obj, bvo);
            if(rv == -1)
                return false;
            else
                return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

}
