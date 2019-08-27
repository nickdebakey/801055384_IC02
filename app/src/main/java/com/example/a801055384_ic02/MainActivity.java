package com.example.a801055384_ic02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_areaResult;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;
    double length1;
    double length2;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        iv_triangle = findViewById(R.id.iv_triangle);
        iv_square = findViewById(R.id.iv_square);
        iv_circle = findViewById(R.id.iv_circle);
        tv_shape = findViewById(R.id.tv_shapeSelection);
        tv_areaResult = findViewById(R.id.tv_result);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);

        clearButton();

//        String tempLength1 = et_length1.getText().toString();
//        String tempLength2 = et_length2.getText().toString();
//
//        if(tempLength1 != null && !tempLength1.equals("")) {
//            length1 = Double.parseDouble(tempLength1);
//        }
//        if(tempLength2 != null && !tempLength2.equals("")) {
//            length2 = Double.parseDouble(tempLength2);
//        }

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                tv_shape.setText("Square");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "circle";
                tv_shape.setText("Circle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempLength1 = et_length1.getText().toString();
                String tempLength2 = et_length2.getText().toString();

                if(tempLength1 != null && !tempLength1.equals("")) {
                    length1 = Double.parseDouble(tempLength1);
                }
                if(tempLength2 != null && !tempLength2.equals("")) {
                    length2 = Double.parseDouble(tempLength2);
                }

                if(et_length1.getText().toString().equals("")){
                    et_length1.setError("Value Needed");
                }
                if(et_length2.getText().toString().equals("")){
                    et_length2.setError("Value Needed");
                }
                if(selectedShape == "none"){
                    et_length1.setError("Shape Needed");
                    et_length2.setError("Shape Needed");
                }
                switch (selectedShape) {
                    case "triangle":
                        double result = (length1 * length2)*(0.5);
                        tv_areaResult.setText("The area is: " + result);
                        break;
                    case "square":
                        result = length1 * length1;
                        tv_areaResult.setText("The area is: " + result);
                        break;
                    case "circle":
                        result = 2 * length1 * 3.1416;
                        tv_areaResult.setText("The area is: " + result);
                        break;
                }
            }
        });

    }

    public void clearButton() {

        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText("Select A Shape");
        tv_areaResult.setText("");
        selectedShape = "none";

    }

}
