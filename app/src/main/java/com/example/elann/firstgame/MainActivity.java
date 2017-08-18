package com.example.elann.firstgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

    int windowwidth;
    int windowheight;

    private LayoutParams layoutParams ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        windowwidth = getWindowManager().getDefaultDisplay().getWidth() - 64;
        windowheight = getWindowManager().getDefaultDisplay().getHeight() - 64;
        final ImageView totoro = (ImageView)findViewById(R.id.image_totoro);
        totoro.setY(windowheight - 128);

        totoro.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) totoro.getLayoutParams();
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int)event.getRawX();
                        //int y_cord = (int)event.getRawY();

                        if(x_cord > windowwidth) {
                            x_cord = windowwidth;
                        }
                        /*if(y_cord > windowheight) {
                            y_cord = windowheight;
                        }*/

                        totoro.setX(x_cord - totoro.getWidth()/2);
                        //totoro.setY(y_cord - totoro.getHeight()/2 - 25);

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
