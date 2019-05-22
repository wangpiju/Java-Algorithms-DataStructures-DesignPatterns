package design_pattern.Iterator;

public class Main {
    public  static void main(String[] args){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook( new Book("Arround the World"));
        bookShelf.appendBook( new Book("Bible"));
        bookShelf.appendBook( new Book("Cinderella"));
        bookShelf.appendBook( new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();

        while(it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
