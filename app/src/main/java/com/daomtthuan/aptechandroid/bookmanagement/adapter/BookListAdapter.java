package com.daomtthuan.aptechandroid.bookmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.daomtthuan.aptechandroid.R;
import com.daomtthuan.aptechandroid.bookmanagement.adapter.holder.BookItemViewHolder;
import com.daomtthuan.aptechandroid.bookmanagement.entity.Book;

import java.util.List;

public class BookListAdapter extends BaseAdapter {
  private final Context context;
  private final int layout;
  private final List<Book> listBook;

  public BookListAdapter(Context context, int layout, List<Book> listBook) {
    this.context = context;
    this.layout = layout;
    this.listBook = listBook;
  }

  @Override
  public int getCount() {
    return this.listBook.size();
  }

  @Override
  public Book getItem(int position) {
    return this.listBook.get(position);
  }

  @Override
  public long getItemId(int position) {
    return this.listBook.get(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    BookItemViewHolder studentItem;
    if (convertView == null) {
      convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(this.layout, null);
      studentItem = new BookItemViewHolder(convertView);
      convertView.setTag(studentItem);
    } else {
      studentItem = (BookItemViewHolder) convertView.getTag();
    }

    Book book = this.listBook.get(position);
    studentItem.getLabelId().setText(String.valueOf(book.getId()));
    studentItem.getLabelTitle().setText(String.valueOf(book.getTitle()));
    if (book.getAuthor() == null) {
      studentItem.getLabelAuthor().setText(R.string.bookmanagement_unknown);
    } else {
      studentItem.getLabelAuthor().setText(String.valueOf(book.getAuthor()));
    }

    return convertView;
  }

  public void setListBook(List<Book> listBook) {
    this.listBook.clear();
    this.listBook.addAll(listBook);
    this.notifyDataSetChanged();
  }
}
