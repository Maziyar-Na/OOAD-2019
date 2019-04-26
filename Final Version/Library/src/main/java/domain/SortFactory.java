//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: setting the sort behavior
package domain;

public class SortFactory {

    //inheriting the right sort behavior based on the sort type
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
