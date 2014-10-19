package kraz.slingshot;

import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.content.Context;
import android.widget.RelativeLayout;
//import java.awt.Color;

public class TopBackground extends ImageView{
    public TopBackground(Context context){
        super(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // implement
        setLayoutParams(params);
        setDisconnected();
    }

    // sets the normal screen when there is no connection
    public void setDisconnected(){
        setBackgroundColor(Color.rgb(0,0,0));
    }

    // sets the background to green
    public void setConnected(){
        setBackgroundColor(Color.rgb(0,255,0));
    }

    // sets the error screen when there is an error connecting
    public void setError(){
        setBackgroundColor(Color.rgb(255,0,0));
    }
}
