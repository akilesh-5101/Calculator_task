package com.abolt.hybridcalculator_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentInputop.Fragment_inputListener{
    private FragmentInputop fragIn;
    private FragmentOutput fragOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragIn = new FragmentInputop();
        fragOut = new FragmentOutput();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_input, fragIn)
                .replace(R.id.container_output, fragOut).commit();

    }

    @Override
    public void onInputSent(double a, String s) {
        fragOut.updateText(a, s);
    }

}