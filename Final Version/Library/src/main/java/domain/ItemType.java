//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: definig an enum for different types of item that we have in inventory
package domain;

public enum ItemType {
    PUBLICATION,
    AUDIOPROGRAM,
    VISUALPROGRAM;
    public static ItemType fromInteger(int x) {
        switch(x) {
            case 1:
                return PUBLICATION;
            case 2:
                return AUDIOPROGRAM;
            case 3:
                return VISUALPROGRAM;
        }
        return null;
    }

    public Integer toInteger() {
        switch(this) {
            case PUBLICATION:
                return 1;
            case AUDIOPROGRAM:
                return 2;
            case VISUALPROGRAM:
                return 3;
        }
        return null;
    }
}
