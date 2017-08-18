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
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int)event.getRawX();

                        if(x_cord > windowwidth) {
                            x_cord = windowwidth;
                        }
                        else if(x_cord < totoro.getWidth()/2) {
                            x_cord = totoro.getWidth()/2;
                        }

                        totoro.setX(x_cord - totoro.getWidth()/2);

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
