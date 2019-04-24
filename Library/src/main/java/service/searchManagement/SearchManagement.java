package service.searchManagement;
import domain.*;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/searchmanagement")
public class SearchManagement {

//    @Context
//    private HttpServletRequest request;

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookVO> login(BookVO bvo) throws IOException, ClassNotFoundException {
        System.out.println("[dbg] yes we got here in the servlet!");
        List<BookVO> result = Library.getInstance().getInventory().search(bvo);
        return result ;
    }

}
