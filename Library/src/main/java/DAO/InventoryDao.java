package DAO;

import domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDao {

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;
    static Integer ID = 1;
    static Integer BN = 2; /* Book Name */
    static Integer AUTH = 3; /* Author */
    static Integer ISB = 4; /* ISBN */
    static Integer TYP = 5;
    static Integer AV  = 6;

    public Integer connect() {

        connectionDao = new ConnectionDao();
        try {
            conn = connectionDao.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("[dbg] connection to db successfully created!");
            return 0;
        } else {
            return -1;
        }

    }


    public Integer close(){
        try {
            conn.close();
        }catch(SQLException ex){  /* TODO: clean up */
            System.out.println(("SQLException : "+ ex.getMessage()));
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }
        return 0;

    }

    public Integer addItem(Item item) {
        String ins = "INSERT into BOOK (ID, BOOK_NAME, AUTHOR, ISBN_NUM, TYPE, AVAILABLE values (?, ?,?, ?, ?,? )";
        try{
            PreparedStatement ps = conn.prepareStatement(ins);
            ps.setInt(ID, item.getId());
            ps.setString(BN,item.getBook_name());
            ps.setString(AUTH, item.getAuthor());
            ps.setString(ISB, item.getIsbn_num());
            ItemType it = item.getType();

            switch(it){
                case PUBLICATION:
                    ps.setInt(TYP,1);
                    break;
                case AUDIOPROGRAM:
                    ps.setInt(TYP, 2);
                    break;
                case VISUALPROGRAM:
                    ps.setInt(TYP,3);
                    break;
                default:
                    ps.setInt(TYP,1);
                    break;

            }
            ps.execute();
        }catch(SQLException ex){
            System.out.println(("SQLException: "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }
        return 0;
    }


    public Integer deleteItem(Integer id) {    /* TODO:  possible refactoring here */
        try {
            String del = "DELETE from BOOK where ID = ?";
            PreparedStatement ps = conn.prepareStatement(del);
            ps.setInt(ID,id);
            ps.close();
            conn.close();

        }catch(SQLException ex){
            System.out.println(("SQLException: "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }
        return 0;
    }

    public Integer saveItem(Item item) {
            Integer dd = deleteItem(item.getId());
            Integer aa = addItem(item);

            return dd+aa;
    }

    public Item searchItem(String criteria) {

        System.out.println("Placeholder for search item");
        return null;

    }


    public List<BookVO> searchItems(BookVO bvo) {
        System.out.println("Placeholder for searchItems");
        List<BookVO> bvos = new ArrayList<BookVO>();
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted books!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Book WHERE book_name = '" + bvo.getBook_name() + "' AND author = '" +
                                bvo.getAuthor() + "' AND isbn_num = '" + bvo.getIsbn_num() + "' AND date >= '" + bvo.getSince_date() +"';");
                while(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    BookVO svo = new BookVO();
                    svo.setBook_name(rs.getString("book_name"));
                    svo.setAuthor(rs.getString("author"));
                    svo.setIsbn_num(rs.getInt("isbn_num"));
                    svo.setSince_date(rs.getDate("date"));
                    svo.setType(rs.getInt("type"));
                    svo.setAvailable(rs.getInt("available"));
                    bvos.add(svo);
                }
                return bvos;
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return null;
            }
        }
        else {
            return null;
        }
    }

}






