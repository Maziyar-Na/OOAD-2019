//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: definig an enum for different types of sorts that we provide
package domain;

public enum SortType {
    NAME, AUTHOR, DATE;
    public static SortType fromInteger(Integer x) {
        switch(x) {
            case 1:
                return NAME;
            case 2:
                return AUTHOR;
            case 3:
                return DATE;
        }
        return null;
    }
}
