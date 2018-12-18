package com.android.fronc.project_09_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MyFeedbackReceiver extends BroadcastReceiver {

    private Handler handler = new Handler();

    @Override
    public void onReceive(final Context context, Intent intent) {
        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Broadcast feedback detected", Toast.LENGTH_LONG).show();
            }
        }, 40000);
        Bundle results = getResultExtras(true);
        final String feedback = results.getString("FEEDBACK_STRING");
        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Feedback from all applications: " + feedback, Toast.LENGTH_LONG).show();
            }
        }, 48000);
    }

}
