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
    private Shareable toSwitch;
    private long time;
    private double startX;
    private double startY;
    private double tempX;
    private double tempY;
    private double dy;
    private int image;
    private int selectedImage;
    private boolean moving;
    private boolean empty;
    private boolean recievesTouches;

    //private int run=0;

    public Shareable(Context context){
        this(context,0,0,-1);
    }

    public Shareable(Context context,int x,int y,int img){
        super(context);
        reference=null;
        toSwitch=null;
        image=R.drawable.empty;
        selectedImage=R.drawable.empty;
        if(img!=-1);
            setImageResource(R.drawable.empty);
        function=null;
        time=Long.MAX_VALUE;
        startX=x;
        startY=y;
        tempX=0;
        tempY=0;
        dy=0;
        moving=false;
        empty=image==R.drawable.empty||image==-1;
        recievesTouches=true;

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
    public double getDistance(double x,double y){
        return Math.sqrt((tempX-x)*(tempX-x)+(tempY-y)*(tempY-y));
    }

    // sets the background image to the selected image
    public void setCanSwitch(){
        setImageResource(selectedImage);
    }

    // sets the background image to the non-selected image
    public void setCanNotSwitch(){
        setImageResource(image);
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
        //params.
        //params.setMargins((int)x,(int)y,0,0);
        params.leftMargin=(int)x;
        params.topMargin=(int)y;
        setLayoutParams(params);
    }

    // switches places on the board with another shareable
    public void switchPlaces(Shareable other){
        double x=startX;
        double y=startY;
        startX=other.getStartX();
        startY=other.getStartY();
        other.setStartX(x);
        other.setStartY(y);
        setStartBounds();
        other.setStartBounds();
    }

    public boolean onTouchEvent(MotionEvent e){
        if((!recievesTouches||reference.getTime()-System.currentTimeMillis()>-2000)&&reference.getTime()!=Long.MAX_VALUE)
            return false;
        reference.setTime(Long.MAX_VALUE);
        int action=e.getAction();
        if(action== MotionEvent.ACTION_DOWN&&!moving){
            tempX=startX;
            tempY=startY;
        }
        if(action==MotionEvent.ACTION_MOVE&&!moving){
            double temp=tempY;
            tempX=e.getRawX()-120;
            tempY=e.getRawY()-580;
            reference.checkForSwitch(this);
            //tempX=e.getX();
            //tempY=e.getY();
            dy=temp-tempY;
            setTempBounds();
        }
        if(action==MotionEvent.ACTION_UP&&!moving){
            if(dy>40){
                TranslateAnimation animation=new TranslateAnimation((float)0,(float)0,(float)tempY-900,-2580);
                animation.setDuration(2000);
                reference.setTime(System.currentTimeMillis());
                animation.setRepeatCount(0);
                startAnimation(animation);
                if(toSwitch!=null){
                    toSwitch.setCanNotSwitch();
                    toSwitch=null;
                }
            }
            else{
                if(toSwitch!=null){
                    toSwitch.setCanNotSwitch();
                    switchPlaces(toSwitch);
                    toSwitch=null;
                }
            }
            setStartBounds();
        }
        return true;
    }

    // getter methods
    public MainActivity getReference(){return reference;}
    public ShareFunction getShareFunction(){return function;}
    public Shareable getToSwitch(){return toSwitch;}
    public double getStartX(){return startX;}
    public double getStartY(){return startY;}
    public double getTempX(){return tempX;}
    public double getTempY(){return tempY;}
    public double getDy(){return dy;}
    public int getImage(){return image;}
    public int getSelectedImage(){return selectedImage;}
    public boolean getMoving(){return moving;}
    public boolean getEmpty(){return empty;}
    public boolean getRecievesTouches(){return recievesTouches;}

    // setter methods
    public void setReference(MainActivity param){reference=param;}
    public void setShareFunction(ShareFunction param){function=param;}
    public void setToSwitch(Shareable param){toSwitch=param;}
    public void setStartX(double param){startX=param;}
    public void setStartY(double param){startY=param;}
    public void setTempX(double param){tempX=param;}
    public void setTempY(double param){tempY=param;}
    public void setDy(double param){dy=param;}
    public void setImage(int param){image=param;}
    public void setSelectedImage(int param){selectedImage=param;}
    public void setMoving(boolean param){moving=param;}
    public void setEmpty(boolean param){empty=param;}
    public void setRecievesTouches(boolean param){recievesTouches=param;}
}
