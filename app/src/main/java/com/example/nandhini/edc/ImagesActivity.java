package com.example.nandhini.edc;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ImagesActivity extends AppCompatActivity {

    ViewPager viewPager;
    String []names=new String[]{"Mark Zuckerberg","   Bill Gates","  Steve Jobs"};
    private int dotcount;
    private ImageView[] dot;
    LinearLayout linearLayout;
    TextView textView;
    private final static String MENU_SELECTED = "selected";
    private int selected = -1;
    MenuItem menuItem;
    DateFormat dateFormat;
    Date date;
    Calendar cal;
    String time2,Sylendra="09:00",Chandra_Karlo="09:25",Padma_Subramanyam="09:50",Break1="10:15",Lakshaman_Krish="11:00";
    String Auto_annadurai="11:25",Malathi_kola="11:50",Lunch="12:15",Kurangan="13:25",Kirthi_Jayakumar="14:15",Shravan_Krishnan="14:40";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        Log.i("Time",String.valueOf(time2));
        menuInflater.inflate(R.menu.menu_bar,menu);
        if(((String)time2).compareTo(Sylendra)>=0){
            menuItem = (MenuItem) menu.findItem(R.id.Sylendra);
            menuItem.setChecked(true);
        }
        if(((String)time2).compareTo(Chandra_Karlo)>=0){
          MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Chandra_Karlo);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Break1)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.break1);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Lakshaman_Krish)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Lakshmanan_Krish);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Auto_annadurai)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Auto_Annadurai);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Malathi_kola)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Malathi_kola);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Lunch)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Lunch);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Kurangan)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Kurangan);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Kirthi_Jayakumar)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Kirthi_Jayakumar);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        if(((String)time2).compareTo(Shravan_Krishnan)>=0){
            MenuItem  menuItem1 = (MenuItem) menu.findItem(R.id.Shravan_Jayakumar);
            Log.i("Original",time2);
            menuItem1.setChecked(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        dateFormat = new SimpleDateFormat("HH:mm");
        date = new Date();
        cal = Calendar.getInstance();
        time2=dateFormat.format(cal.getTime());
        if (savedInstanceState != null){
            selected = savedInstanceState.getInt(MENU_SELECTED);
        }
        ImageAdapter imageAdapter=new ImageAdapter(this);
         viewPager=(ViewPager)findViewById(R.id.ViewPager);
         textView=(TextView)findViewById(R.id.textView);
         linearLayout=(LinearLayout)findViewById(R.id.LinearLayout);
        viewPager.setAdapter(imageAdapter);
        imageAdapter=new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);
        dotcount=imageAdapter.getCount();
        dot=new ImageView[dotcount];
        for(int i=0;i<dotcount;i++){
            dot[i]=new ImageView(this);
            dot[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,0,0);
            linearLayout.addView(dot[i],params);

        }
        dot[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.i("PagePresent",String.valueOf(i));
                textView.setText(names[i]);
            }
            @Override
            public void onPageSelected(int position) {
                int i;
                for(i=0;i<dotcount;i++){
                    dot[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dot[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
