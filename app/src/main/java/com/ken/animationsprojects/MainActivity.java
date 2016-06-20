package com.ken.animationsprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ken.animationsprojects.AnimationTween.TweenAnimationActivity;
import com.ken.animationsprojects.RevealAnimation.RevealAnimationActivity;
import com.ken.animationsprojects.RippleEffect.RippleEffectActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        findViewById(R.id.animation1).setOnClickListener(v -> startActivity(new Intent(this, TweenAnimationActivity.class)));
    }

    @OnClick(R.id.animation1)
    public void animation1(View v) {
        log("aqui");
        startActivity(new Intent(this, TweenAnimationActivity.class));

    }

    @OnClick(R.id.animation3)
    public void animation3(View view) {
        startActivity(new Intent(this, RippleEffectActivity.class));
    }

    @OnClick(R.id.animation_4)
    public void animation4(View v) {
        startActivity(new Intent(this, RevealAnimationActivity.class));
    }

    public void log(String content) {
        Log.i("myLog", content);
    }

}
