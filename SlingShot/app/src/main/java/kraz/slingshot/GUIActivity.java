package kraz.slingshot;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Button;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
//import android.widget.TextView;
import java.util.Timer;

import java.util.ArrayList;


public class GUIActivity extends ActionBarActivity {
    private ArrayList<Shareable> shareables;
    private TranslateAnimation translateAnimation;
    //private ArrayList<Timer> timeEvents;
    private TopBackground topBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //timeEvents=new ArrayList<Timer>();

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout layout = new RelativeLayout(this);

        shareables=new ArrayList<Shareable>();
        for(int i=0;i<9;i++) {
            shareables.add(new Shareable(this,(i%3)*400+180,1900-(i/3)*300,R.drawable.empty));
            //shareables.get(i).setReference(this);
            //shareables.add(new Shareable(this,i,i,"@drawable/empty"));
            layout.addView(shareables.get(i));
        }

        topBackground=new TopBackground(this);
        //layout.addView(topBackground);

        this.addContentView(layout,params);

        // TEST CODE
        //setContentView(R.layout.activity_main);
        // create the layout with the width and the height
        //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        //RelativeLayout layout = new RelativeLayout(this);
        //layout.setOrientation(RelativeLayout.VERTI)
        // adds a text view
        //TextView txt=new TextView(this);
        //txt.setText("Demo text View");
        //txt.setLayoutParams(params);
        //layout.addView(txt);
        // adds a button
        //Button b1=new Button(this);
        //b1.setText("Button Text");
        //b1.setLayoutParams(params);
        //layout.addView(b1);
        //this.addContentView(layout,params);
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

    // getter methods
    public ArrayList<Shareable> getShareables(){return shareables;}
    public TranslateAnimation getTranslateAnimation(){return translateAnimation;}
    //public ArrayList<Timer> getTimeEvents(){return timeEvents;}

    // setter methods
    public void setShareables(ArrayList<Shareable> param){shareables=param;}
    public void setTranslateAnimation(TranslateAnimation param){translateAnimation=param;}
    //public void setTimeEvents(ArrayList<Timer> param){timeEvents=param;}
}

