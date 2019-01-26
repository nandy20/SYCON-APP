package com.example.nandhini.edc;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ImagesActivity extends AppCompatActivity {

    ViewPager viewPager;
    String []names=new String[]{"Mark Zuckerberg","   Bill Gates","  Steve Jobs"};
    private int dotcount;
    private ImageView[] dot;
    LinearLayout linearLayout;
    TextView textView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
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
