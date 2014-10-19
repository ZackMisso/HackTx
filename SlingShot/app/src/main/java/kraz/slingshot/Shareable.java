package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

//import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.content.Context;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class Shareable extends ImageView{
    private ArrayList<Shareable> reference;
    private ShareFunction function;
    private int startX;
    private int startY;
    private int tempX;
    private int tempY;
    private boolean moving;

    public Shareable(Context context){
        this(context,0,0,"");
    }

    public Shareable(Context context,int x,int y,String image){
        super(context);
        setImageResource(R.drawable.empty);
        //System.out.println("THIS WAS RAN!!!");
        // implement the rest
        // create the bounds
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.alignWithParent=true;
        params.setMargins(x,y,60,60);
        setLayoutParams(params);
        // sets the click listener
        this.setOnTouchListener(new ShareableOnTouchListener());
    }

    // getter methods
    public ShareFunction getShareFunction(){return function;}

    // setter methods
    public void setShareFunction(ShareFunction param){function=param;}
}
