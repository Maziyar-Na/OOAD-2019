//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: convert the inventory related functions to strings to be executed on the database
package DAO;

import domain.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDao {

    private Connection conn = null;
    private ConnectionDao connectionDao;


    //say conncetion dao to get conected to db
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

    //add item to inventory
    public Integer addItem(Item item) {
        System.out.println("Placeholder for addItem\n");
        if (this.connect() == 0) {
            try {
                connectionDao.execute_other_query("INSERT INTO Book (book_name, author, isbn_num, date, type, available)" +
                        "VALUES ('" + item.getBook_name() + "', '" + item.getAuthor() + "', '" + item.getIsbn_num() +"', '"+item.getDate() +"','"+item.getType().toInteger()+"',"
                        + item.getAvailable() +")");
                System.out.println("[dbg]Item has been added\n");
                return 0;
            } catch (SQLException e) {
                System.out.println("SQL Exception in insert");
                e.printStackTrace();
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    //delete item from inventory
    public Integer deleteItem(Item item) {
        System.out.println("Placeholder for addItem\n");
        if (this.connect() == 0) {
            try {
                connectionDao.execute_other_query("DELETE FROM Book WHERE  isbn_num = '" + item.getIsbn_num() + "';");
                System.out.println("[dbg]Item has been deleted!\n");
                return 0;
            } catch (SQLException e) {
                System.out.println("SQL Exception in insert");
                e.printStackTrace();
                return -1;
            }
        }
        else {
            return -1;
        }

    }


    //searching items with the criteria defined in search form
    public List<BookVO> searchItems(BookVO bvo) {
        System.out.println("Placeholder for searchItems");
        List<BookVO> bvos = new ArrayList<BookVO>();
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted books!");
            try {
                String book_name , author , isbn_num ;
                java.sql.Date mdate;
                if (bvo.getBook_name() == null){
                    book_name = "";
                }
                else{
                    book_name = bvo.getBook_name();
                }
                if (bvo.getAuthor() == null){
                    author = "";
                }
                else{
                    author = bvo.getAuthor();
                }
                if (bvo.getIsbn_num() == null){
                    isbn_num = "";
                }
                else {
                    isbn_num = bvo.getIsbn_num();
                }
                if(bvo.getSince_date() == null){
                    mdate = new java.sql.Date(0, 0, 1);
                }
                else{
                    mdate = bvo.getSince_date() ;
                }
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Book WHERE book_name LIKE '%" + book_name + "%' AND author LIKE '%" +
                                author + "%' AND isbn_num LIKE '%" + isbn_num + "%' AND date >= '" + mdate +"';");
                while(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    BookVO svo = new BookVO();
                    svo.setBook_name(rs.getString("book_name"));
                    svo.setAuthor(rs.getString("author"));
                    svo.setIsbn_num(rs.getString("isbn_num"));
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






