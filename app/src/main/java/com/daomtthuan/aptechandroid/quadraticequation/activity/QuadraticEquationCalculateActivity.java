package com.daomtthuan.aptechandroid.quadraticequation.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;

public class QuadraticEquationCalculateActivity extends AppCompatActivity {

  private double valueA;
  private double valueB;
  private double valueC;
  private TextView labelResult;

  private void initializeViews() {
    this.setTitle(R.string.quadraticequation_app_name);
    this.valueA = this.getIntent().getDoubleExtra("value_a", 0);
    this.valueB = this.getIntent().getDoubleExtra("value_b", 0);
    this.valueC = this.getIntent().getDoubleExtra("value_c", 0);

    this.labelResult = this.findViewById(R.id.label_result);
    this.calculate();
  }

  @SuppressLint("SetTextI18n")
  private void calculate() {
    if (this.valueA == 0) {
      if (this.valueB == 0) {
        if (this.valueC == 0) {
          this.labelResult.setText(R.string.quadraticequation_lots_of_solutions);
        } else {
          this.labelResult.setText(R.string.quadraticequation_no_solutions);
        }
      } else {
        double x = -valueC / valueB;
        this.labelResult.setText("x = " + (double) Math.round(x * 1000) / 1000);
      }
    } else {
      double delta = valueB * valueB - 4 * valueA * valueC;
      if (delta < 0) {
        this.labelResult.setText(R.string.quadraticequation_no_solutions);
      } else if (delta == 0) {
        double x = -valueB / (2 * valueA);
        this.labelResult.setText("x = " + (double) Math.round(x * 1000) / 1000);
      } else {
        double x1 = (-valueB + Math.sqrt(delta)) / (2 * valueA),
                x2 = (-valueB - Math.sqrt(delta)) / (2 * valueA);
        this.labelResult.setLines(2);
        this.labelResult.setText(Html.fromHtml(
                "x<sub>1</sub> = " + ((double) Math.round(x1 * 1000) / 1000) + "<br/>" +
                        "x<sub>2</sub> = " + ((double) Math.round(x2 * 1000) / 1000),
                Html.FROM_HTML_MODE_COMPACT));
      }
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_quadraticequation_calculate);
    this.initializeViews();
  }
}