package com.example.terminator.pkw;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

public class ProfileSekolah extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    HashMap<String,Integer> Hash_file_maps ;
    @BindView(R.id.slider)
    SliderLayout sliderLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_sekolah);
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Profile Sekolah");

        imageSlider();
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(ProfileSekolah.this, MainActivity.class);
        startActivity(a);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.click_menu1)
    void sejarah(View v){
        v.startAnimation(AnimationUtils.loadAnimation(ProfileSekolah.this, R.anim.click_anim));
    }

    @OnClick(R.id.click_menu2)
    void presatasi(View v){
        v.startAnimation(AnimationUtils.loadAnimation(ProfileSekolah.this, R.anim.click_anim));
    }

    @OnClick(R.id.click_menu3)
    void almat(View v){
        v.startAnimation(AnimationUtils.loadAnimation(ProfileSekolah.this, R.anim.click_anim));
    }

    @OnClick(R.id.click_menu4)
    void vsi(View v){
        v.startAnimation(AnimationUtils.loadAnimation(ProfileSekolah.this, R.anim.click_anim));
    }

    @OnClick(R.id.click_menu5)
    void misi(View v){
        v.startAnimation(AnimationUtils.loadAnimation(ProfileSekolah.this, R.anim.click_anim));
    }

    public void imageSlider(){
        Hash_file_maps = new HashMap<String, Integer>();

        Hash_file_maps.put("",R.drawable.slide1);
        Hash_file_maps.put(" ",R.drawable.slide2);
        Hash_file_maps.put("  ",R.drawable.slide3);
        Hash_file_maps.put("   ",R.drawable.slide4);

        for(String name : Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(ProfileSekolah.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(ProfileSekolah.this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(6000);
        sliderLayout.addOnPageChangeListener(ProfileSekolah.this);
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
