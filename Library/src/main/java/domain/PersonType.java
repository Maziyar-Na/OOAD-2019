package domain;

public enum PersonType {
    PATRON,
    ADMIN,
    LIBRIAN;
    public static PersonType fromInteger(int x) {
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
}
