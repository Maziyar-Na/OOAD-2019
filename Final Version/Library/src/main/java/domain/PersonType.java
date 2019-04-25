package domain;

public enum PersonType {
    PATRON,
    ADMIN,
    LIBRIAN;
    public static PersonType fromInteger(Integer x) {
        switch(x) {
            case 1:
                return PATRON;
            case 2:
                return ADMIN;
            case 3:
                return LIBRIAN;
        }
        return null;
    }

    public Integer toInteger() {
        switch(this) {
            case PATRON:
                return 1;
            case ADMIN:
                return 2;
            case LIBRIAN:
                return 3;
        }
        return null;
    }
}
