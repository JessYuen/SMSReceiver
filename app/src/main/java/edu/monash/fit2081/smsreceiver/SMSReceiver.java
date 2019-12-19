package edu.monash.fit2081.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    public static final String TAG = "myMessage";
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
//        int len = messages.length;
//        String messLen = String.valueOf(len);
        for (int i = 0; i < messages.length; i++) {
//            Log.i(TAG, messLen);
            SmsMessage currentMessage = messages[i];
            String senderNum = currentMessage.getDisplayOriginatingAddress();
            String message = currentMessage.getDisplayMessageBody();
            Toast.makeText(context, "Sender: " + senderNum + ", message: " + message, Toast.LENGTH_LONG).show();
        }
    }
}
