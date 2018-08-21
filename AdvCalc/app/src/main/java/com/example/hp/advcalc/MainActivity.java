package com.example.hp.advcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toast.makeText(getApplicationContext(),"ThankYou Baby",Toast.LENGTH_SHORT).show();

        Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,button_del,buttonC,button_plus,button_min,button_div,button_mul,button_equals;
        final TextView screen;


        button1 = (Button)findViewById(R.id.one);
        button2 = (Button)findViewById(R.id.two);
        button3 = (Button)findViewById(R.id.three);
        button4 = (Button)findViewById(R.id.four);
        button5 = (Button)findViewById(R.id.five);
        button6 = (Button)findViewById(R.id.six);
        button7 = (Button)findViewById(R.id.seven);
        button8 = (Button)findViewById(R.id.eight);
        button9 = (Button)findViewById(R.id.nine);
        button0 = (Button)findViewById(R.id.zero);
        buttonC = (Button)findViewById(R.id.C);
        button_div = (Button)findViewById(R.id.div);
        button_mul = (Button)findViewById(R.id.mul);
        button_plus = (Button)findViewById(R.id.plus);
        button_equals = (Button)findViewById(R.id.equal);
        button_min = (Button)findViewById(R.id.min);
        button_del = (Button)findViewById(R.id.del);

        screen = (TextView)findViewById(R.id.screen);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"9");
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"/");
            }
        });
        button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"-");
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"*");
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText()+"+");
            }
        });
        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infix = String.valueOf(screen.getText());
                if(!infix.isEmpty())
                {
                   try
                   {
                       float value = Eval.eval(Postfix.convert(infix));
                       screen.setText(String.valueOf(value));
                   }
                   catch(ArithmeticException e)
                   {
                       screen.setText("hahaha");
                   }
                }
            }
        });
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = String.valueOf(screen.getText());
                if(!x.isEmpty())
                {
                    int len = x.length();
                    x = x.substring(0, len - 1);
                    screen.setText(x);
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                screen.setText("");
            }
        });

    }


}
