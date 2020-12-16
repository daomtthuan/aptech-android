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

public class BookManagementEditActivity extends AppCompatActivity {
  private Book book;
  private EditText inputTitle;
  private EditText inputAuthor;
  private Button buttonEdit;

  private void initializeViews() {
    this.setTitle(R.string.bookmanagement_app_name);

    this.book = BookProvider.find(this.getIntent().getLongExtra("id", 0));

    this.inputTitle = this.findViewById(R.id.input_title);
    this.inputTitle.setText(String.valueOf(this.book.getTitle()));

    this.inputAuthor = this.findViewById(R.id.input_author);
    if (this.book.getAuthor() != null) {
      this.inputAuthor.setText(String.valueOf(this.book.getAuthor()));
    }

    this.buttonEdit = this.findViewById(R.id.button_edit);
    this.buttonEdit.setOnClickListener(this::onButtonEditClick);
  }

  private void onButtonEditClick(View view) {
    String title = this.inputTitle.getText().toString();
    if (title.isEmpty()) {
      Toast.makeText(BookManagementEditActivity.this, this.getResources().getText(R.string.bookmanagement_title_not_empty), Toast.LENGTH_LONG).show();
    }
    this.book.setTitle(title);
    this.book.setAuthor(this.inputAuthor.getText().toString());
    BookProvider.edit(this.book);
    Toast.makeText(BookManagementEditActivity.this, this.getResources().getText(R.string.bookmanagement_success), Toast.LENGTH_SHORT).show();
    this.finish();
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_bookmanagement_edit);
    this.initializeViews();
  }
}