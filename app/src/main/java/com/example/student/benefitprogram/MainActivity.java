package com.example.student.benefitprogram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private String[] spdata = {"Monthly NCBS only entitlement", "Child Disability","GST/HST Credit: Guideline","CCTB/NCSB Guideline"};
    private Spinner s;
    List<String[]> l = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s = (Spinner) findViewById(R.id.optionsp) ;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spdata);
        s.setAdapter(adapter);

        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }


    public void show(View view){
        //Context ctx = null;
        Spinner sp = (Spinner) findViewById(R.id.optionsp);
        String txt = sp.getSelectedItem().toString();

        if(txt.equals(spdata[0])){
            Intent intent = new Intent(this, NCBS.class);
            startActivity(intent);
        }
        else if(txt.equals(spdata[1])){
            Intent intent = new Intent(this, ChildDisability.class);
            startActivity(intent);
        }
        else if(txt.equals(spdata[2])){
            Intent intent = new Intent(this, GSTHST.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, CCTB.class);
            startActivity(intent);
        }


        /*String[] data;
        try {
            InputStream is = getAssets().open("FamilyNCBS.csv");
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String line;

            while((line = bf.readLine()) != null){
                data = line.split(",");
                Log.i("my string", data[0]);
                TextView mytxt = (TextView) findViewById(R.id.textView2);
                mytxt.setText(data[0]);
                break;
            }
        } catch (IOException E){
            E.printStackTrace();
        }*/

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
