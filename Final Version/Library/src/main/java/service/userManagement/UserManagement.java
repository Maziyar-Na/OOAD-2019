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
        System.out.println("[dbg] yes we got here in the add user servlet!");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        Person p = Library.getInstance().getPerson(username);
        Class admin = p.getClass();
        Object obj = admin.newInstance();
        System.out.println("[dbg] the name of the employee class is : " + admin.getName());
        String methodName = "addPatron";
        try {
            Method method = admin.getMethod(methodName,  RegVO.class);
            Integer rv = (Integer)method.invoke(obj, rvo);
            return rv;
        } catch (NoSuchMethodException e) {
            System.out.printf("[dbg] There is no method called addPatron()!");
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e) {
            System.out.printf("[dbg] There is no method called addPatron()!");
            e.printStackTrace();
            return -1;
        }
    }
}
