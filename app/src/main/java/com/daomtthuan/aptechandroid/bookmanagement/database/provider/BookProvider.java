package com.daomtthuan.aptechandroid.bookmanagement.database.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.daomtthuan.aptechandroid.bookmanagement.database.Database;
import com.daomtthuan.aptechandroid.bookmanagement.entity.Book;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookProvider {
  private static final String TABLE = "book";
  private static final String COLUMN_ID = "id";
  private static final String COLUMN_TITLE = "title";
  private static final String COLUMN_AUTHOR = "author";
  private static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_TITLE, COLUMN_AUTHOR};
  private static final String WHERE_COLUMN_ID_EQUALS = COLUMN_ID + " = ?";

  public static long count() {
    long result = 0;
    SQLiteDatabase database = Database.getHelper().getReadableDatabase();
    Cursor cursor = database.rawQuery("select count(" + COLUMN_ID + ") as count from " + TABLE, null);
    if (cursor.moveToFirst()) {
      result = cursor.getLong(0);
    }
    cursor.close();
    return result;
  }

  public static @NotNull List<Book> find() {
    List<Book> result = new ArrayList<>();
    SQLiteDatabase database = Database.getHelper().getReadableDatabase();
    Cursor cursor = database.query(TABLE, ALL_COLUMNS, null, null, null, null, null);
    if (cursor.moveToFirst()) {
      do {
        result.add(new Book(cursor.getLong(0), cursor.getString(1), cursor.getString(2)));
      } while (cursor.moveToNext());
    }
    cursor.close();
    return result;
  }

  public static Book find(long id) {
    SQLiteDatabase database = Database.getHelper().getReadableDatabase();
    Cursor cursor = database.query(TABLE, ALL_COLUMNS, WHERE_COLUMN_ID_EQUALS, new String[]{String.valueOf(id)}, null, null, null);
    cursor.moveToFirst();
    Book result = new Book(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    cursor.close();
    return result;
  }

  public static long create(@NotNull Book book) {
    SQLiteDatabase database = Database.getHelper().getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(BookProvider.COLUMN_TITLE, book.getTitle());
    String author = book.getAuthor();
    if (author != null) {
      values.put(BookProvider.COLUMN_AUTHOR, author);
    }
    long result = database.insert(BookProvider.TABLE, null, values);
    database.close();
    return result;
  }

  public static long edit(@NotNull Book book) {
    SQLiteDatabase database = Database.getHelper().getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(BookProvider.COLUMN_TITLE, book.getTitle());
    String author = book.getAuthor();
    if (author != null) {
      values.put(BookProvider.COLUMN_AUTHOR, author);
    }
    long result = database.update(BookProvider.TABLE, values, WHERE_COLUMN_ID_EQUALS, new String[]{String.valueOf(book.getId())});
    database.close();
    return result;
  }

  public static long remove(long id) {
    SQLiteDatabase database = Database.getHelper().getWritableDatabase();
    long result = database.delete(BookProvider.TABLE, WHERE_COLUMN_ID_EQUALS, new String[]{String.valueOf(id)});
    database.close();
    return result;
  }
}
