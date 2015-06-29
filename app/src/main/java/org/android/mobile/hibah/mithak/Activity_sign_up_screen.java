package org.android.mobile.hibah.mithak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 20/06/2015.
 */
public class Activity_sign_up_screen extends Activity  {

    Button btn;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        btn=(Button)findViewById(R.id.btnReturn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Activity_sign_up_screen.this,Activity_login.class);
                startActivity(myintent);
            }
        });


    }





    }

