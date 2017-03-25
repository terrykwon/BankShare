package com.sample.bankshare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sample.bankshare.main.MainActivity;

public class SigninActivity extends AppCompatActivity {
    Button btSigninM,btSigninFM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        (findViewById(R.id.bt_signin_auth)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("PPAP",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("is_login","y");
                editor.putString("name",((EditText)findViewById(R.id.et_signin_name)).getText().toString());
                editor.putString("birth",((EditText)findViewById(R.id.et_signin_birth)).getText().toString());
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        btSigninM = (Button)findViewById(R.id.bt_signin_man);
        btSigninFM = (Button)findViewById(R.id.bt_signin_woman);


        btSigninM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btSigninM.setBackground(getResources().getDrawable(R.drawable.btn_m_act));
                btSigninFM.setBackground(getResources().getDrawable(R.drawable.btn_fm_deact));
            }
        });
        btSigninFM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btSigninFM.setBackground(getResources().getDrawable(R.drawable.btn_fm_act));
                btSigninM.setBackground(getResources().getDrawable(R.drawable.btn_m_deact));
            }
        });


    }
}
