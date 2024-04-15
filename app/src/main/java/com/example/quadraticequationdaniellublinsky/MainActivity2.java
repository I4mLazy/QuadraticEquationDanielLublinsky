package com.example.quadraticequationdaniellublinsky;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity
{
    TextView ans;
    Button ret;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent gi = getIntent();
        ret = findViewById(R.id.ret);
        int a = Integer.parseInt(gi.getStringExtra("a"));
        int b = Integer.parseInt(gi.getStringExtra("b"));
        int c = Integer.parseInt(gi.getStringExtra("c"));
        ans = findViewById(R.id.ans);
        double ans1;
        double ans2;
        ans1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
        ans2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
        if(ans1 == ans2) // same answer
        {
            ans.setText(String.valueOf(ans1));
        }
        else if(Double.isNaN(ans1)) // ans1 is NaN
        {
            if(Double.isNaN(ans2)) //both are NaN
            {
                ans.setText("No Answers");
            }
            else //ans2 is the only answer
            {
                ans.setText(String.valueOf(ans2));
            }
        }
        else if(Double.isNaN(ans2)) //ans1 is the only answer
        {
            ans.setText(String.valueOf(ans1));
        }
        else // two answers
        {
            ans.setText(String.valueOf(ans1) + ", " + String.valueOf(ans2));
        }
    }

    public void ret(View view)
    {
        Intent si = new Intent(this, MainActivity.class);
        si.putExtra("ans", ans.getText().toString());
        setResult(1, si);
        finish();
    }
}