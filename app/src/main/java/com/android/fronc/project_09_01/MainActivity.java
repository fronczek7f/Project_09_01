package com.android.fronc.project_09_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String CUSTOM_EVENT = "com.android.fronc.project_09_01";
    public final static String EXTRA_EVENT_TEXT = "com.android.fronc.project_09_01.EXTRA_MESSAGE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSend(View view) {
        Toast.makeText(this, "Send simple broadcast", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setAction(CUSTOM_EVENT);
        intent.putExtra(EXTRA_EVENT_TEXT, "sendBroadcast");
        sendBroadcast(intent);
    }

    public void onClickSendOrdered(View view) {
        Toast.makeText(this, "Send ordered broadcast", Toast.LENGTH_LONG).show();
        Intent intent = new Intent("com.android.fronc.project_09_01");
        intent.putExtra(EXTRA_EVENT_TEXT, "sendBroadcastOrdered");

        Bundle extras = new Bundle();
        extras.putString("stringExtra", "An extra initial string");

        sendOrderedBroadcast(intent, null, new MyFeedbackReceiver(),
                null, 0, "An extra initial string", extras);
    }
}
