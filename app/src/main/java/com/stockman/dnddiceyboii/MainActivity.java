package com.stockman.dnddiceyboii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdaapter adapter;
    int rollValue,position;
    ImageView onScreenDice;
    ArrayList<Dice> diceBag;
    TextView mDiceRoll, mDiceName;
    Dice mD4,mD6,mD8,mD10,mD12,mD20,mD100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        position=0;
        diceBag = new ArrayList<>();
        mD4 = new Dice("D4",4, R.drawable.d4);
        mD6 = new Dice("D6", 6, R.drawable.d6);
        mD8 = new Dice("D8", 8, R.drawable.d8);
        mD10 = new Dice("D10", 10, R.drawable.d10);
        mD12 = new Dice("D12", 12, R.drawable.d12);
        mD20 = new Dice("D20",20,R.drawable.d20);
        mD100 = new Dice("D100", 100,R.drawable.d10);

        diceBag.add(mD4);
        diceBag.add(mD6);
        diceBag.add(mD8);
        diceBag.add(mD10);
        diceBag.add(mD12);
        diceBag.add(mD20);
       // onScreenDice = findViewById(R.id.selector);
        recyclerView= findViewById(R.id.recyclerView);

        mDiceRoll = findViewById(R.id.diceRoll);
//        onScreenDice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Roll(diceBag.get(position));
//            }
//        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecyclerViewAdaapter(diceBag,MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdaapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
               // Roll(diceBag.get(position));
                displayRoll(diceBag.get(position).rollDice(diceBag.get(position).getMaxRoll()));
            }
        });

          mDiceName = findViewById(R.id.rcDice); //recyclerviewset up
//        mDiceName.setText(diceBag.get(position).getName());

    }

    public void displayRoll(int rollValue){
      String roll=" ";
      roll= String.valueOf(rollValue+1);
      //mDiceRoll.setText(roll);
      Resources res = getResources();
      String[] sides = res.getStringArray(R.array.roll);
        mDiceRoll.setText(sides[rollValue]);
     // mDiceName.setText(sides[rollValue]);
//      mDiceName.setText(roll);
      Toast toast = Toast.makeText(this, "Rolling "+diceBag.get(position).getName(),
              Toast.LENGTH_SHORT);
      toast.show();

    }
}