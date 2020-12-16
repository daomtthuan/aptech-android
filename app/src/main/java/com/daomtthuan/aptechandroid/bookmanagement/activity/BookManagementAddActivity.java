package com.daomtthuan.aptechandroid.bookmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;
import com.daomtthuan.aptechandroid.bookmanagement.database.provider.BookProvider;
import com.daomtthuan.aptechandroid.bookmanagement.entity.Book;

public class BookManagementAddActivity extends AppCompatActivity {

  private EditText inputTitle;
  private EditText inputAuthor;
  private Button buttonAdd;

  private void initializeViews() {
    this.setTitle(R.string.bookmanagement_app_name);

    this.inputTitle = this.findViewById(R.id.input_title);

    this.inputAuthor = this.findViewById(R.id.input_author);

    this.buttonAdd = this.findViewById(R.id.button_add);

    this.buttonAdd.setOnClickListener(this::onButtonAddClick);
  }

  private void onButtonAddClick(View view) {
    String title = this.inputTitle.getText().toString();
    if (title.isEmpty()) {
      Toast.makeText(BookManagementAddActivity.this, this.getResources().getText(R.string.bookmanagement_title_not_empty), Toast.LENGTH_LONG).show();
    }
    String author = this.inputAuthor.getText().toString();
    BookProvider.create(new Book(title, author));
    Toast.makeText(BookManagementAddActivity.this, this.getResources().getText(R.string.bookmanagement_success), Toast.LENGTH_SHORT).show();
    this.finish();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_bookmanagement_add);
    this.initializeViews();
  }
}