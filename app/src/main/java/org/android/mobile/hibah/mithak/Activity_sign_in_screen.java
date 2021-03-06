package org.android.mobile.hibah.mithak;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 20/06/2015.
 */
public class Activity_sign_in_screen extends Activity {

    EditText email, password;
    Button btnReturn, btnLogin, btnForget;
    String emailtext, passwordtext;
    List<NameValuePair> params;
    SharedPreferences pref;
    Dialog reset;
    ServerRequest sr;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        Log.d("Activity_sign_in_screen", "START ACTIVITY");
        sr=new ServerRequest();


        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btnReturn=(Button)findViewById(R.id.btnReturn);
        btnLogin=(Button)findViewById(R.id.btnSingIn);
        btnForget=(Button)findViewById(R.id.btnFrgt);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReturn = new Intent(Activity_sign_in_screen.this, Activity_login.class);
                startActivity(intentReturn);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Activity_sign_in_screen", "CLIC BOUTON SIGN IN");
                emailtext=email.getText().toString();
                passwordtext=password.getText().toString();
                params=new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", emailtext));
                params.add(new BasicNameValuePair("password", passwordtext));


                ServerRequest sr = new ServerRequest();
                Log.d("Activity_sign_in_screen", "APPEL SERVER REQUEST AVANT");

                JSONObject json = sr.getJSON("http://10.0.2.2:8080/login", params);
                Log.d("Activity_sign_in_screen", "APPEL SERVER REQUEST APRES");


                if(json!=null)
                {
                    Log.d("Activity_sign_in_screen","JSON IS NOT NULL");

                    try
                        {
                            String jsonstr = json.getString("response");
                            if(json.getBoolean("res"))
                            {
                                String token=json.getString("token");
                                String grav = json.getString("grav");
                                SharedPreferences.Editor edit = pref.edit();
                                //Storing data using sharedPreferences
                                edit.putString("token", token);
                                edit.putString("grav", grav);
                                edit.commit();
                                Intent profactivity = new Intent(Activity_sign_in_screen.this, Activity_login.class);
                                startActivity(profactivity);
                                finish();

                                Toast.makeText(getApplication(), jsonstr,Toast.LENGTH_LONG).show();
                            }

                        }
                    catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                }
                else
                    Log.d("Activity_sign_in_screen","JSON IS NULL");
            }
        });




    }



}
