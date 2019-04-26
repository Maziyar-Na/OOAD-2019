//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: having the VisualProgram as well as publication in our library
package domain;

public class VisualProgram extends Item {

    //setting the type of item to VISUALPROGRAM
    @Override
    public void setType(ItemType type) {
        this.type = ItemType.VISUALPROGRAM;
    }
}
