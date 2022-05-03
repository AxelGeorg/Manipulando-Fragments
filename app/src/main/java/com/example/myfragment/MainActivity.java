package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFragmentA, btnFragmentB;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnFragmentA = findViewById(R.id.buttonFragmentA);
        this.btnFragmentB = findViewById(R.id.buttonFragmentB);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.buttonFragmentA: fragment = new FragmentA(); break;
                    case R.id.buttonFragmentB: fragment = new FragmentB(); break;
                }

                AbraFrangmet();
            }
        };

        this.btnFragmentA.setOnClickListener(onClickListener);
        this.btnFragmentB.setOnClickListener(onClickListener);
    }

    public void AbraFrangmet()
    {
        if (this.fragment == null)
            return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, this.fragment);
        transaction.commit();
    }
}