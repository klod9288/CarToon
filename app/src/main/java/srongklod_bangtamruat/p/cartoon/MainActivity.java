package srongklod_bangtamruat.p.cartoon;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ScaleGestureDetector radar;
    private ImageView image1;
    Matrix matrix = new Matrix();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radar = new ScaleGestureDetector(this, new ScaleListener());
        image1 = (ImageView)findViewById(R.id.imv1);
        image1.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        radar.onTouchEvent(event);

        ImageView view = (ImageView)v;
        view.setImageMatrix(matrix);

        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector radar){

            float scaleFactor = radar.getScaleFactor();
            matrix.postScale(scaleFactor, scaleFactor)  ;

            return true;
        }

    }
}


