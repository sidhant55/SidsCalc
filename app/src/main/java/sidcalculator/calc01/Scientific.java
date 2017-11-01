package sidcalculator.calc01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Scientific extends AppCompatActivity {
    private TextView _screen;
    private TextView _screen2;
    private String display="";
    private String display2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.new_1);
        layout.addView(textView);
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
        String y="",x=display;
        int l=x.length();
        char ch,ch1;
        for (int i=0;i<l-1;i++)
        {
            ch=x.charAt(i);
            ch1=x.charAt(i+1);
            if ((ch>='0' && ch<='9')&&(ch1>='0' && ch1<='9'))
            {
                y=y+ch;
            }
            else if ((ch=='.')||(ch1=='.'))
                y=y+ch;
            else
                y=y+ch+" ";
        }
        y=y+x.charAt(l-1);
        double sum= EvaluateString.evaluate(y);
        display2=Double.toString(sum);
        updatescreen();
    }
    public void onClickDel(View v){
        int l=display.length();
        display=display.substring(0, l - 1);
        updatescreen();
    }
}
