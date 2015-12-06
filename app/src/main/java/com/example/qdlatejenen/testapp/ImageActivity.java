package com.example.qdlatejenen.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addTouchListener();
    }
//public void showPrompt(){
 //   All
//}
    public void addTouchListener() {
        ImageView image = (ImageView) findViewById(R.id.touch_image);
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float x = event.getX();
                float y = event.getY();

                String message = String.format("Coord: (%.2f,%.2f)", x, y);
                Log.d(MainActivity.DEBUGTAG, message);

                return false;
            }
        });
    }
}
