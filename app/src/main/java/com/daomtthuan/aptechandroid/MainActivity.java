package com.daomtthuan.aptechandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.bookmanagement.activity.BookManagementMainActivity;
import com.daomtthuan.aptechandroid.carddistribution.activity.CardDistributionMainActivity;
import com.daomtthuan.aptechandroid.quadraticequation.activity.QuadraticEquationMainActivity;
import com.daomtthuan.aptechandroid.studentlist.activity.StudentListMainActivity;

public class MainActivity extends AppCompatActivity {

  private Button buttonQuadraticEquation;
  private Button buttonCardDistribution;
  private Button buttonStudentList;
  private Button buttonBookManagement;

  private void initializeViews() {
    this.setTitle(R.string.app_name);

    this.buttonQuadraticEquation = this.findViewById(R.id.button_quadratic_equation);
    this.buttonQuadraticEquation.setOnClickListener(this::onButtonQuadraticEquationClick);

    this.buttonCardDistribution = this.findViewById(R.id.button_card_distribution);
    this.buttonCardDistribution.setOnClickListener(this::onButtonCardDistributionClick);

    this.buttonStudentList = this.findViewById(R.id.button_student_list);
    this.buttonStudentList.setOnClickListener(this::onButtonStudentListClick);

    this.buttonBookManagement = this.findViewById(R.id.button_book_management);
    this.buttonBookManagement.setOnClickListener(this::onButtonBookManagementClick);
  }

  private void onButtonStudentListClick(View view) {
    this.startActivity(new Intent(MainActivity.this, StudentListMainActivity.class));
  }

  private void onButtonCardDistributionClick(View view) {
    this.startActivity(new Intent(MainActivity.this, CardDistributionMainActivity.class));
  }

  private void onButtonQuadraticEquationClick(View view) {
    this.startActivity(new Intent(MainActivity.this, QuadraticEquationMainActivity.class));
  }

  private void onButtonBookManagementClick(View view) {
    this.startActivity(new Intent(MainActivity.this, BookManagementMainActivity.class));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_main);
    this.initializeViews();
  }

}