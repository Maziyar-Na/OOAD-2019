//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: adding a patron requests by Admin comes here
//use of Java's Reflection capability
package service.userManagement;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Path("/usermanagement")
public class UserManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer addBook(RegVO rvo) throws  IllegalAccessException, InstantiationException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        Person p = Library.getInstance().getPerson(username);
        Class admin = p.getClass();
        Object obj = admin.newInstance();
        String methodName = "addPatron";
        try {
            Method method = admin.getMethod(methodName,  RegVO.class);
            Integer rv = (Integer)method.invoke(obj, rvo);
            return rv;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
