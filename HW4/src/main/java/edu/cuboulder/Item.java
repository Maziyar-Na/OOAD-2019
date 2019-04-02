package edu.cuboulder;

public abstract class Item {
    private String title;
    private String subject;
    private Integer id;
    private boolean reserved;
    private boolean borrowed;
    ItemType type;



    public String getTitle() {
        return title;
    }
    public String getSubject(){
        return subject;
    }

    public Integer getId(){
        return id;
    }

    public ItemType getType(){
        return type;
    }
    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean isReserved(){
        return  reserved;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setreserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
