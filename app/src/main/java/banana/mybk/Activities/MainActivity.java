package banana.mybk.Activities;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
        ScheduleDataSource datasource = new ScheduleDataSource(this);
        Calendar c = Calendar.getInstance();
        List<Subject> values = datasource.getAllSubject();
        for (int i = 0; i < values.size(); i++){
            switch((int)values.get(0).getDate()){
                case 2:
                    if (!isNotiOnMon) {
                    timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY) * dayToMilliSecond;
                    setAlarm(timeStamp, 2);
                    isNotiOnMon = true;
                }
                    break;
                case 3:
                    if (!isNotiOnTue) {
                        timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY) * dayToMilliSecond;
                        setAlarm(timeStamp, 3);
                        isNotiOnTue = true;
                    }
                    break;
                case 4:
                    if (!isNotiOnWed) {
                        timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.TUESDAY) * dayToMilliSecond;
                        setAlarm(timeStamp, 4);
                        isNotiOnWed = true;
                    }
                    break;
                case 5:
                    if (!isNotiOnThu) {
                        timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.WEDNESDAY) * dayToMilliSecond;
                        setAlarm(timeStamp, 5);
                        isNotiOnThu = true;
                    }
                    break;
                case 6:
                    if (!isNotiOnFri) {
                        timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.THURSDAY) * dayToMilliSecond;
                        setAlarm(timeStamp, 6);
                        isNotiOnFri = true;
                    }
                    break;
                case 7:
                    if (!isNotiOnSat) {
                        timeStamp = abs(c.get(Calendar.DAY_OF_WEEK) - Calendar.FRIDAY) * dayToMilliSecond;
                        setAlarm(timeStamp, 7);
                        isNotiOnSat = true;
                    }
                    break;
            }
        }
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

    public void setAlarm(int setTime, int reqCode){
        Intent intent = new Intent(MainActivity.this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqCode, intent, 0);
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(am.RTC_WAKEUP, setTime, dayToMilliSecond * 7, pendingIntent);
    }
}



