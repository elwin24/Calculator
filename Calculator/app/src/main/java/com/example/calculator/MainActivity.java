package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double c, a, b;
    boolean plus = false, minus = false, division = false, multiply = false;

    public String checkDecimal(double c1) {
        int f;
        f = (int) c;
        String str;
        if (f != c) {
            str = "" + c;
        } else {
            str = "" + (int) c;
        }
        return str;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#4799E8"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_200));

        setContentView(R.layout.activity_main);
        EditText edit1Text = (EditText) findViewById(R.id.firstNum);
        EditText edit2Text = (EditText) findViewById(R.id.secondNum);
        TextView action = findViewById(R.id.action);

        Button buttonPlus = (Button) findViewById(R.id.plusButton);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                action.setText("+");
            }
        });
        Button buttonMinus = (Button) findViewById(R.id.minusButton);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                action.setText("-");
            }
        });
        Button buttonMultiply = (Button) findViewById(R.id.multiplyButton);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                action.setText("*");
            }
        });
        Button buttonDivision = (Button) findViewById(R.id.divisionButton);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                action.setText("/");
            }
        });
        TextView result = findViewById(R.id.thirdNum);
        TextView equal = findViewById(R.id.equal);
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean x = true;
                boolean y = false;
                try {
                    a = Double.parseDouble(edit1Text.getText().toString());
                    b = Double.parseDouble(edit2Text.getText().toString());
                    equal.setText("=");
                } catch (NumberFormatException ex) {
                    Toast.makeText(MainActivity.this,
                            "Enter both values",
                            Toast.LENGTH_SHORT).show();
                    result.setText("");
                    action.setText("");
                    equal.setText("");
                    x = false;
                    y = true;
                }
                if (action.getText().toString().equals("") && !y) {
                    Toast.makeText(MainActivity.this,
                            "Select operation",
                            Toast.LENGTH_SHORT).show();
                    equal.setText("");
                }
                if (x) {
                    if (action.getText().toString().equals("+")) {
                        c = a + b;
                        result.setText(checkDecimal(c));
                    } else if (action.getText().toString().equals("-")) {
                        c = a - b;
                        result.setText(checkDecimal(c));

                    } else if (action.getText().toString().equals("/")) {
                        if (b == 0) {
                            Toast.makeText(MainActivity.this,
                                    "Can't divide by zero!",
                                    Toast.LENGTH_SHORT).show();
                            result.setText("");
                            equal.setText("");
                        } else {
                            c = a / b;
                            result.setText(checkDecimal(c));
                        }
                    } else if (action.getText().toString().equals("*")) {
                        c = a * b;
                        result.setText(checkDecimal(c));
                    }
                }
            }
        });
    }
}