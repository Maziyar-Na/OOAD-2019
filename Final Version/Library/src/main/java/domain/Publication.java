//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: having items of type of publication in our system
package domain;

import java.util.Date;

public class Publication extends Item {

    //setting the type of item to PUBLICATION
    @Override
    public void setType(ItemType type) {
        this.type = ItemType.PUBLICATION;
    }

}
