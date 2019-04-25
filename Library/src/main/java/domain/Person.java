package domain;

import java.util.List;

public abstract class Person{
    private Integer id;
    private String name;
    private String username;
    private String password;
    private PersonType type;
    private Item item;
    private String dob;
    private String gender;
    private String email;
    private String phoneNumber;
    private Double outStandingFees;


    public void setOutStandingFees(Double feee){
        this.outStandingFees = outStandingFees;
    }

    public Double getOutStandingFees(){
        return outStandingFees;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return  phoneNumber;
    }

    public void setItem (Item item){
        this.item = item;
    }
    public Item getItem(){
        return item;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public String getDob(){return dob;}

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){return gender;}

    public void setEmail(String email){
        this.email = email;
    }

    public  String getEmail(){return email;}




    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public PersonType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean borrow(List<Item>items){
        System.out.println("PlaceHoler for borrow");
        return false;
    }

//    public Integer returnItem(){
//
//        return null;
//
//    }

}