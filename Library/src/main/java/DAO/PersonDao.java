package DAO;
import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.PersonType;
import java.util.Formatter;

public class PersonDao {

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;
    private Statement stmt = null;
    private ResultSet rs = null;

    static Integer ID = 1;
    static Integer USERNAME =2;
    static Integer PASSWD= 3;
    static Integer NAME = 4;
    static Integer DOB = 5;
    static Integer GENDER =6;
    static Integer EMAIL = 7;
    static Integer PHONE = 8;
    static Integer TYPE = 9;
    static Integer FEE = 10;


    public Integer connect() {

        connectionDao = new ConnectionDao();
        try {
            conn = connectionDao.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }

        if (conn != null) {
            System.out.println("[dbg] connection to db successfully created!");
            return 0;
        }

        return -1;

    }

    public Integer close(){
        try {
            conn.close();
        }catch(SQLException ex){  /* TODO: clean up */
            System.out.println(("SQLException : "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }
        return 0;

    }

    public List<Person>  loadPeople(){
        List<Person>  personList =  new ArrayList<Person>();
        String SELECTSTRING ="SELECT * FROM USER";
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECTSTRING);
            try{
                while (rs.next()){
                    Patron pat = new Patron();
                    pat.setId(rs.getInt(ID));
                    pat.setUsername(rs.getString(USERNAME));
                    pat.setName(rs.getString(NAME));
                    pat.setPassword(rs.getString(PASSWD));
                    pat.setOutStandingFees(rs.getDouble(FEE));
                    pat.setDob(rs.getString(DOB));
                    pat.setEmail(rs.getString(EMAIL));
                    int typ = rs.getInt(TYPE);

                    switch (typ) {
                        case 1:
                            pat.setType(PersonType.PATRON);
                            break;
                        case 2:
                            pat.setType(PersonType.ADMIN);
                            break;
                        case 3:
                            pat.setType(PersonType.LIBRIAN);
                            break;
                        default:
                            pat.setType(PersonType.PATRON);
                            break;
                    }
                    pat.setGender(rs.getString(GENDER));
                    pat.setPhoneNumber(rs.getString(PHONE));
                    pat.setOutStandingFees(rs.getDouble(FEE));
                    personList.add(pat);

                }
            }catch (Exception e){
                System.out.println("Got a problem with the query "+ e);
            }finally {
                try {
                    rs.close();
                    }catch (Throwable ignore){}

            }
        }
        catch(SQLException ex){
            System.out.println(("SQLException: "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }

        return personList;
    }

    public Integer savePerson(Person person){
        String q1 = "Insert into USER (ID, username, password, name, dob, gender, email, phoneNumber,type, fee) values(?,?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps = conn.prepareStatement(q1);
            ps.setInt(ID,person.getId());
            ps.setString(USERNAME,person.getUsername());
            ps.setString(PASSWD, person.getPassword());
            ps.setString(NAME,person.getName());
            ps.setDate(DOB, Date.valueOf(person.getDob()));
            ps.setString(GENDER, person.getGender());
            ps.setString(EMAIL, person.getEmail());
            ps.setString(PHONE, person.getPhoneNumber());
            ps.setDouble(FEE, person.getOutStandingFees());

            PersonType pt = person.getType();
            switch (pt){
                case ADMIN:
                    ps.setInt(TYPE,2);
                    break;
                case PATRON:
                    ps.setInt(TYPE,1);
                    break;
                case LIBRIAN:
                    ps.setInt(TYPE, 3);
                    break;
                default:
                    ps.setInt(TYPE,1);
                    break;
            }
            ps.execute();
            /*conn.close();*/

        }catch(SQLException ex){
            System.out.println(("SQLException: "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }

        return 0;
    }

    public Integer deletePerson(Integer id){
        try {
            String del = "DELETE from USER where ID = ?";
            PreparedStatement ps = conn.prepareStatement(del);
            ps.setInt(ID,id);
            ps.execute();
            ps.close();


        }catch(SQLException ex){
            System.out.println(("SQLException: "+ ex.getMessage()));
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
            return -1;
        }


        return 0;
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
}
