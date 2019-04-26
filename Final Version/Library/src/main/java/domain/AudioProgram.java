//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: having the AudioPrograms as well as publication in our library
package domain;

public class AudioProgram extends  Item {

    //setting the type of item to AUDIOPROGRAM
    @Override
    public void setType(ItemType type) {
        this.type = ItemType.AUDIOPROGRAM;
    }

}
