package DAO;
import domain.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class PersonDao {

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

    public List<Person>  loadPeople(){
        System.out.println("Placeholder for loadPeople\n");
        return null;
    }

    public Integer savePerson(Person person){
        System.out.println("Placeholder for savePerson");
        if (this.connect() == 0) {
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM User WHERE username = '" + person.getUsername() +"';");
                if (rs.next())
                    return -2;
                connectionDao.execute_other_query("INSERT INTO User (username, password, name, type)" +
                        "VALUES ('" + person.getUsername() + "', '" + person.getPassword() + "', '" + person.getName() +"', "+ person.getType().toInteger() +")");
                System.out.println("[dbg]Patron has been added\n");
                return 0;
            } catch (SQLException e) {
                System.out.println("SQL Exception in insert");
                e.printStackTrace();
                return -1;
            }
        }
        else {
            System.out.println("[dbg] cannot connect to db!");
            return -1;
        }
    }

    public Integer deletePerson(Integer id){
        System.out.println("Placeholder for deletePerson");
        return -1;
    }

    public UserVO checkPerson(UserVO uvo){
        System.out.println("Placeholder for loadPerson\n");
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted user!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM User WHERE username = '" + uvo.getUsername() + "'AND password = '" + uvo.getPassword() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the User!");
                    UserVO svo = new UserVO();
                    svo.setUsername(rs.getString("username"));
                    svo.setPassword(rs.getString("password"));
                    svo.setName(rs.getString("name"));
                    svo.setType(PersonType.fromInteger(rs.getInt("type")));
                    return svo;
                }
                else {
                    return null;
                }
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

    public boolean addBorrowedItems(Person person, BorrowedItem bitem){
        Integer userId , bookId ;
        System.out.println("Placeholder for loadPerson\n");
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted user!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM User WHERE username = '" + person.getUsername() + "'AND password = '" + person.getPassword() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the User!");
                    userId = rs.getInt("id");
                }
                else {
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return false;
            }
            System.out.println("[dbg] Now we are looking for the targeted item!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Book WHERE isbn_num = '" + bitem.getItem().getIsbn_num() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    bookId = rs.getInt("id");
                }
                else {
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return false;
            }
            System.out.println("[dbg] Now we are inserting the borrowed item!");
            try {
                connectionDao.execute_other_query("INSERT INTO Borrowed (book_id, user_id, borrowed_date, return_date, late_fee)\n" +
                        "VALUES ( "+ bookId +" , "+ userId +", '" + bitem.getBorrowDate()+ "', '" + bitem.getReturnDate()+"' , "+
                        bitem.getLateFee()+");");
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return false;
            }
            System.out.println("[dbg] Now we are decreasing the availability of item!");
            try {
                connectionDao.execute_other_query("UPDATE Book SET available = available - 1 WHERE id = "+ bookId+";");
                return true;
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return false;
            }
        }
        else {
            return false;
        }
    }

    public FeeVO calculateFee(ReturnVO rvo){
        Integer userId , bookId ;
        FeeVO fvo = new FeeVO() ;
        System.out.println("Placeholder for calculateFee\n");
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted user!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM User WHERE username = '" + rvo.getUsername() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the User!");
                    userId = rs.getInt("id");
                }
                else {
                    return null;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return null;
            }
            System.out.println("[dbg] Now we are looking for the targeted item!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Book WHERE isbn_num = '" + rvo.getIsbn_num() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    bookId = rs.getInt("id");
                }
                else {
                    return null;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return null;
            }
            System.out.println("[dbg] Now we are calculating the borrowed item late fee!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Borrowed WHERE user_id = '" + userId + "' AND book_id ='" + bookId +"';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    fvo.setReturn_date(rs.getDate("return_date"));
                    fvo.setLate_fee(rs.getFloat("late_fee"));
                    return fvo ;
                }
                else {
                    return null;
                }
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

    public Integer returnBook(ReturnVO rvo){
        Integer userId , bookId ;
        FeeVO fvo = new FeeVO() ;
        System.out.println("Placeholder for calculateFee\n");
        if (this.connect() == 0) {
            System.out.println("[dbg] Now we are looking for the targeted user!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM User WHERE username = '" + rvo.getUsername() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the User!");
                    userId = rs.getInt("id");
                }
                else {
                    return -1;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return -1;
            }
            System.out.println("[dbg] Now we are looking for the targeted item!");
            try {
                ResultSet rs = connectionDao
                        .execute_select("SELECT * FROM Book WHERE isbn_num = '" + rvo.getIsbn_num() + "';");
                if(rs.next()) {
                    System.out.println("[dbg] We got the Book!");
                    bookId = rs.getInt("id");
                }
                else {
                    return -1;
                }
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return -1;
            }
            System.out.println("[dbg] Now we are deleting the borrowed item!");
            try {
                connectionDao
                        .execute_other_query("DELETE FROM Borrowed WHERE user_id = '" + userId + "' AND book_id ='" + bookId +"';");
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return -1;
            }
            System.out.println("[dbg] Now we are increasing the availability of item!");
            try {
                connectionDao.execute_other_query("UPDATE Book SET available = available + 1 WHERE id = "+ bookId+";");
                return 0;
            } catch (SQLException e) {
                System.out.println("[dbg] SQL Exception happened!");
                e.printStackTrace();
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}
