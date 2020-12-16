package com.daomtthuan.aptechandroid.quadraticequation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;

public class QuadraticEquationMainActivity extends AppCompatActivity {

  private TextView labelTitle;
  private TextView labelSubTitle;
  private EditText inputValueA;
  private EditText inputValueB;
  private EditText inputValueC;
  private Button buttonCalculate;

  private void initializeViews() {
    this.setTitle(R.string.quadraticequation_app_name);

    this.labelTitle = this.findViewById(R.id.label_title);
    this.labelTitle.setText(R.string.quadraticequation_title);

    this.labelSubTitle = this.findViewById(R.id.label_sub_title);
    this.labelSubTitle.setText(Html.fromHtml(this.getString(R.string.quadraticequation_sub_title), Html.FROM_HTML_MODE_COMPACT));

    this.inputValueA = this.findViewById(R.id.input_value_a);
    this.inputValueA.setHint(this.getString(R.string.quadraticequation_enter_value) + " a");

    this.inputValueB = this.findViewById(R.id.input_value_b);
    this.inputValueB.setHint(this.getString(R.string.quadraticequation_enter_value) + " b");

    this.inputValueC = this.findViewById(R.id.input_value_c);
    this.inputValueC.setHint(this.getString(R.string.quadraticequation_enter_value) + " c");

    this.buttonCalculate = this.findViewById(R.id.button_calculate);
    this.buttonCalculate.setOnClickListener(this::onButtonCalculateClick);
  }

  private void onButtonCalculateClick(View view) {
    try {
      double valueA = Double.parseDouble(this.inputValueA.getText().toString()),
              valueB = Double.parseDouble(this.inputValueB.getText().toString()),
              valueC = Double.parseDouble(this.inputValueC.getText().toString());

      Intent intentCalculate = new Intent(QuadraticEquationMainActivity.this, QuadraticEquationCalculateActivity.class);
      intentCalculate.putExtra("value_a", valueA);
      intentCalculate.putExtra("value_b", valueB);
      intentCalculate.putExtra("value_c", valueC);
      this.startActivity(intentCalculate);
    } catch (Exception exception) {
      Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_quadraticequation_main);
    this.initializeViews();
  }
}