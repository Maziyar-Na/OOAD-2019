package service.reserveManagement;

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

@Path("/reservemanagement")
public class ReserveManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/reserve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean reserve(List<BookVO> bvos) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("[dbg] yes we got here in the servlet!");
        HttpSession session = request.getSession(false);
        if( session == null){
            return false ;
        }
        String session_usernaem = session.getAttribute("username").toString();
        Person active = Library.getInstance().getPerson(session_usernaem);
        List<Item>items = Library.getInstance().getInventory().convert_BookVO_to_Item(bvos);
        return active.borrow(items);
    }
}
