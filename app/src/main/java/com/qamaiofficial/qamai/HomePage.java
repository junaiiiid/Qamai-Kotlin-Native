package com.qamaiofficial.qamai;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import kotlin.jvm.internal.Intrinsics;


public class HomePage extends AppCompatActivity{

    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initialize();
        LoadImages();

        Button Login=(Button)findViewById(R.id.Homebtn_login);
        TextView Signup=(TextView)findViewById(R.id.signup_txt);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }


    private void LoadImages(){
        sliderView = findViewById(R.id.imageSlider);

        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(5); //HOW MANY IMAGES YOU WANT TO ADD

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION);
        // sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.QamaiGreen));
        sliderView.setIndicatorUnselectedColor(getResources().getColor(R.color.LightGray));
        // sliderView.startAutoCycle();

    }

    private final void initialize() {
        Window window;
        if (Build.VERSION.SDK_INT >= 28) {
            window = this.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            WindowManager.LayoutParams attrib = window.getAttributes();
            attrib.layoutInDisplayCutoutMode = 0;
        }

        if (Build.VERSION.SDK_INT != 21 && Build.VERSION.SDK_INT != 22) {
            window = this.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            window.setStatusBarColor(getResources().getColor(R.color.QamaiThemeColor));
        }

        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.QamaiThemeColor));
    }


}
