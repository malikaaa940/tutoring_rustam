package hw.library;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();
        Book book1 = new Book("Picture of Dorian Gray", "Oscar Wilde", "fiction");
        Book book2 = new Book("Pride and Prejudice", "jane Austin", "romance");
        Book book3 = new Book("Cruel Prince", "Holy Black", "fantasy");
        Book book4 = new Book("Game of Thrones", "George R.R. Martin", "fantasy");
        Book book5 = new Book("Sword Catcher", "Cassandra Claire", "fantasy");
        Book book6 = new Book("Mortal Instruments", "Cassandra Claire", "fantasy");
        Book book7 = new Book("Oathbound", "Tracy Deon", "fantasy");

        lm.addBook(book1);
        lm.addBook(book2);
        lm.addBook(book3);
        lm.addBook(book4);
        lm.addBook(book5);
        lm.addBook(book6);
        lm.addBook(book7);
        lm.removeBook("Cruel Prince");
        lm.showAvailableBooks();
        lm.lendBook("Oathbound");
        lm.lendBook("Pride and Prejudice");
        lm.showBorrowedBooks();
        lm.returnBook("Oathbound");
        lm.showBorrowedBooks();
        lm.showAvailableBooks();
        lm.searchBook("Pride and Prejudice");
        lm.cloneAvailableBooks();
        lm.showSortedAuthors();
        lm.showSortedTitles();
        lm.showStatistics();
        System.out.println(lm.getTitleAuthorMap());
        System.out.println(lm.getLastAddedBooks(2));


    }
}