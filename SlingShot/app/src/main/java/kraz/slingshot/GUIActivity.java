package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class GUIActivity extends ActionBarActivity {
    private ArrayList<Shareable> shareables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // create the layout with the width and the height
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        RelativeLayout layout = new RelativeLayout(this);
        //layout.setOrientation(RelativeLayout.VERTI)
        // adds a text view
        TextView txt=new TextView(this);
        txt.setText("Demo text View");
        txt.setLayoutParams(params);
        layout.addView(txt);
        // adds a button
        Button b1=new Button(this);
        b1.setText("Button Text");
        b1.setLayoutParams(params);
        layout.addView(b1);
        this.addContentView(layout,params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}