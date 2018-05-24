package banana.mybk.Activities;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import android.util.*;

import java.util.Calendar;
import java.util.List;

import banana.mybk.Const;
import banana.mybk.Database.ScheduleDataSource;
import banana.mybk.Database.Subject;
import banana.mybk.R;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imgSchedule;
    ImageView imgExam;
    NotificationManager manager;
    public boolean isNotiOnMon = false;
    public boolean isNotiOnTue = false;
    public boolean isNotiOnWed = false;
    public boolean isNotiOnThu = false;
    public boolean isNotiOnFri = false;
    public boolean isNotiOnSat = false;
    static final int dayToMilliSecond = 24*3600*1000;
    public int timeStamp;
    public int reqCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgSchedule = (ImageView)findViewById(R.id.schedule);
        imgExam = (ImageView)findViewById(R.id.exam);
        imgSchedule.setOnClickListener(this);
        imgExam.setOnClickListener(this);
        loadDB();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.schedule:
                Intent intent = new Intent(this, ScheduleActivity.class);
                MainActivity.this.startActivity(intent);
                this.finish();
                break;
            case R.id.exam:
                Intent intent1 = new Intent(this, ExamActivity.class);
                MainActivity.this.startActivity(intent1);
                this.finish();
                break;
        }
    }

    public class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, intent.getStringExtra("param"),Toast.LENGTH_SHORT).show();
        }

    }

    public void setAlarm(int id, String subject){
        Context context = getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(true);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("You've got " + subject + " tomorrow!!!");
        builder.setContentText("Wipe to turn off notification");
        builder.setSmallIcon(R.drawable.logo);
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setSubText("ATTENTION!");   //API level 16
        builder.setNumber(100);
        builder.build();
        Notification myNotication = builder.getNotification();
        myNotication.flags |= Notification.FLAG_AUTO_CANCEL;
        myNotication.flags |= Notification.FLAG_ONLY_ALERT_ONCE;
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(id, myNotication);
    }

    public void loadDB() {
        ScheduleDataSource datasource = new ScheduleDataSource(this);
        //datasource.deleteSubject("'CO3002'");
        //datasource.deleteSubject("'CO3033'");
        //datasource.deleteSubject("'CO3034'");
        //datasource.deleteSubject("'CO3003'");
        List<Subject> values = datasource.getAllSubject();
        if(values.size() == 0) {
            datasource.createSubject("'CO3002'", "'CONG NGHE PHAN MEM'", 1, 2, 3, "'L02'",
                    7, "'7-9'", "'201H1'", "'10|11'", "'12/06'", "'12g30'", "'109H6'");
            datasource.createSubject("'CO3033'", "'BAO MAT HE THONG THONG TIN'", 2, 1, 3, "'L01'"
                    , 4, "'1-3'", "'201H2'", "'10|11'", "'13/06'", "'12g30'", "'109H6'");
            datasource.createSubject("'CO3034'", "'MAT MA AN NINH MANG'", 1, 2, 3, "'L03'"
                    , 2, "'4-6'", "'301H1'", "'10|11'", "'14/06'", "'12g30'", "'301H1'");
            datasource.createSubject("'CO3003'", "'CAU TRUC ROI RAC'", 1, 2, 3, "'L01'"
                    , 6, "'10-12'", "'203H2'", "'10|11'", "'15/06'", "'12g30'", "'203H2'");
        }
        startAlarm();
    }

    public void startAlarm() {
        ScheduleDataSource datasource = new ScheduleDataSource(this);
        Calendar c = Calendar.getInstance();
        List<Subject> values = datasource.getAllSubject();
        for (int i = 0; i < values.size(); i++){
            switch((int)values.get(i).getDate()){
                case 2:
                    if (!isNotiOnMon) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY) == 0) {
                            setAlarm(2, values.get(i).getName());
                            isNotiOnMon = true;
                        }
                    }
                    break;
                case 3:
                    if (!isNotiOnTue) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY) == 0) {
                            setAlarm(3, values.get(i).getName());
                            isNotiOnTue = true;
                        }
                    }
                    break;
                case 4:
                    if (!isNotiOnWed) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.TUESDAY) == 0) {
                            setAlarm(4, values.get(i).getName());
                            isNotiOnWed = true;
                        }
                    }
                    break;
                case 5:
                    if (!isNotiOnThu) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.WEDNESDAY) == 0) {
                            setAlarm(5, values.get(i).getName());
                            isNotiOnThu = true;
                        }
                    }
                    break;
                case 6:
                    if (!isNotiOnFri) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.THURSDAY) == 0) {
                            setAlarm(6, values.get(i).getName());
                            isNotiOnFri = true;
                        }
                    }
                    break;
                case 7:
                    if (!isNotiOnSat) {
                        if (abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY) == 0) {
                            setAlarm(7, values.get(i).getName());
                            isNotiOnSat = true;
                        }
                    }
                    break;
            }
        }
    }

}



