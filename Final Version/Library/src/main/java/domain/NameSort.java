package domain;

import java.util.ArrayList;
import java.util.List;

public class NameSort implements SortInterface {

    public List<BookVO> sort(List<BookVO> items) {

        BookVO temp = new BookVO();
        BookVO min = items.get(0);
        for (int i = 0; i < items.size(); i++){
            for (int j = i; j < items.size(); j++ ){

                if (items.get(j).getBook_name().compareTo(items.get(i).getBook_name()) < 0){
                    temp = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, temp);
                }

            }
        }
        System.out.println("Name sort placeholdert\n");
        return items;
    }
}
