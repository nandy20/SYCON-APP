package com.example.nandhini.edc;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdrawerlayout=(DrawerLayout)findViewById(R.id.drawer);
        mtoggle=new ActionBarDrawerToggle(this,mdrawerlayout,R.string.open,R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void SyconHome(View view){

        Intent intent=new Intent(this,ImagesActivity.class);
        startActivity(intent);
    }

    public void SyconPast(View view){

        Intent intent=new Intent(this,ImagesActivity.class);
        startActivity(intent);
    }
}
