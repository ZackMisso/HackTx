package kraz.slingshot;

import java.util.TimerTask;

/**
 * Created by ZackMisso on 10/18/14.
 */

import java.util.Timer;

public class LeaveScreenTimerTask extends TimerTask {
    private Timer reference;
    private Shareable shareable;

    public LeaveScreenTimerTask(Timer param,Shareable param2){
        super();
        reference=param;
        shareable=param2;
    }

    public void run(){
        shareable.setTempY(shareable.getTempY()-shareable.getDy());
        if(shareable.getTempY()<-60) {
            reference.cancel();
            shareable.setStartBounds();
            shareable.setMoving(false);
        }
    }

    // getter method
    //public
}
