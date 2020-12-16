package com.daomtthuan.aptechandroid.carddistribution.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daomtthuan.aptechandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDistributionMainActivity extends AppCompatActivity {

  private ImageView imageCard1;
  private ImageView imageCard2;
  private ImageView imageCard3;
  private Button buttonDistribute;
  private Button buttonShuffle;
  private TextView labelResult;
  private List<String> cards;
  private Random random;

  private void initializeViews() {
    this.setTitle(R.string.carddistribution_app_name);

    this.imageCard1 = this.findViewById(R.id.image_card_1);

    this.imageCard2 = this.findViewById(R.id.image_card_2);

    this.imageCard3 = this.findViewById(R.id.image_card_3);

    this.buttonDistribute = this.findViewById(R.id.button_distribute);
    this.buttonDistribute.setOnClickListener(this::onButtonDistributeClick);

    this.buttonShuffle = this.findViewById(R.id.button_shuffle);
    this.buttonShuffle.setOnClickListener(this::onButtonShuffleClick);

    this.labelResult = this.findViewById(R.id.label_result);

    this.cards = new ArrayList<>();
    for (int index = 1; index <= 13; index++) {
      this.cards.add(index + "c");
      this.cards.add(index + "d");
      this.cards.add(index + "h");
      this.cards.add(index + "s");
    }

    this.random = new Random();
  }

  private int getRandomImageCard(String name) {
    return this.getResources().getIdentifier("carddistribution_" + name, "drawable", this.getPackageName());
  }

  private int getRandomIndexCard() {
    return this.random.nextInt(this.cards.size());
  }

  private void onButtonDistributeClick(View view) {
    String name1, name2, name3 = null;
    String result = "Result: ";

    name1 = this.cards.get(this.getRandomIndexCard());
    result += (name1 + ", ");
    this.imageCard1.setImageResource(this.getRandomImageCard(name1));

    do {
      name2 = this.cards.get(this.getRandomIndexCard());
    } while (name2.equals(name1));
    result += (name2 + ", ");
    this.imageCard2.setImageResource(this.getRandomImageCard(name2));

    do {
      name3 = this.cards.get(this.getRandomIndexCard());
    } while (name3.equals(name2) || name3.equals(name1));
    result += name3;
    this.imageCard3.setImageResource(this.getRandomImageCard(name3));

    this.labelResult.setText(result);
  }

  private void onButtonShuffleClick(View view) {
    this.imageCard1.setImageResource(R.drawable.carddistribution_back);
    this.imageCard2.setImageResource(R.drawable.carddistribution_back);
    this.imageCard3.setImageResource(R.drawable.carddistribution_back);
    this.labelResult.setText(null);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_carddistribution_main);
    this.initializeViews();
  }
}