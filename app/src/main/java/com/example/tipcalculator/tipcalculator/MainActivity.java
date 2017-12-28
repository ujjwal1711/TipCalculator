package com.example.tipcalculator.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private EditText enteredamount;
    private SeekBar seek;
    private Button button;
    private TextView text;
    private TextView text2;
    private int perct;
    private float ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enteredamount = (EditText) findViewById(R.id.tipamount);
        seek = (SeekBar) findViewById(R.id.seekBar);
        button=(Button) findViewById(R.id.convertid);
        text=(TextView) findViewById(R.id.textView2);
        text2=(TextView) findViewById(R.id.textView3);


        button.setOnClickListener(this);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             text2.setText(String.valueOf(seek.getProgress())+ "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                perct=seek.getProgress();

            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();

    }
    public void calculate()
    {
        float ans=0.0f;
        if(!enteredamount.getText().toString().equals("")) {
            ab = Float.parseFloat(enteredamount.getText().toString());
            ans=ab*perct / 100;
            text.setText("Your tip will be Rs."+ String.valueOf(ans));
        }
        else
        {
            Toast.makeText(MainActivity.this,"Please enter a bill amount",Toast.LENGTH_LONG).show();
        }
    }
}
