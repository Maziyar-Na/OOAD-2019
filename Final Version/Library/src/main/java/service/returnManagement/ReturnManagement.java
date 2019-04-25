package service.returnManagement;

import domain.*;
import domain.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Path("/returnmanagement")
public class ReturnManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/calculate_fee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public float calculate_fee(ReturnVO rvo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("[dbg] yes we got here in the servlet!");
        HttpSession session = request.getSession(false);
        if( session == null){
            return -1 ;
        }
        String session_username = session.getAttribute("username").toString();
        Person active = Library.getInstance().getPerson(session_username);
        Class librarian = active.getClass();
        Object obj = librarian.newInstance();
        System.out.println("[dbg] the name of the employee class is : " + librarian.getName());
        String methodName = "collectFee";
        try {
            Method method = librarian.getMethod(methodName, ReturnVO.class);
            float rv = (Float) method.invoke(obj, rvo);
            if(rv == -1)
                return -1;
            else
                return rv;
        } catch (NoSuchMethodException e) {
            System.out.printf("[dbg] There is no method called collectFee()!");
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e) {
            System.out.printf("[dbg] There is no method called collectFee()!");
            e.printStackTrace();
            return -1;
        }
    }

    @POST
    @Path("/return")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer Return(ReturnVO rvo) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("[dbg] yes we got here in the servlet!");
        HttpSession session = request.getSession(false);
        if( session == null){
            return -1 ;
        }
        String session_username = session.getAttribute("username").toString();
        Person active = Library.getInstance().getPerson(session_username);
        Class librarian = active.getClass();
        Object obj = librarian.newInstance();
        System.out.println("[dbg] the name of the employee class is : " + librarian.getName());
        String methodName = "returnBook";
        try {
            Method method = librarian.getMethod(methodName, ReturnVO.class);
            Integer rv = (Integer) method.invoke(obj, rvo);
            System.out.println("[dbg] " + rv);
            return rv;
        } catch (NoSuchMethodException e) {
            System.out.printf("[dbg] There is no method called returnBook()!");
            e.printStackTrace();
            return -1;
        } catch (InvocationTargetException e) {
            System.out.printf("[dbg] There is no method called returnBook()!");
            e.printStackTrace();
            return -1;
        }
    }

}
