package com.ab.fragmentcommunication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            MessageFragment messageFragment= new MessageFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,messageFragment,null).commit();
        }

    }

    @Override
    public void OnMessageSend(String message) {

        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message",message);
        displayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,displayFragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
