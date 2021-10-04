package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class ResActivity extends AppCompatActivity {
    int index = -1;
    Switch s1 ;
    TextView t1, t2, t3, t4, t5, t6, t7;
    EditText e1, e2, e3;
    Button b1, b2;
    Chronometer c1;
    DatePicker datePicker;
    TimePicker timePicker;
    GridLayout g1, g2;
    FrameLayout f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        setTitle("레스토랑 예약하기");

        init();
    }
    public void ResOnClick(View v) {

        if(v.getId() == R.id.next) {
            index++;
            change();
        }
        else if(v.getId() == R.id.prev) {
            index--;
            change();
        }
    }

    void init() {
        s1 = (Switch) findViewById(R.id.switch1);
        t1 = (TextView) findViewById(R.id.time);
        t2 = (TextView) findViewById(R.id.datetextView);
        t3 = (TextView) findViewById(R.id.timetextView);
        t4 = (TextView) findViewById(R.id.adulttextView);
        t5 = (TextView) findViewById(R.id.teentextView);
        t6 = (TextView) findViewById(R.id.babytextView);
        e1 = (EditText) findViewById(R.id.adult);
        e2 = (EditText) findViewById(R.id.teen);
        e3 = (EditText) findViewById(R.id.baby);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        g1 = (GridLayout)findViewById(R.id.grid1);
        g2 = (GridLayout)findViewById(R.id.grid2);
        f1 = (FrameLayout)findViewById(R.id.framelayout);
        c1 = (Chronometer)findViewById(R.id.chronometer1);
        b1 = (Button) findViewById(R.id.prev);
        b2 = (Button) findViewById(R.id.next);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                c1.setBase(SystemClock.elapsedRealtime());
                if(isChecked) {
                    index++;
                    change();
                }
                else{
                    index = -1;
                    change();
                }
            }
        });

        datePicker.init(datePicker.getYear(), datePicker.getMonth(),
                datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                t2.setText(i+"년"+(i1+1)+"월"+i2+"일");
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                t3.setText(hour+"시"+minute+"분");
            }
        });
    }
    void change() {
        if(index == -1) {
            t1.setVisibility(View.INVISIBLE);
            c1.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            f1.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
            t2.setText("0000년00월00일");
            t3.setText("00시00분");
            t4.setText("00명");
            t5.setText("00명");
            t6.setText("00명");
            e1.setText("");
            e2.setText("");
            e3.setText("");
        }
        else if(index == 0) {
            c1.start();
            t1.setVisibility(View.VISIBLE);
            c1.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            f1.setVisibility(View.VISIBLE);
            b1.setEnabled(false);
        }
        else if(index == 1) {
            timePicker.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
        }
        else if(index == 2) {
            g1.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g2.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
        }
        else if(index == 3) {
            g2.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            b2.setEnabled(false);
            setText();
        }
    }

    void setText() {
        String A = e1.getText().toString();
        String B = e2.getText().toString();
        String C = e3.getText().toString();
        if(A.length()==0 || B.length()==0 || C.length() ==0) {
            Toast.makeText(getApplicationContext(), "전부입력해주세요.", Toast.LENGTH_SHORT).show();
            if(A.length()==0)
                e1.requestFocus();
            else if(B.length()==0)
                e2.requestFocus();
            else if(C.length()==0)
                e3.requestFocus();
        }
        else {
            t4.setText(A + "명");
            t5.setText(B + "명");
            t6.setText(C + "명");
        }
    }
}
