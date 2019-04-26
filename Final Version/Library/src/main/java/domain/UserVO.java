//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: this file only works as a data holder for passing the data from view layer to domain layer and also for passing the data between domain layer and data access layer
package domain;

//the data elements + getters an setters
public class UserVO {

    String username;
    String password;
    String name ;
    PersonType type;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public PersonType getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PersonType type) {
        this.type = type;
    }
}
