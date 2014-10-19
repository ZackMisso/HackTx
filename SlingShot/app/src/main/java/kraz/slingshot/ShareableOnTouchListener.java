package kraz.slingshot;

/**
 * Created by ZackMisso on 10/18/14.
 */

import android.view.View.OnTouchListener;
import android.view.View;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
//import android.widget.RelativeLayout.LayoutParams;

public class ShareableOnTouchListener implements OnTouchListener{
    public boolean onTouch(View v,MotionEvent e){
        if(!(v instanceof Shareable))
            return false;
        Shareable shareable=(Shareable)v;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)shareable.getLayoutParams();
        params.setMargins(26,26,100,100);
        shareable.setLayoutParams(params);
        // implement
        return true;
    }
}
