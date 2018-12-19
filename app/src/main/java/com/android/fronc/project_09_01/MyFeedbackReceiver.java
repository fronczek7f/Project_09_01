package com.android.fronc.project_09_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MyFeedbackReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Handler handler = new Handler();

        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);

        final String stringExtra = resultExtras.getString("stringExtra");

        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Broadcast feedback detected", Toast.LENGTH_LONG).show();
            }
        }, 28000);

        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, "Feedback from all applications: " + stringExtra, Toast.LENGTH_LONG).show();
            }
        }, 32000);

        resultData = "SenderReceiver";
        resultExtras.putString("stringExtra", stringExtra);

        resultCode++;
        setResult(resultCode, resultData, resultExtras);
    }

}
