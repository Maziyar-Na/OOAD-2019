//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: to be able to sort search results based on Published dates.
package domain;

import java.util.List;

public class DateSort implements SortInterface {

    //sort based on Published dates
    public List<BookVO> sort(List<BookVO> items) {
        System.out.print("Date Sort Placeholder");
        BookVO temp = new BookVO();
        BookVO min = items.get(0);
        for (int i = 0; i < items.size(); i++) {
            for (int j = i; j < items.size(); j++) {

                if (items.get(j).getSince_date().compareTo(items.get(i).getSince_date()) < 0) {
                    temp = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, temp);
                }

            }
        }
        return items;
    }
}
