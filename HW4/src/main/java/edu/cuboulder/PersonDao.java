package edu.cuboulder;
import java.sql.Connection;
import java.util.List;
public class PersonDao {

    /* This should be dynamically loaded but no time */
    private String jdbcHost = "localhost";
    private String dbName = "Library";
    private String userName = "admin";
    private String password = "ooad2019";
    private Integer port = 3306;
    private String TableName = "Person";

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;
    private Connection dbConn;

    private String InsertString = "Insert into %s ()";

    public PersonDao() {
    }


    public Integer connect() {

        connectionDao = new ConnectionDao(jdbcHost, dbName, userName, password,port);
        this.dbConn = connectionDao.connect();
        if (dbConn != null) {
            return 0;
        } else {
            return -1;
        }

    }


    public Integer savePeople(List<Person> people){
        System.out.println("Placeholder for SavePeople\n");
        return -1;
    }

    public List<Person>  loadPeople(){
        System.out.println("Placeholder for loadPeople\n");
        return null;
    }

    public Integer savePerson(Person person){
        return -1;
    }

    public Integer deletePerson(Integer id){
        System.out.println("Placeholder for deletePerson");
        return -1;
    }

    public Person loadPerson(String name, String password){
        System.out.println("Placeholder for loadPerson\n");
        return null;
    }


}
