package edu.cuboulder;

import java.sql.Connection;
import java.util.List;

public class InventoryDao {

    private String jdbcHost = null;
    private String dbName = null;
    private String userName = null;
    private String password = null;

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;
    private Integer port = null;


    public InventoryDao(String jdbcHost, String dbName, String userName, String password, Integer port) {
        this.jdbcHost = jdbcHost;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.port = null;
    }


    public Integer connect() {

        connectionDao = new ConnectionDao(jdbcHost, dbName, userName, password,port);
        conn = connectionDao.connect();
        if (conn != null) {
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


    public List<Item> searchItems(String criteria) {
        System.out.println("Placeholder for searchItems");
        return null;
    }


}






