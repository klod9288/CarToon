package srongklod_bangtamruat.p.cartoon;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView imageView;
    Matrix matrix = new Matrix();
    private ScaleGestureDetector radar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radar = new ScaleGestureDetector(this, new ScaleListtenner());

        imageView = findViewById(R.id.imv1);
        imageView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        radar.onTouchEvent(event);
        ImageView view = (ImageView) v;
        view.setImageMatrix(matrix);
        return true;
    }

    private class ScaleListtenner extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            matrix.postScale(scaleFactor, scaleFactor);


            return true;
        }
    }

}
