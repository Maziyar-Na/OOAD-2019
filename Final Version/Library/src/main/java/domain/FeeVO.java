//authors: Sepideh Goodarzy, Maziyar Nazari
//purpose: this file only works as a data holder for passing the data elements between domain layer and data access layer
package domain;

import java.sql.Date;

//the data elements + getters an setters
public class FeeVO {
    Date return_date;
    float late_fee ;

    public Date getReturn_date() {
        return return_date;
    }

    public float getLate_fee() {
        return late_fee;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public void setLate_fee(float late_fee) {
        this.late_fee = late_fee;
    }

}
