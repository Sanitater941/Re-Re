package com.example.myproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GradeActivity extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1, b2;
    TextView t1, t2;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        setTitle("학점 계산기");
        init();
    }
    public void GradeonClick(View v) {
        if(v.getId() == R.id.result){
            String K = e1.getText().toString();
            String M = e2.getText().toString();
            String E = e3.getText().toString();
            String g = e4.getText().toString();
            if(K.length() ==0 || M.length() == 0 || E.length() == 0 || g.length() == 0) {
                Toast.makeText(getApplicationContext(), "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
                if(K.length()==0) {
                    e1.requestFocus();
                    t1.setText(0 + "점");
                    t2.setText(0 + "점");
                }
                else if(M.length()==0) {
                    e2.requestFocus();
                    t1.setText(0 + "점");
                    t2.setText(0 + "점");
                }
                else if(E.length()==0) {
                    e3.requestFocus();
                    t1.setText(0 + "점");
                    t2.setText(0 + "점");
                }
                else {
                    e4.requestFocus();
                    t1.setText(0 + "점");
                    t2.setText(0 + "점");
                }
            }
            else {
                int result = Integer.parseInt(K) + Integer.parseInt(M) + Integer.parseInt(E) + Integer.parseInt(g);
                int average = result / 4;
                t1.setText(result + "점");
                t2.setText(average + "점");
                i1.setVisibility(View.VISIBLE);
                if (average > 90) {
                    i1.setImageResource(R.drawable.a);
                } else if (average > 80) {
                    i1.setImageResource(R.drawable.b);
                } else if (average > 70) {
                    i1.setImageResource(R.drawable.c);
                } else if (average > 60) {
                    i1.setImageResource(R.drawable.d);
                } else {
                    i1.setImageResource(R.drawable.f);
                }
            }
        }
        else if(v.getId() == R.id.init){
            Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            e1.setText("");
            e2.setText("");
            e3.setText("");
            i1.setVisibility(View.GONE);
            t1.setText(0+"점");
            t2.setText(0+"점");
        }
    }

    void init() {
        e1 = (EditText) findViewById(R.id.Algorithmn);
        e2 = (EditText) findViewById(R.id.Mobile);
        e3 = (EditText) findViewById(R.id.Ajax);
        e4 = (EditText) findViewById(R.id.Graduate);
        b1 = (Button) findViewById(R.id.result);
        b2 = (Button) findViewById(R.id.init);
        t1 = (TextView) findViewById(R.id.sum);
        t2 = (TextView) findViewById(R.id.average);
        i1 = (ImageView) findViewById(R.id.imageView);
    }
}
