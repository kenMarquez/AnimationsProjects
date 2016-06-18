package com.ken.animationsprojects.AnimationTween;

import android.nfc.cardemulation.HostApduService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ken.animationsprojects.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenAnimationActivity extends AppCompatActivity {

    @BindView(R.id.tween_animation1)
    TextView tvAnimation1;

    @BindView(R.id.imageview)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ButterKnife.bind(this);

        tvAnimation1.setOnClickListener(v -> hacerAnimacion());


    }

    public void hacerAnimacion() {
        log("Haciendo animacion");
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_tween);
//        tvAnimation1.setAnimation(animation);
        tvAnimation1.startAnimation(animation);
    }

    @OnClick(R.id.button)
    public void clockwise(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

    @OnClick(R.id.button2)
    public void zoom(View view) {

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
    }

    @OnClick(R.id.button3)
    public void fade(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    @OnClick(R.id.button6)
    public void blink(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    @OnClick(R.id.button5)
    public void move(View view) {

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

    @OnClick(R.id.button6)
    public void slide(View view) {

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }


    public void log(String content) {
        Log.i("myLog", content);
    }


}
