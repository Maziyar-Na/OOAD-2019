package domain;

import java.util.List;

public class AuthorSort implements SortInterface {
    public List<BookVO> sort(List<BookVO> items) {
        System.out.println("AuthorSort Placeholder\n ");
        BookVO temp = new BookVO();
        BookVO min = items.get(0);
        for (int i = 0; i < items.size(); i++) {
            for (int j = i; j < items.size(); j++) {

                if (items.get(j).getAuthor().compareTo(items.get(i).getAuthor()) < 0) {
                    temp = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, temp);
                }

            }
        }
        return items;
    }
}
