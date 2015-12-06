package com.example.qdlatejenen.testapp;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class ImageActivity extends AppCompatActivity implements PointCollecterListener{

    private PointCollector pointCollector = new PointCollector();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addTouchListener();
        showPrompt();
    }
private void showPrompt(){
    Builder builder = new Builder(this);
    builder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });
    builder.setTitle("Test title");
    builder.setMessage("Touch 4 points");
    AlertDialog dlg = builder.create();
    dlg.show();
    pointCollector.setListener(this);
}
    public void addTouchListener() {
        ImageView image = (ImageView) findViewById(R.id.touch_image);
        image.setOnTouchListener(pointCollector);
    }

    @Override
    public void pointsCollected(List<Point> points) {
        Log.d(MainActivity.DEBUGTAG, "Collected: "+points.size())
;    }
}
