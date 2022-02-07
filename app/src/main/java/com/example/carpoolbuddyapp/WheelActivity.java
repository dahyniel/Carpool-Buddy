package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class WheelActivity extends AppCompatActivity
{
    private static final String [] prizes = {"Free cookies from Atrium", "1 day dress casual",
            "20 minutes in nap room", "Free lunch from Chartwells",
            "Free high five from Mr Lynch", "$10 from Annual Fund", "5 extra minutes of break",
            "Free drink from Rooftop Cafe", "1 day life pass"};

    private static final String [] sectors = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static final int [] sectorDegrees = new int[sectors.length];
    private static final Random random = new Random();
    private int degree = 0;
    private boolean spinning = false;
    private ImageView wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);

        wheel = findViewById(R.id.wheelImageView);
        final Button spinButton = findViewById(R.id.spinWheelButton);

        getDegreeForSectors();

        spinButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!spinning)
                {
                    spinWheel();
                    spinning = true;
                }
            }
        });
    }

    private void getDegreeForSectors()
    {
        int sectorDegree = 360/ sectors.length;

        for (int i = 0; i < sectors.length; i++)
        {
            sectorDegrees[i] = (i + 1) * sectorDegree;
        }
    }

    public void spinWheel()
    {
        degree = random.nextInt(sectors.length - 1);

        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegrees[degree], RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                Toast.makeText(WheelActivity.this, "You won " + prizes[sectors.length - (degree + 1)] + "!", Toast.LENGTH_SHORT).show();
                spinning = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        wheel.startAnimation(rotateAnimation);
    }
}