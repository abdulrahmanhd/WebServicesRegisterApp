package com.erpproject.androidapp.webservicesregisterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtname,txtusername,txtpassword,txtemail;
    String name,username,password,email;
    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnregister=(Button)findViewById(R.id.btnregister);
        txtname=(EditText)findViewById(R.id.txttname);
        txtusername=(EditText)findViewById(R.id.txttpassword);
        txtemail=(EditText)findViewById(R.id.txttemail);
        txtpassword=(EditText)findViewById(R.id.txttpassword);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtname.getText().toString();
                username = txtusername.getText().toString();
                email = txtemail.getText().toString();
                password = txtpassword.getText().toString();

                String key = "RegisterData";

                BachServerTask bachServerTask = new BachServerTask(getApplicationContext());
                bachServerTask.execute(key,name,username,email,password);

            }
        });
    }
}
