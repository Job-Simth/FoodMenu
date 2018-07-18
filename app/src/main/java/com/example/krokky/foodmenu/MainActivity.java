package com.example.krokky.foodmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5};
        for (int i : id) {
            ((CheckBox)findViewById(i)).setOnCheckedChangeListener(this);
        }
    }

    public void takeOrder(View v) {
        CheckBox checkBox;
        String msg = "";

        int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5};
        for (int i : id) {
            checkBox = findViewById(i);
            if (checkBox.isChecked())
                msg += "  " + checkBox.getText();
        }
        if (msg.length() > 0)
            msg = "你点购的餐点是：" + msg;
        else msg = "请点餐！";
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    int items = 0;
    @Override
    public void onCheckedChanged(CompoundButton Button, boolean isChecked) {
        int visible;
        if(isChecked){
            items++;
            visible = View.VISIBLE;
        }
        else{
            items--;
            visible= View.GONE;
        }
        switch (Button.getId()){
            case R.id.checkBox1 :
                findViewById(R.id.output1).setVisibility(visible);
                break;
            case R.id.checkBox2 :
                findViewById(R.id.output2).setVisibility(visible);
                break;
            case R.id.checkBox3 :
                findViewById(R.id.output3).setVisibility(visible);
                break;
            case R.id.checkBox4 :
                findViewById(R.id.output4).setVisibility(visible);
                break;
            case R.id.checkBox5 :
                findViewById(R.id.output5).setVisibility(visible);
                break;
        }
        String msg;
        if(items>0)
            msg= "你点的餐如下： ";
        else
            msg = "请点餐！";
        ((TextView)findViewById(R.id.textView)).setText(msg);
    }
}
