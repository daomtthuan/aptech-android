package com.daomtthuan.aptechandroid.studentlist.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;
import com.daomtthuan.aptechandroid.studentlist.adapter.StudentListAdapter;
import com.daomtthuan.aptechandroid.studentlist.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListMainActivity extends AppCompatActivity {

  private List<Student> listStudent;
  private GridView gridListStudent;

  private void initializeViews() {
    this.setTitle(R.string.studentlist_app_name);

    this.listStudent = new ArrayList<>();
    listStudent.add(new Student(1, "Douglas Pellet", "alayna.how10@yahoo.com"));
    listStudent.add(new Student(2, "Mary Jane", "martina.fra@yahoo.com"));
    listStudent.add(new Student(3, "Earl Estes", "iva1979@hotmail.com"));
    listStudent.add(new Student(4, "Buster Hone", "constanti1@hotmail.com"));
    listStudent.add(new Student(5, "Nova Alane", "constantin_oconne@yahoo.com"));

    this.gridListStudent = this.findViewById(R.id.grid_student_list);
    this.gridListStudent.setAdapter(new StudentListAdapter(StudentListMainActivity.this, R.layout.item_student, this.listStudent));
    this.gridListStudent.setOnItemClickListener(this::onStudentListItemClick);
  }

  private void onStudentListItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    Toast.makeText(StudentListMainActivity.this, "" + i, Toast.LENGTH_LONG).show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_studentlist_main);
    this.initializeViews();
  }

  @Override
  public void onConfigurationChanged(@NonNull Configuration newConfig) {
    System.out.println(newConfig.orientation);
    this.gridListStudent.setNumColumns(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 2 : 1);
    super.onConfigurationChanged(newConfig);
  }
}