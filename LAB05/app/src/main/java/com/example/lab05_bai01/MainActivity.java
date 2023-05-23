package com.example.lab05_bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode,
            btnZoomOutXml, btnZoomOutCode, btnRotateXml, btnRotateCode,
            btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    private void handleClickAnimationXml(Button btn, int animId)
    {
        switch (animId)
        {
            case R.anim.anim_fade_in:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_in);
                animation.setAnimationListener(animationListener);
                btnFadeInXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_fade_out:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_out);
                animation.setAnimationListener(animationListener);
                btnFadeOutXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_blink:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_blink);
                animation.setAnimationListener(animationListener);
                btnBlinkXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_bounce:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_bounce);
                animation.setAnimationListener(animationListener);
                btnBounceXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_combine:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_combine);
                animation.setAnimationListener(animationListener);
                btnCombineXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_rotate:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
                animation.setAnimationListener(animationListener);
                btnRotateXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_slide_up:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_slide_up);
                animation.setAnimationListener(animationListener);
                btnSlideUpXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_move:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_move);
                animation.setAnimationListener(animationListener);
                btnMoveXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_zoom_in:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_in);
                animation.setAnimationListener(animationListener);
                btnZoomInXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }

            case R.anim.anim_zoom_out:
            {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_out);
                animation.setAnimationListener(animationListener);
                btnZoomOutXml.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        ivUitLogo.startAnimation(animation);
                    }
                });
                break;
            }
        }
    }

    private void handleClickAnimationCode(Button btn, final Animation animation)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }

    private Animation initFadeInAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeOutAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initMoveAnimation()
    {
        TranslateAnimation animation = new TranslateAnimation(0f, 700f, 0f, 0f);
        animation.setDuration(800);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBlinkAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(300);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBounceAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 0f, 1f, 1f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private void initCombineAnimation()
    {
        RotateAnimation rotate = new RotateAnimation(0, 360);
        rotate.setDuration(600);
        rotate.setRepeatCount(2);

        ScaleAnimation zoomIn = new ScaleAnimation(1f, 3f, 1f, 3f, 50,50);
        zoomIn.setRepeatMode(Animation.RESTART);
        zoomIn.setDuration(3000);
        zoomIn.setFillAfter(true);

        ScaleAnimation zoomOut = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, 50, 50);
        zoomOut.setRepeatMode(Animation.RESTART);
        zoomOut.setFillAfter(true);
        zoomOut.setDuration(2000);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(zoomIn);
        animationSet.addAnimation(zoomOut);
        btnCombineCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animationSet);
            }
        });
    }

    private Animation initRotateAnimation()
    {
        RotateAnimation animation = new RotateAnimation(0, 360,100,100);
        animation.setDuration(600);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.RESTART);
        return animation;
    }

    private Animation initSlideUpAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 1f, 1f, 0f);
        animation.setFillAfter(true);
        animation.setDuration(500);
        return animation;
    }

    private Animation initZoomInAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 3f, 1f, 3f, 50,50);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        return animation;
    }

    private Animation initZoomOutAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, 50, 50);
        animation.setFillAfter(true);
        animation.setDuration(1000);
        return animation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        initCombineAnimation();
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNewActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
            }
        });
    }
}