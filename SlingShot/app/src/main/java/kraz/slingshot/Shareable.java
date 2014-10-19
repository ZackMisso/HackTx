package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

//import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.content.Context;
import android.widget.RelativeLayout;
//import java.util.ArrayList;

public class Shareable extends ImageView{
    private MainActivity reference;
    private ShareFunction function;
    private double startX;
    private double startY;
    private double tempX;
    private double tempY;
    private double dy;
    private boolean moving;
    private boolean empty;

    //private int run=0;

    public Shareable(Context context){
        this(context,0,0,-1);
    }

    public Shareable(Context context,int x,int y,int image){
        super(context);
        reference=null;
        if(image!=-1);
            setImageResource(R.drawable.empty);
        function=null;
        startX=x;
        startY=y;
        tempX=0;
        tempY=0;
        dy=0;
        moving=false;
        empty=image==R.drawable.empty||image==-1;

        //System.out.println("THIS WAS RAN!!!");
        // implement the rest
        // creates the bounds
        //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //params.alignWithParent=true;
        //params.setMargins(startX,startY,60,60);
        //setLayoutParams(params);

        // sets the location
        setStartBounds();
        // sets the click listener
        //setOnTouchListener(new ShareableOnTouchListener());
    }

    // returns the distance between this shareable and the coordinates
    public double getDistance(int x,int y){
        return Math.sqrt((double)((tempX-x)*(tempX-x)+(tempY-y)*(tempY-y)));
    }

    // sets the location to the start position
    public void setStartBounds(){
        makeBounds(startX,startY);
    }

    // sets the location to the temporary position
    public void setTempBounds(){
        makeBounds(tempX,tempY);
    }

    // sets the location to the parameter coordinates
    private void makeBounds(double x,double y){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(240,240);
        params.alignWithParent=true;
        //params.setMargins((int)x,(int)y,0,0);
        params.leftMargin=(int)x;
        params.topMargin=(int)y;
        setLayoutParams(params);
    }

    public boolean onTouchEvent(MotionEvent e){
        int action=e.getAction();
        if(action== MotionEvent.ACTION_DOWN&&!moving){
            tempX=startX;
            tempY=startY;
        }
        if(action==MotionEvent.ACTION_MOVE&&!moving){
            double temp=tempY;
            tempX=e.getRawX()-120;
            tempY=e.getRawY()-580;
            dy=temp-tempY;
            setTempBounds();
        }
        if(action==MotionEvent.ACTION_UP&&!moving){
            if(dy>70){
                TranslateAnimation animation=new TranslateAnimation((float)tempX-520,(float)tempX-520,(float)tempY-780,-60-1500);
                animation.setDuration(2000);
                animation.setRepeatCount(0);
                startAnimation(animation);
            }
            setStartBounds();
        }
        return true;
    }

    // getter methods
    public MainActivity getReference(){return reference;}
    public ShareFunction getShareFunction(){return function;}
    public double getStartX(){return startX;}
    public double getStartY(){return startY;}
    public double getTempX(){return tempX;}
    public double getTempY(){return tempY;}
    public double getDy(){return dy;}
    public boolean getMoving(){return moving;}

    // setter methods
    public void setReference(MainActivity param){reference=param;}
    public void setShareFunction(ShareFunction param){function=param;}
    public void setStartX(double param){startX=param;}
    public void setStartY(double param){startY=param;}
    public void setTempX(double param){tempX=param;}
    public void setTempY(double param){tempY=param;}
    public void setDy(double param){dy=param;}
    public void setMoving(boolean param){moving=param;}
}
