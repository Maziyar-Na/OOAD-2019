package edu.cuboulder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class InventoryDao {

    private String jdbcHost = null;
    private String dbName = null;
    private String userName = null;
    private String password = null;

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;

    public InventoryDao(String jdbcHost, String dbName, String userName, String password){
        this.jdbcHost = jdbcHost;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    public Integer addItem(Item item){
        System.out.println("Placeholder for addItem\n");
        return -1;
    }


    public Integer deleteItem(Integer id){
        System.out.println("PlaceHolder for deleteItem\n");
        return -1;
    }

    public Integer saveItem(Item item){
        System.out.println("Placeholder for saveItem\n");
        return -1;
    }

    public Item searchItem(String criteria){
        System.out.println("PlaceHolder for searchItem");
        return null;
    }


    public List<Item> searchItems(String criteria){
        System.out.println("Placeholder for searchItems");
        return null;
    }

    
    public void connect() {

        connectionString = String.format("user=%s&password=%s",userName,password);
        urlString = String.format("jdbc:mysql//%s/%s?",jdbcHost,dbName);
        try{
            conn = DriverManager.getConnection(urlString+connectionString);
        }catch (SQLException ex){
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState :" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }

    }





}
