package service.reserveManagement;

import domain.*;
import domain.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/reservemanagement")
public class ReserveManagement {

    @Context
    private HttpServletRequest request;

    @POST
    @Path("/reserve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean reserve(List<BookVO> bvos) throws IOException, ClassNotFoundException {
        System.out.println("[dbg] yes we got here in the servlet!");
        HttpSession session = request.getSession(false);
        String session_usernaem = session.getAttribute("username").toString();
        if( session_usernaem.equals("")){
            return false ;
        }
        Person active = Library.getInstance().getPerson(session_usernaem);
        System.out.println("[dbg] here");
        System.out.println(bvos.size());
        System.out.println(bvos.get(0).getType());
        List<Item>items = Library.getInstance().getInventory().convert_BookVO_to_Item(bvos);
        System.out.println("[dbg] here2");
        System.out.println(items.toString());
        active.borrow(items);
        System.out.println("[dbg] here3");
        return true;
    }

}
