package com.ken.animationsprojects.RevealAnimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ken.animationsprojects.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RevealAnimationActivity extends AppCompatActivity {

    @BindView(R.id.layout_reveal)
    LinearLayout revealLayout;

    @BindView(R.id.btn_show)
    Button showReveal;

    @BindView(R.id.tv1)
    TextView tv1;

    @BindView(R.id.tv2)
    TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_animation);
        ButterKnife.bind(this);
        revealLayout.setOnClickListener(view -> revealLayout.post(() -> hideReveal()));
        showReveal.setOnClickListener(view -> revealLayout.post(() -> startReveal()));


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        revealLayout.post(() -> startReveal());

    }

    private void startReveal() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade1);
        tv1.startAnimation(animation1);
        tv2.startAnimation(animation1);
        // get the center for the clipping circle
        int cx = (revealLayout.getLeft() + revealLayout.getRight()) / 2;
        int cy = (revealLayout.getTop() + revealLayout.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(revealLayout.getWidth(), revealLayout.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(revealLayout, cx, cy, 0, finalRadius);
        anim.setDuration(600);

        // make the view visible and start the animation
        revealLayout.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void hideReveal() {
        // get the center for the clipping circle
        int cx = (revealLayout.getLeft() + revealLayout.getRight()) / 2;
        int cy = (revealLayout.getTop() + revealLayout.getBottom()) / 2;

        // get the initial radius for the clipping circle
        int initialRadius = revealLayout.getWidth();

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(revealLayout, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                revealLayout.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();

    }


}
