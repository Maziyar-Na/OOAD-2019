package edu.cuboulder;
import java.sql.Connection;
import java.util.List;
public class PersonDao {

    private String jdbcHost = null;
    private String dbName = null;
    private String userName = null;
    private String password = null;

    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;
    private ConnectionDao connectionDao;


    public PersonDao(String jdbcHost, String dbName, String userName, String password) {
        this.jdbcHost = jdbcHost;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }


    public Integer connect() {

        connectionDao = new ConnectionDao(jdbcHost, dbName, userName, password);
        conn = connectionDao.connect();
        if (conn != null) {
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
        System.out.println("Placeholder for savePerson");
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
