package com.example.dateilsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button1;

    private EditText editText1,editText2,editText3;

    private CheckBox checkBox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button) findViewById(R.id.btn1);

        editText1=(EditText) findViewById(R.id.edt1);
        editText2=(EditText) findViewById(R.id.edt2);
        editText3=(EditText) findViewById(R.id.edt3);

        checkBox1=(CheckBox) findViewById(R.id.cb1);


        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {



        String str1= editText1.getText().toString();
        String str2=editText2.getText().toString();
        String str3=editText3.getText().toString();
        if (str1.length()==0){
            editText1.setError("Insert Name");
            Toast.makeText(MainActivity.this, "Insert Name", Toast.LENGTH_SHORT).show();
            Log.e("Main","put some value");
            return;

        }

         else if (str2.length()==0)
        {
            editText2.setError("Insert ID");
            Toast.makeText(MainActivity.this,"Insert ID",Toast.LENGTH_SHORT).show();
            Log.e("Main","Put some value");
            return;

        }
         else if (str3.length()==0)
        {
            editText3.setError("Insert Age");
            Toast.makeText(MainActivity.this,"Insert Age",Toast.LENGTH_SHORT).show();
            Log.e("Main","Put some value");
            return;

        }




        try {
            Intent intent=new Intent(MainActivity.this,Details.class);
            intent.putExtra("str_key1",str1);
            intent.putExtra("str_key2",str2);
            intent.putExtra("str_key3",str3);
           intent.putExtra("boll",checkBox1.isChecked());
            startActivity(intent);

        } catch (ActivityNotFoundException e) {

            Log.e("Main", "Activity is not mention in Manifest " + e.getMessage());
            Toast.makeText(MainActivity.this, "Check Manifaest", Toast.LENGTH_SHORT).show();

        }
    }
}
