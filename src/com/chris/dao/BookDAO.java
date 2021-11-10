package com.chris.dao;

import com.chris.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBookdtls()
    {
        /*
        public Integer bookId;
        public String title;
        public String author;
        public String isbn;
        public String language_code;
        public Integer ratings_count;
        public Double price;
        */

       List<Book> bookList=new ArrayList<>();



       bookList.add(new Book(1,"Harry Potter","J.K. Rowling","2113","ENG",1234,234.65));
        bookList.add(new Book(2,"Memoirs of a Geisha","Arthur Golden","21135","HIN",12345,534.65));
        bookList.add(new Book(3,"Love As A Foreign Language #5","J. Torres-Eric  Kim","21135546","ENG",12345,1034.65));
        bookList.add(new Book(4,"Persepolis  Volume 1","Marjane Satrapi","2113554675","ENG",100,103.65));
        bookList.add(new Book(5,"Clockwork (Cover to Cover)","Philip Pullman","2222222675","ESP",101,50.65));



        return bookList;
    }
}
