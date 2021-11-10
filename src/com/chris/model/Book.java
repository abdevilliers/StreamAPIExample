package com.chris.model;

public class Book {

    public Integer bookId;
  public String title;
  public String author;
  public String isbn;
  public String language_code;
  public Integer ratings_count;
  public Double price;
  public Book(Integer bookId,String title, String author,String isbn,String language_code,Integer ratings_count,Double price)
  {
    this.bookId=bookId;
    this.title=title;
    this.author=author;
    this.isbn=isbn;
    this.language_code=language_code;
    this.ratings_count=ratings_count;
    this.price=price;

  }
  public double getPrice()
  {
    return this.price;
  }
  public String toString()
  {
    return this.bookId+" "+this.title+" "+this.ratings_count;
  }



}
