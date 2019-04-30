package com.example.scoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScorePage extends AppCompatActivity {


    TextView score,obj;
    static int runs = 0, wickets=0, bd=0, ad=0;
    static int maxOvers = 0, maxPlayers=0,maxIfAny =0;
    String a,temp,temp2,temp3;
    int noUse1, noUse2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);
        Button ONE_RUN = findViewById(R.id.one);
        Button TWO_RUN = findViewById(R.id.two);
        Button THREE_RUN = findViewById(R.id.three);
        Button FOUR_RUN = findViewById(R.id.four);
        Button FIVE_RUN = findViewById(R.id.five);
        Button SIX_RUN = findViewById(R.id.six);
        Button NEW = findViewById(R.id.mew);
        obj = findViewById(R.id.objects);
        score = findViewById(R.id.Myscores);

        temp = getIntent().getStringExtra("test");
        noUse1 = temp.indexOf("x");
        noUse2 = temp.lastIndexOf("x");
        temp2 = temp.substring(0,noUse1);
        temp3 = temp.substring(noUse1+1,noUse2);
        temp = temp.substring(noUse2+1);

        maxOvers = Integer.parseInt(temp2);
        maxPlayers = Integer.parseInt(temp3);
        maxIfAny = Integer.parseInt(temp);

        score.setText("0-0/0.0");
        obj.setText("Overs:"+maxOvers+"         Projected Score:"+maxIfAny);
        //score.setText(temp);

        ONE_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(1);
            }
        });

        TWO_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(2);
            }
        });

        THREE_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(3);
            }
        });

        FOUR_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(4);
            }
        });

        FIVE_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(5);
            }
        });

        SIX_RUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfinal(6);
            }
        });

        NEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent1 = new Intent(ScorePage.this,MainActivity.class);
                startActivity(MyIntent1);
            }
        });

    }

    public void check(){
        if(bd==maxOvers){
            score.setText("Start Chase");
        }
    }

    public void myfinal(int x){
        runs+=x;
        ad+=1;
        if(ad==6){
            bd+=1;
            ad=0;
        }
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }

    public void wicketdown(View view){
        wickets+=1;
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }

    public void allByes(View view){
        ad+=1;
        if(ad==6){
            bd+=1;
            ad=0;
        }
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }

    public void wideBall(View view){
        runs+=1;
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }

    public void noBall(View view){
        NoRuns mynoruns = new NoRuns();
        mynoruns.show(getSupportFragmentManager(),"No=Runs Dialog");
        runs+=1;
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }

    public void NORUNS(View view){
        ad+=1;
        if(ad==6){
            bd+=1;
            ad=0;
        }
        a = runs+"-"+wickets+"/"+bd+"."+ad;
        score.setText(a);
        check();
    }
}
