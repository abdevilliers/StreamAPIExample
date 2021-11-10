package com.chris.mainPck;

import com.chris.dao.BookDAO;
import com.chris.model.Book;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String args[]) {
        //getPriceDtls();
        //getTopSellingBooks();
        //leastLikedBooks();
        //priceSortAsc();
       // priceSortDesc();
        //getAllAuthorNames();
        //getAllTitleNames();
        //findByTitle("Harry");
        //findByAuthor("Rowling");
        //getCheapestBook();
        //getCostliestBook();
        //getAvgPrices();
        //getSumPrices();
        //getBookCount();
    }
    public static void getBookCount()
    {

            BookDAO bookDAO = new BookDAO();
            List<Book> bookList = bookDAO.getBookdtls();
            DoubleSummaryStatistics s=bookList.stream().
                    collect(Collectors.summarizingDouble(Book::getPrice));

            System.out.println(s.getCount());


    }
    public static void getCostliestBook()
    {
            BookDAO bookDAO = new BookDAO();
            List<Book> bookList = bookDAO.getBookdtls();
            DoubleSummaryStatistics s=bookList.stream().
                    collect(Collectors.summarizingDouble(Book::getPrice));

            System.out.println(s.getMax());


    }
    public static void getCheapestBook()
    {

            BookDAO bookDAO = new BookDAO();
            List<Book> bookList = bookDAO.getBookdtls();
            DoubleSummaryStatistics s=bookList.stream().
                    collect(Collectors.summarizingDouble(Book::getPrice));

            System.out.println(s.getMin());


    }
    public static void getSumPrices()
    {

            BookDAO bookDAO = new BookDAO();
            List<Book> bookList = bookDAO.getBookdtls();
            DoubleSummaryStatistics s=bookList.stream().
                    collect(Collectors.summarizingDouble(Book::getPrice));

            System.out.println(s.getSum());

    }
    public static void getAvgPrices()
    {

            BookDAO bookDAO = new BookDAO();
            List<Book> bookList = bookDAO.getBookdtls();
            DoubleSummaryStatistics s=bookList.stream().
                    collect(Collectors.summarizingDouble(Book::getPrice));
            System.out.println(s.getAverage());


    }
    //get total number of books
    public static void getTotalBooks() {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        Long ans = bookList.stream().map(book -> book.bookId).count();
        System.out.println(ans);
    }

    public static void getPriceDtls()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        DoubleSummaryStatistics s=bookList.stream().
                collect(Collectors.summarizingDouble(Book::getPrice));
        System.out.println(s.getAverage());
        System.out.println(s.getMax());
        System.out.println(s.getMin());
        System.out.println(s.getCount());
        System.out.println(s.getSum());
    }
    public static void getTopSellingBooks()
    {BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().sorted(new Comparator<Book>() {
            public int compare(Book b1,Book b2)
        {
            if(b1.ratings_count==b2.ratings_count)
            return 0;
            else if(b1.ratings_count<b2.ratings_count)
            {
                return 1;
            }
            return -1;
        }
    }).limit(3).collect(Collectors.toList()).forEach(b->System.out.println(b));
    }
    public static void leastLikedBooks()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().sorted(new Comparator<Book>() {
            public int compare(Book b1,Book b2)
            {
                if(b1.ratings_count==b2.ratings_count)
                    return 0;
                else if(b1.ratings_count<b2.ratings_count)
                {
                    return -1;
                }
                return 1;
            }
        }).collect(Collectors.toList()).forEach(b->System.out.println(b));
    }

    //Books in ascending order of price
    public static void priceSortAsc()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().sorted(new Comparator<Book>() {
            public int compare(Book b1,Book b2)
            {
                if(b1.price==b2.price)
                    return 0;
                else if(b1.price<b2.price)
                {
                    return -1;
                }
                return 1;
            }
        }).collect(Collectors.toList()).forEach(b->System.out.println(b));
    }
    public static void priceSortDesc()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().sorted(new Comparator<Book>() {
            public int compare(Book b1,Book b2)
            {
                if(b1.price==b2.price)
                    return 0;
                else if(b1.price<b2.price)
                {
                    return 1;
                }
                return -1;
            }
        }).collect(Collectors.toList()).forEach(b->System.out.println(b));
    }
    public static void getAllAuthorNames()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        String ans=bookList.stream().map(b->b.author).reduce((name1,name2)->{return name1+", "+name2;}).toString();
        System.out.println(ans);
    }

    public static void getAllTitleNames()
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        String ans=bookList.stream().map(b->b.title).reduce((name1,name2)->{return name1+", "+name2;}).toString();
        System.out.println(ans);
    }
    public static void findByTitle(String searchStr)
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().
                filter(x->x.title.indexOf(searchStr)!=-1).forEach(b->System.out.println(b));
    }
    public static void findByAuthor(String searchStr)
    {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.getBookdtls();
        bookList.stream().
                filter(x->x.author.indexOf(searchStr)!=-1).forEach(b->System.out.println(b));
    }

}
