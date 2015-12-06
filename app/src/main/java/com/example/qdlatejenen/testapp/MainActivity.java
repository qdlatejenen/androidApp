package com.example.qdlatejenen.testapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String DEBUGTAG = "KWI";
    public static final String TEXTFILE = "kwi.txt";
    public static final String FILESAVED = "fileSaved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addSaveButtonListener();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean fileSaved = prefs.getBoolean(FILESAVED, false);
        if (fileSaved) {
            loadSavedFile();
        }
    }

    private void loadSavedFile() {
        try {
            FileInputStream fis = openFileInput(TEXTFILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            EditText editText = (EditText) findViewById(R.id.text);

            String line;
            int l = 0;
            while ((line = reader.readLine()) != null) {
                l++;
                editText.append(l + ". " + line);
                editText.append("\n");
                Log.d(DEBUGTAG, "line: " + line);

            }
            fis.close();
        } catch (Exception e) {
            Log.d(DEBUGTAG, "Error while reading a file: " + e);
        }
    }

    private void addSaveButtonListener() {
        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.text);
                String text = editText.getText().toString();
                try {
                    /*FileOutputStream fos = openFileOutput(TEXTFILE, Context.MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();

                    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(FILESAVED, true);
                    editor.commit();*/
                    Toast.makeText(MainActivity.this, getString(R.string.toast_cant_save), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.d(DEBUGTAG, "Error while saving a file: " + e);
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
