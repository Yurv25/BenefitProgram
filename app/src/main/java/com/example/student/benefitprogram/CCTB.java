package com.example.student.benefitprogram;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CCTB extends ActionBarActivity {

    private String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctb);

        TextView t2 = (TextView) findViewById(R.id.textView30);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void calculation(View view){
        EditText inc = (EditText) findViewById(R.id.enterinc);
        EditText dep = (EditText) findViewById(R.id.enterchild);
        TextView myin = (TextView) findViewById(R.id.textView11);
        TextView mydep = (TextView) findViewById(R.id.textView12);

        int count=0;
        try {
            int i = Integer.parseInt(inc.getText().toString());
            int d = Integer.parseInt(dep.getText().toString());
            InputStream is = getAssets().open("CCTB.csv");
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String line;

            while((line = bf.readLine()) != null){
                data = line.split(",");
                if(count==0){
                    if(i <= Integer.parseInt(data[0]) && i >0){
                        myin.setText(inc.getText());
                        switch(d){
                            case 1:
                                mydep.setText(data[1]);
                                break;
                            case 2:
                                mydep.setText(data[2]);
                                break;
                            case 3:
                                mydep.setText(data[3]);
                                break;
                        }
                        break;
                        //start activity
                    }
                    else{
                        count = Integer.parseInt((data[0])); //previous value
                    }

                }
                else if(i > count && i <= Integer.parseInt(data[0])){
                    myin.setText(inc.getText());
                    switch(d){
                        case 1:
                            mydep.setText(data[1]);
                            break;
                        case 2:
                            mydep.setText(data[2]);
                            break;
                        case 3:
                            mydep.setText(data[3]);
                            break;
                    }
                    break;
                    //start activity
                }
                else if(i > Integer.parseInt(data[0])){
                    count = Integer.parseInt(data[0]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid input",
                            Toast.LENGTH_LONG).show();
                    break;
                }

            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cctb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent inte  = new Intent(this,CCTBinfo.class);
            startActivity(inte);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
