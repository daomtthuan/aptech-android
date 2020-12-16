package com.daomtthuan.aptechandroid.bookmanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.daomtthuan.aptechandroid.bookmanagement.database.provider.BookProvider;
import com.daomtthuan.aptechandroid.bookmanagement.entity.Book;

import org.jetbrains.annotations.NotNull;

public class Database {
  private static final String DATABASE_NAME = "book_management";
  private static final int DATABASE_VERSION = 1;

  private static Database instance;
  private final SQLiteOpenHelper helper;

  private Database(Context context) {
    this.helper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
      @Override
      public void onCreate(@NotNull SQLiteDatabase database) {
        if (database.getVersion() != DATABASE_VERSION) {
          String createBook = "create table if not exists book(id integer not null primary key, title text not null, author text);";
          database.execSQL(createBook);
        }
      }

      @Override
      public void onUpgrade(@NotNull SQLiteDatabase database, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
          String dropBook = "drop table if exists book;";
          database.execSQL(dropBook);
          this.onCreate(database);
        }
      }
    };
  }

  public static void initialize(Context context) {
    Database.instance = new Database(context);
  }

  public static SQLiteOpenHelper getHelper() {
    return Database.instance.helper;
  }
}
