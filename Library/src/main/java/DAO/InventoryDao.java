package DAO;

import domain.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDao {

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;


    public Integer connect() {

        connectionDao = new ConnectionDao();
        try {
            conn = connectionDao.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("[dbg] conncetion to db successfully created!");
            return 0;
        } else {
            return -1;
        }

    }

    public Integer addItem(Item item) {
        System.out.println("Placeholder for addItem\n");
        return -1;
    }


    public Integer deleteItem(Integer id) {
        System.out.println("PlaceHolder for deleteItem\n");
        return -1;
    }

    public Integer saveItem(Item item) {
        System.out.println("Placeholder for saveItem\n");
        return -1;
    }

    public Item searchItem(String criteria) {
        System.out.println("PlaceHolder for searchItem");
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






