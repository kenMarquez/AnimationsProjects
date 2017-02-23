package com.ken.animationsprojects.viewproperties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import com.ken.animationsprojects.R;

public class ViewPropertiesActivity extends AppCompatActivity implements Runnable {

    private TextView fadee;
    private boolean fadingOut = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_properties);

        fadee = (TextView) findViewById(R.id.fadee);

    }

    @Override
    public void onResume() {
        super.onResume();
        run();

    }

    @Override
    public void onPause() {
        fadee.removeCallbacks(this);
        super.onPause();

    }

    @Override
    public void run() {
        float twelveDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12,
                getResources().getDisplayMetrics());
        if (fadingOut) {
            fadee.animate().alpha(0).setDuration(1000);

            fadee.animate().translationX(twelveDp);
            fadee.setText("Regresare!!");
        } else {
            fadee.animate().translationX(-twelveDp);
            fadee.animate().alpha(1).setDuration(1000);
            fadee.setText("Yeah!!!");
        }
        fadingOut = !fadingOut;
        fadee.postDelayed(this, 1500);
    }
}
