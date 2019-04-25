package domain;

public class SortFactory {
    public static SortInterface getSortAction(SortType sortType){
        if (sortType == SortType.NAME){
            return new NameSort();
        } else if (sortType == SortType.DATE){
            return new DateSort();
        } else if (sortType == sortType.AUTHOR){
            return new AuthorSort();
        } else {
            return null;
        }
    }
}
