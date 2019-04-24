package domain;

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
