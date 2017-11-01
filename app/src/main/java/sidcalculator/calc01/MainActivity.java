package sidcalculator.calc01;
import android.content.Intent;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.*;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView _screen;
    private TextView _screen2;
    private String display="";
    private String display2="";
    private int c=0;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _screen = (TextView)findViewById(R.id.textView);
        _screen2 = (TextView)findViewById(R.id.textView2);
        _screen.setText(display);
        _screen2.setText(display2);
    }
    private void updatescreen(){
        _screen.setText(display);
        _screen2.setText(display2);
    }
    public void onClickNumber(View v){
        Button b = (Button) v;
        display += b.getText();
        updatescreen();
    }

    public void onClickOperator(View v){
        Button b = (Button)v;
        display += b.getText();
        updatescreen();



    }
    private void clear(){
        display="";
        display2="";

    }
    public void onClickClear(View v){
        clear();
        updatescreen();
    }

    public void onClickEqual(View v){
        String x=display;
        double sum= EvaluateString.space(x);
        display2=Double.toString(sum);
        if (display2.length()>9)
            display2=display2.substring(0,9);
        updatescreen();
    }
    public void onClickDel(View v){
        int l=display.length();
        display=display.substring(0, l - 1);
        updatescreen();
    }
    public void onClickSci(View view) {
        Intent intent = new Intent(this, Scientific.class);
        //EditText editTex = (EditText) findViewById(R.id.buttonSci);
        //String message = editTex.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void onClickSpec(View v) {
        Button b = (Button) v;
        String x="";
        x=x+b.getText();
        if (x=="sin") {
            display2 = display2 + "s(";
            display=display+"sin(";
        }
        updatescreen();
    }
}

