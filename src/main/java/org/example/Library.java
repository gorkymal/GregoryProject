package org.example;
import java.util.*;

public class Library {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Books> listOfBooks = new ArrayList<>();

        System.out.print("How many books are there in the library? Type the answer: ");
        int totalAmount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < totalAmount; i++) {
            String[] allInfo = scan.nextLine().split(",");
            Books books = new Books(allInfo[0].trim(), allInfo[1].trim(), Integer.parseInt(allInfo[2].trim()), Integer.parseInt(allInfo[3].trim())); //author, bookName, price, amountOfBook
            listOfBooks.add(books);
        }
        printAllInfo(listOfBooks);
        System.out.println("Tha maximum price of all books is " + getMaxPrice(listOfBooks));
        System.out.println("The minimum price of all books is " + getMinPrice(listOfBooks));
        System.out.println("The average price of all books is " + getAveragePriceOfAllBooks(listOfBooks));
        System.out.println("The directly sorted list of Authors: " + sortedDirectListOfAuthors(listOfBooks));
        System.out.print("The reversed sorted list of authors: ");
        sortedReversedListOfAuthors(listOfBooks);
        System.out.println();

    }

    public static void printAllInfo(ArrayList<Books> list) {
        for (Books printedBooks : list) {
            System.out.println(printedBooks.toString());
        }
    }

    public static int getMaxPrice(ArrayList<Books> list) {
        list.sort(Comparator.comparing(Books::getPrice));
        return list.get(list.size() - 1).getPrice();
    }

    public static int getMinPrice(ArrayList<Books> list) {
        list.sort(Comparator.comparing(Books::getPrice));
        return list.get(0).getPrice();
    }

    public static double getAveragePriceOfAllBooks(ArrayList<Books> list) {
        double sumOfPrices = 0;
        for (Books books : list) {
            sumOfPrices += books.getPrice();
        }

        return sumOfPrices / list.size();
    }

    public static void sortedReversedListOfAuthors(ArrayList<Books> list) {
        list.sort(Comparator.comparing(Books::getAuthor).reversed());

        for (Books book : list) {
            System.out.print(book.getAuthor() + " ");
        }
    }

    public static ArrayList<String> sortedDirectListOfAuthors(ArrayList<Books> list) {
        list.sort(Comparator.comparing(Books :: getAuthor));
        ArrayList<String> sortedAuthors = new ArrayList<>();
        for (Books book : list) {
            sortedAuthors.add(book.getAuthor());
        }
        return sortedAuthors;
    }
}

