package domain;

import java.sql.Date;

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
