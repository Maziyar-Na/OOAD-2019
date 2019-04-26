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
