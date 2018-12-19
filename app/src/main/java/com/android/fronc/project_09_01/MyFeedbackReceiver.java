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
        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultCode++;
        stringExtra += "->SenderReceiver";

        final String toastText = "SenderReceiver\n" +
                "resultCode: " + resultCode + "\n" +
                "resultData: " + resultData + "\n" +
                "stringExtra: " + stringExtra;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
            }
        }, 12000);

        resultData = "SenderReceiver";
        resultExtras.putString("stringExtra", stringExtra);

        setResult(resultCode, resultData, resultExtras);
    }

}
