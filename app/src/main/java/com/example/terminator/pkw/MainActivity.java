package com.example.terminator.pkw;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    boolean doubleBackToExitPressedOnce = false;

    @BindView(R.id.slider)
    SliderLayout sliderLayout;

    HashMap<String,Integer> Hash_file_maps ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        imageSlider();
    }

    @Override
    public void onBackPressed() {
        //if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            System.exit(0);
            return;
        //}
    };

    @OnClick(R.id.click_menu1)
    void profile(View v){
        v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.click_anim));
        Intent a = new Intent(MainActivity.this, ProfileSekolah.class);
        startActivity(a);
        finish();
    }

    @OnClick(R.id.click_menu2)
    void daftar(View v){
        v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.click_anim));
        Intent a = new Intent(MainActivity.this, DaftarSiswaActivity.class);
        startActivity(a);
        finish();
    }

    @OnClick(R.id.click_menu3)
    void masuk(View v){
        v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.click_anim));
        Intent a = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(a);
        finish();
    }

    public void imageSlider(){
        Hash_file_maps = new HashMap<String, Integer>();

        Hash_file_maps.put("",R.drawable.slide1);
        Hash_file_maps.put(" ",R.drawable.slide2);
        Hash_file_maps.put("  ",R.drawable.slide3);
        Hash_file_maps.put("   ",R.drawable.slide4);

        for(String name : Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(MainActivity.this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(6000);
        sliderLayout.addOnPageChangeListener(MainActivity.this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


}
