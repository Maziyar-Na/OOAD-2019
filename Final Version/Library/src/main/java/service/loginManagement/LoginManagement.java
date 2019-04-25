package service.loginManagement;

import domain.Library;
import domain.Person;
import domain.PersonType;
import domain.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/loginmanagement")
public class LoginManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer login(UserVO uvo) throws IOException, ClassNotFoundException {
        System.out.println("[dbg] yes we got here in the servlet!");
        Person result = Library.getInstance().login(uvo);
        if(result != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uvo.getUsername());
            return result.getType().toInteger();
        }
        return -1;
    }

}
