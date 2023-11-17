package com.example.frag_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.OnContactNameClicked {

    ArrayList<String> numbers;
    ArrayList<String> courses;
    TextView tvNumber;
    TextView tvCourses;
    Button btnShowCourses;
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        btnShowCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCourses.setText(courses.get(temp));
            }
        });
    }

    public void init()
    {
        numbers = new ArrayList<>();
        numbers.add("123");
        numbers.add("456");
        numbers.add("789");
        numbers.add("1011");
        numbers.add("1213");

        courses = new ArrayList<>();
        courses.add("PF\nOOP\nDSA");
        courses.add("MAD\nITC\nDSA");
        courses.add("SCD\nOS\nDSA");
        courses.add("Compiler\nAdv Programming\nSE");
        courses.add("SE\nSQA\nSRE");

        tvNumber = getSupportFragmentManager()
                .findFragmentById(R.id.numberFrag)
                .getView()
                .findViewById(R.id.tvNumber);
        btnShowCourses = getSupportFragmentManager()
                .findFragmentById(R.id.numberFrag)
                .getView()
                .findViewById(R.id.btnShowCourses);
        tvCourses = getSupportFragmentManager()
                .findFragmentById(R.id.coursesFrag)
                .getView()
                .findViewById(R.id.tvCourses);

        tvNumber.setText(numbers.get(0));
        tvCourses.setText(courses.get(0));

    }

    @Override
    public void onNameClick(int index) {
        tvNumber.setText(numbers.get(index));
        temp = index;
    }
}