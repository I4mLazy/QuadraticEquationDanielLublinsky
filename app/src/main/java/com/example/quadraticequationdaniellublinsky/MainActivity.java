package com.example.quadraticequationdaniellublinsky;
import android.app.Activity;
import android.widget.TextView;
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
import android.content.Intent;
public class MainActivity extends AppCompatActivity
{
    EditText a;
    EditText b;
    EditText c;
    Button Randomize;
    Button Calc;
    TextView lastans;

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
        lastans = findViewById(R.id.lastans);
        lastans.setVisibility(View.INVISIBLE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                String result = data.getStringExtra("ans");
                lastans.setVisibility(View.VISIBLE);
                lastans.setText(result);
            }
        }
    }


    public void Randomize(View view)
    {
        Random random = new Random();
        int fn = random.nextInt(201)-100;
        int sn = random.nextInt(201)-100;
        int tn = random.nextInt(201)-100;
        a.setText(String.valueOf(fn));
        b.setText(String.valueOf(sn));
        c.setText(String.valueOf(tn));
    }

    public void Calculate(View view)
    {
        if(!(a.getText().toString().isEmpty()) && !(b.getText().toString().isEmpty()) && !(c.getText().toString().isEmpty()))
        {
            Intent si = new Intent(this, MainActivity2.class);
            si.putExtra("a", a.getText().toString());
            si.putExtra("b", b.getText().toString());
            si.putExtra("c", c.getText().toString());
            startActivityForResult(si,1);
        }
    }
}