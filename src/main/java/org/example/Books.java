package org.example;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults (level = AccessLevel.PRIVATE)

public class Books {
    String author;
    String bookName;
    int price;
    int amountOfBook;

    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", amountOfBook=" + amountOfBook +
                '}';
    }



//    @Override
//    public int compareTo(Object o) {
//        Books books = (Books) o;
//        if (books.getPrice() > this.price)
//            return 1;
//        else return 0;
//    }
}
