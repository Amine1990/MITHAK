package org.android.mobile.hibah.mithak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 20/06/2015.
 */
public class Activity_login extends Activity  {


    Button btn1;
    Button btn2;

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1=(Button)findViewById(R.id.btnSignUp);
        btn2=(Button)findViewById(R.id.btnSingIn);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent myintent = new Intent(Activity_login.this,Activity_sign_up_screen.class);
                startActivity(myintent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_login.this, Activity_sign_in_screen.class);
                startActivity(myIntent);
            }
        });
    }





}
