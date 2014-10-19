package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.view.View.OnTouchListener;
import android.view.View;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
//import android.widget.RelativeLayout.LayoutParams;
import java.util.Timer;

// This class is deprecated

public class ShareableOnTouchListener implements OnTouchListener{
    public boolean onTouch(View v,MotionEvent e){
        if(!(v instanceof Shareable))
            return false;
        Shareable shareable=(Shareable)v;
        //RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)shareable.getLayoutParams();
        //params.setMargins((int)e.getX(),(int)e.getY(),60,60);
        //System.out.println((int)e.getX());
        int action=e.getAction();
        if(action==MotionEvent.ACTION_DOWN&&!shareable.getMoving()){
            shareable.setTempX(shareable.getStartX());
            //System.out.println("Down Set");
            shareable.setTempY(shareable.getStartY());
        }
        if(action==MotionEvent.ACTION_MOVE&&!shareable.getMoving()){
            //System.out.print("Old :: "+shareable.getTempX());
            double temp=shareable.getTempY();

            shareable.setTempX(e.getRawX()-120);
            shareable.setTempY(e.getRawY()-580);
            shareable.setDy(temp-shareable.getTempY());
            //System.out.println(shareable.getDy());
            //System.out.println("Temp Bounds Set");
            shareable.setTempBounds();
            //shareable.startAnimation(animation);
        }
        if(action==MotionEvent.ACTION_UP&&!shareable.getMoving()){
            //System.out.println(shareable.getDy());
            if(shareable.getDy()>70){
                //System.out.println(shareable.getTempX());
                TranslateAnimation animation=new TranslateAnimation((float)shareable.getTempX()-520,(float)shareable.getTempX()-520,(float)shareable.getTempY()-780,-60-1500);
                animation.setDuration(2000);
                animation.setRepeatCount(0);
                shareable.startAnimation(animation);

                //int sec=0;
                //System.out.println("RISING!");
                //while(shareable.getTempY()>-60) {
                //    //sec++;
                //
                //    //System.out.println(shareable.getTempY());
                //    //try {
                //    //    wait(500);
                //    //}catch(InterruptedException error) {}
                //    //if(sec>30) {
                //        shareable.setTempY(shareable.getTempY() - .1);
                //        shareable.setTempBounds();
                //        //sec=0;
                //    //}
                //}
                //shareable.setStartBounds();

                //shareable.setMoving(true);
                //MainActivity ma=shareable.getReference();
                //Timer timer=new Timer();
                //timer.schedule(new LeaveScreenTimerTask(timer,shareable),0x0,1000);
                //ma.getTimeEvents().add(timer); // I dont think this is needed
            }//else
            shareable.setStartBounds();
            // add more here later
        }


        //shareable.setLayoutParams(params);
        // implement
        return true;
    }
}
