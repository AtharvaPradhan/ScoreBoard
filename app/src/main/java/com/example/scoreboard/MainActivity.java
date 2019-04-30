package com.example.scoreboard;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button go;
    private RadioButton r1;
    private RadioGroup rsd;
    private EditText players, overs, ifany;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        players = findViewById(R.id.PlayersCount);
        overs = findViewById(R.id.OversCount);
        ifany = findViewById(R.id.ExtraCount);
        rsd = findViewById(R.id.MyGrp);
        go = findViewById(R.id.LetsGo);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = rsd.getCheckedRadioButtonId();
                r1=findViewById(selectedID);
                if(!overs.getText().toString().isEmpty() && !players.getText().toString().isEmpty()){
                    a = overs.getText()+"x"+players.getText()+"x"+ifany.getText();
                    Intent GoIntent = new Intent(MainActivity.this,ScorePage.class);
                    GoIntent.putExtra("test", a);
                    startActivity(GoIntent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill Overs and No.of Players Field",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
