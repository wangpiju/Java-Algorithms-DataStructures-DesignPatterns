package design_pattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
    private List<Book> books;

    BookShelf(int maxsize) {
        this.books = new ArrayList<>(maxsize);
    }

    Book getBookAt(int index) {
        return books.get(index);
    }

    void appendBook(Book book) {
        books.add(book);
    }

    int getLength() {
        return books.size();
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
