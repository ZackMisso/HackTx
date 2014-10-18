package kraz.slingshot;

import android.widget.ImageView;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.content.Context;

public class TopBackground extends ImageView{
    public TopBackground(Context context){
        super(context);
        // implement
        setDisconnected();
    }

    // sets the normal screen when there is no connection
    public void setDisconnected(){
        // implement
    }

    // sets the background to green
    public void setConnected(){
        // implement
    }

    // sets the error screen when there is an error connecting
    public void setError(){
        // implement
    }
}
