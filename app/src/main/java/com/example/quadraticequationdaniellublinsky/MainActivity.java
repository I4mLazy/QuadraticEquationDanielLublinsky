package com.example.quadraticequationdaniellublinsky;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
public class MainActivity extends AppCompatActivity
{
    EditText a;
    EditText b;
    EditText c;
    Button Randomize;
    Button Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        Randomize = findViewById(R.id.Randomize);
        Calc = findViewById(R.id.Calc);
    }


    public void Randomize(View view)
    {
        Random random = new Random();
        int fn = random.nextInt(201)-100;
        int sn = random.nextInt(201)-100;
        int tn = random.nextInt(201)-100;
        a.setText(fn);
        b.setText(sn);
        c.setText(tn);
    }

    public void Calculate(View view)
    {

    }
}