package com.daomtthuan.aptechandroid.bookmanagement.entity;

import org.jetbrains.annotations.NotNull;

public class Book {
  private long id;
  private String title;
  private String author;

  public Book(long id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public Book(String title, @NotNull String author) {
    this.title = title;
    if (!author.isEmpty()) {
      this.author = author;
    }
  }

  public Book(String title) {
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
