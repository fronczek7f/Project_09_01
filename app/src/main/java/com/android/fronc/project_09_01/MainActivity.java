package com.android.fronc.project_09_01;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyFeedbackReceiver myReceiver;
    private IntentFilter mIntentFilter;

    public final static String CUSTOM_EVENT = "com.android.fronc.project_09_01";
    public final static String EXTRA_EVENT_TEXT = "com.android.fronc.project_09_01.EXTRA_MESSAGE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyFeedbackReceiver();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("com.android.fronc.project_09_02");
        registerReceiver(myReceiver, mIntentFilter);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    public void onClickSend(View view) {
        Toast.makeText(this, "Send simple broadcast", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction(CUSTOM_EVENT);
        intent.putExtra(EXTRA_EVENT_TEXT, "sendBroadcast");
        sendBroadcast(intent);
    }

    public void onClickSendOrdered(View view) {
        Toast.makeText(this, "Send ordered broadcast", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setAction(CUSTOM_EVENT);
        intent.putExtra(EXTRA_EVENT_TEXT, "sendBroadcastOrdered");

        Bundle initialExtras = new Bundle();
        initialExtras.putString("INITIAL_STRING", "An extra initial string");

        sendOrderedBroadcast(intent,null, new MyFeedbackReceiver(),null, Activity.RESULT_OK,null,initialExtras);
    }
}
