package com.daomtthuan.aptechandroid.bookmanagement.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;
import com.daomtthuan.aptechandroid.bookmanagement.adapter.BookListAdapter;
import com.daomtthuan.aptechandroid.bookmanagement.database.Database;
import com.daomtthuan.aptechandroid.bookmanagement.database.provider.BookProvider;
import com.daomtthuan.aptechandroid.bookmanagement.entity.Book;

import org.jetbrains.annotations.NotNull;

public class BookManagementMainActivity extends AppCompatActivity {
  private Button buttonAdd;
  private GridView listBookList;

  private void initializeViews() {
    this.setTitle(R.string.bookmanagement_app_name);

    Database.initialize(BookManagementMainActivity.this);

    this.buttonAdd = this.findViewById(R.id.button_add);
    this.buttonAdd.setOnClickListener(this::onButtonAddClick);

    this.listBookList = this.findViewById(R.id.list_book_list);
    this.listBookList.setAdapter(new BookListAdapter(BookManagementMainActivity.this, R.layout.item_book, BookProvider.find()));
    this.listBookList.setOnItemClickListener(this::onBookItemClick);
    this.listBookList.setOnItemLongClickListener(this::onBookItemLongClick);
  }

  private boolean onBookItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
    AlertDialog.Builder builder = new AlertDialog.Builder(BookManagementMainActivity.this);
    builder.setMessage(R.string.bookmanagement_confirm_remove);
    builder.setPositiveButton("Yes", (dialog, which) -> {
      BookProvider.remove(adapterView.getItemIdAtPosition(i));
      Toast.makeText(BookManagementMainActivity.this, this.getResources().getText(R.string.bookmanagement_success), Toast.LENGTH_SHORT).show();
      ((BookListAdapter) this.listBookList.getAdapter()).setListBook(BookProvider.find());
    });
    builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
    AlertDialog dialog = builder.create();
    dialog.show();
    return true;
  }

  private void onBookItemClick(@NotNull AdapterView<?> adapterView, View view, int i, long l) {
    Intent intent = new Intent(BookManagementMainActivity.this, BookManagementEditActivity.class);
    intent.putExtra("id", adapterView.getItemIdAtPosition(i));
    this.startActivity(intent);
  }

  private void onButtonAddClick(View view) {
    this.startActivity(new Intent(BookManagementMainActivity.this, BookManagementAddActivity.class));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_bookmanagement_main);
    this.initializeViews();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    ((BookListAdapter) this.listBookList.getAdapter()).setListBook(BookProvider.find());
  }
}