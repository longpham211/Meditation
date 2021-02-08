package com.engineer.lup.meditation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private static String[] minuteValues = new String[18];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setMinuteValues();

        final NumberPicker minutePicker = (NumberPicker) this.findViewById(R.id.minutePicker);

        //minutePicker.setDisplayedValues(minuteValues);
        minutePicker.setWrapSelectorWheel(false);
        minutePicker.setMaxValue(180);
        minutePicker.setMinValue(5);
        minutePicker.setValue(45);
        minutePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d("tlong.pham", "" + newVal);
            }
        });

        final Button startMeditation = (Button) this.findViewById(R.id.startMeditation);
        startMeditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMeditationIntent = new Intent(MainActivity.this, MeditationActivity.class);
               // Log.d("tlong.pham", minutePicker.getValue() + "");
                startMeditationIntent.putExtra("minutes", minutePicker.getValue());
                MainActivity.this.startActivity(startMeditationIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setMinuteValues(){
        for (int i = 1; i <= minuteValues.length; i++) {
            String number = Integer.toString(i*5);
            minuteValues[i-1] = number;
        }
    }
}
