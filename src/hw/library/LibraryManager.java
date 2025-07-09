package hw.library;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class LibraryManager{

    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();


    public void addBook(Book book) {

        if (!availableBooks.contains(book)) {
            availableBooks.add(book);
            System.out.println("book " + book.getTitle() + " added");
        }else{
            System.out.println("book " + book.getTitle() + " already added");
        }
    }

    public void removeBook(String title){
        for(int i  = 0; i < availableBooks.size(); i++){
            Book book = availableBooks.get(i);
            if(book.getTitle().equalsIgnoreCase(title)){
                availableBooks.remove(i);
                System.out.println("book " + title + " removed");
            } else{
                System.out.println("book " + title + " not found");
            }
        };

    }

    public void showAvailableBooks(){

        System.out.println(availableBooks.toString());
    }

    public void showBorrowedBooks(){
        System.out.println(borrowedBooks.toString());
    }

    public void lendBook(String title){
        for (int i = 0; i < availableBooks.size(); i++) {
            Book book = availableBooks.get(i);
            if (book.getTitle().equals(title)) {
                availableBooks.remove(i);
                borrowedBooks.add(book);
                System.out.println("book " + book.getTitle() + " lended");
                return;
            } else{
                System.out.println("book " + title + " not found");
            }
        }
    }

    public void returnBook(String title){
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book book = borrowedBooks.get(i);
            if(book.getTitle().equals(title)){
                borrowedBooks.remove(book);
                availableBooks.add(book);
                System.out.println("book " + book.getTitle()+ " returned");
            } else{
                System.out.println("there is no such book");
            }
        }
    }

    public void searchBook(String title){
        for(int i = 0; i < availableBooks.size(); i++){
            Book book = availableBooks.get(i);
            if(book.getTitle().equals(title)){
                System.out.println("book " + book +" found");
            }else{
                System.out.println("there is no such book");
            }
        }
    }

    public void clearLibrary(){
        availableBooks.clear();
        borrowedBooks.clear();
        System.out.println("Library has been cleared");
    }

    public ArrayList<Book> cloneAvailableBooks(){

        ArrayList<Book> clonedAvailableBooks = new ArrayList<>();
        clonedAvailableBooks.addAll(availableBooks);
        return clonedAvailableBooks;
    }

    public void showSortedTitles(){
        ArrayList<String> titlesOnly = new ArrayList<>();
        for(int i  = 0; i < availableBooks.size(); i++){
            Book book = availableBooks.get(i);
            titlesOnly.add(book.getTitle());
        }
        Collections.sort(titlesOnly);
        System.out.println(titlesOnly);
    }

    public void showSortedAuthors(){
        ArrayList<String> authorsOnly = new ArrayList<>();
        for(int i = 0; i < availableBooks.size(); i++){
            Book book = availableBooks.get(i);
            authorsOnly.add(book.getAuthor());
        }
        Collections.sort(authorsOnly);
        System.out.println(authorsOnly);
    }

    public void showStatistics(){

        int totalBooks = availableBooks.size() + borrowedBooks.size();
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Total Books borrowed: " + borrowedBooks.size());
        System.out.println("Total Books available: " + availableBooks.size());

    }

    public HashMap<String,String> getTitleAuthorMap(){
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < availableBooks.size(); i++){
            Book book = availableBooks.get(i);
            map.put(book.getTitle(),book.getAuthor());
        }
        return map;
    }

    public LinkedList<Book> getLastAddedBooks(int n){

        LinkedList<Book> books = new LinkedList<>();
        int start = availableBooks.size() - n;
        for(int i = start; i < availableBooks.size(); i++){
            books.add(availableBooks.get(i));
        }
        return books;
    }
  }


