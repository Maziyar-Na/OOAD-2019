package domain;

import java.util.Date;

public class Publication extends Item {

    public void setType(ItemType type) {
        this.type = ItemType.PUBLICATION;
    }

}
