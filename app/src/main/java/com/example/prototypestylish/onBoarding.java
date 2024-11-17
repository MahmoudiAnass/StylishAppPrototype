package com.example.prototypestylish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class onBoarding extends AppCompatActivity {

    onboardingAdapter myadapter;
    ViewPager2 myviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_boarding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myviewpager= findViewById(R.id.mviewpager);
        setAdapter();

        Button skip = findViewById(R.id.skiptext);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(onBoarding.this,LoginRegister.class);
                startActivity(intent);
            }
        });

    }


    public void setAdapter(){
    List<onBoardingitem> onBoardingitemList= new ArrayList<>();

    onBoardingitem  choseproduct = new onBoardingitem();

        choseproduct.setTitle("Choose Products");
        choseproduct.setDescription("Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.");
        choseproduct.setImage(R.drawable.choseproductimage);

        onBoardingitem makepayment = new onBoardingitem();
        makepayment.setTitle("Make Payment");
        makepayment.setDescription("Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.");
        makepayment.setImage(R.drawable.makepaymentimage);


        onBoardingitem getyourorder = new onBoardingitem();
        getyourorder.setTitle("Get Your Order");
        getyourorder.setDescription("Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.");
        getyourorder.setImage(R.drawable.getyourorderimage);

        onBoardingitemList.add(choseproduct);
        onBoardingitemList.add(makepayment);
        onBoardingitemList.add(getyourorder);

        for (int i=0; i<onBoardingitemList.size();i++){
            onBoardingitemList.get(i).setNextButton("Next");
            onBoardingitemList.get(i).setPreviousButton("Prev");

            onBoardingitemList.get(i).setCounter(i+1 +"/3");
            if (i ==0){
                onBoardingitemList.get(0).setPreviousButton("");

            }
            if (i==2){
                onBoardingitemList.get(2).setNextButton("Get Started");
            }


        }

 myadapter = new onboardingAdapter(this,onBoardingitemList,myviewpager);
        myviewpager.setAdapter(myadapter);

    }
}