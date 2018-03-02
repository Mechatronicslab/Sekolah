package com.example.terminator.pkw;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView textJudul = (TextView) findViewById(R.id.textJudul);

        String customFont = "FFF_Tusj.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        textJudul.setTypeface(typeface);

    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(a);
        finish();
    }
}
