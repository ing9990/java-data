package code.comparater;

import java.util.*;

/**
 * @author TaeWK
 */

public class Main {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("데미안","헤르만 헤세",20000));
        bookList.add(new Book("인간관계론","데일 카네기",12000));
        bookList.add(new Book("코스모스","칼 세이건",15000));
        bookList.add(new Book("어린왕자","생텍쥐페리",14000));

        Collections.sort(bookList,Comparator.comparing(Book::getName).reversed());

        bookList.forEach(System.out::println);

    }
}
