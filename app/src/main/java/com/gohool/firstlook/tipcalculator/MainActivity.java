package com.gohool.firstlook.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private SeekBar seek;
    private Button okay;
    private TextView output;
    private double percent;
    private double tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inpID);
        seek = findViewById(R.id.seekBarID);
        okay = findViewById(R.id.doneID);
        output = findViewById(R.id.finalID);



        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Log.d("SB","OnStopTracking");
                if (seekBar.getProgress() == 0)
                {
                    output.setText("no tip?");
                    //percent = 0.10;
                }
                else if (seekBar.getProgress() == 1)
                {
                    output.setText("Is it 10 percent?");
                    percent = 0.10;
                }
                else if (seekBar.getProgress() == 2)
                {
                    output.setText("Is it 15 percent?");
                    percent = 0.15;
                }
                else
                {
                    output.setText("Is it 20 percent?");
                    percent = 0.20;
                }
            }
        });

       okay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                double cost = Double.parseDouble(input.getText().toString());
                tip = percent * cost;
                output.setText(String.format("$" + "%.2f",tip));
           }
        });


    }
}
