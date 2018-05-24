package banana.mybk.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import banana.mybk.Activities.MainActivity;
import banana.mybk.R;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.logo)
                .setContentTitle("SCHEDULE NOTIFY")
                .setContentText("You've got class today!!!")
                //.setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND);
        //for(int i=2; i<7; i++){
            notificationManager.notify(0, mNotifyBuilder.build());
        //}
    }

}