package sg.edu.rp.soi.knowyourfacts;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
public class ScheduledNotificationReceiver extends BroadcastReceiver {
    int notifReqCode = 123;
    @Override
    public void onReceive(Context context, Intent i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("This is for default notification");
            notificationManager.createNotificationChannel(channel);
        }
        PendingIntent pIntent = PendingIntent.getBroadcast(context, notifReqCode,
                i, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
        builder.setContentTitle("TIME UP");
        builder.setContentText("5 MINS TO READ TILL TIME UP");
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        builder.setPriority(Notification.PRIORITY_MAX);
        Notification n = builder.build();
        notificationManager.notify(notifReqCode, n);
    }
}