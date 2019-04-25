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
