package banana.mybk.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import java.util.List;

import banana.mybk.Const;
import banana.mybk.Database.ScheduleDataSource;
import banana.mybk.Database.Subject;
import banana.mybk.R;

public class ExamActivity extends AppCompatActivity {

    private ScheduleDataSource datasource;
    private TextView txtCode, txtName, txtGroup, txtDay, txtTime, txtRoom;
    private TextView txtCode1, txtName1, txtGroup1, txtDay1, txtTime1, txtRoom1;
    private TextView txtCode2, txtName2, txtGroup2, txtDay2, txtTime2, txtRoom2;
    private TextView txtCode3, txtName3, txtGroup3, txtDay3, txtTime3, txtRoom3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backarrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBackBtn();
            }
        });
        datasource = new ScheduleDataSource(this);
        List<Subject> values = datasource.getAllSubject();
        setUp();
        if(values.size() != 0){
            bindDataToTable(values);
        }
    }

    public void clickBackBtn(){
        Intent intent = new Intent(this, MainActivity.class);
        ExamActivity.this.startActivity(intent);
        this.finish();
    }

    public void bindDataToTable(List<Subject> values){
        txtCode.setText(values.get(0).getCode());
        txtName.setText(values.get(0).getName());
        txtGroup.setText(values.get(0).getGroup());
        txtDay.setText(values.get(0).getDay());
        txtTime.setText(values.get(0).getTime());
        txtRoom.setText(values.get(0).getExamRoom());
        txtCode1.setText(values.get(1).getCode());
        txtName1.setText(values.get(1).getName());
        txtGroup1.setText(values.get(1).getGroup());
        txtDay1.setText(values.get(1).getDay());
        txtTime1.setText(values.get(1).getTime());
        txtRoom1.setText(values.get(1).getExamRoom());
        txtCode2.setText(values.get(2).getCode());
        txtName2.setText(values.get(2).getName());
        txtGroup2.setText(values.get(2).getGroup());
        txtDay2.setText(values.get(2).getDay());
        txtTime2.setText(values.get(2).getTime());
        txtRoom2.setText(values.get(2).getExamRoom());
        txtCode3.setText(values.get(3).getCode());
        txtName3.setText(values.get(3).getName());
        txtGroup3.setText(values.get(3).getGroup());
        txtDay3.setText(values.get(3).getDay());
        txtTime3.setText(values.get(3).getTime());
        txtRoom3.setText(values.get(3).getExamRoom());
    }
    public void setUp(){
        txtCode = findViewById(R.id.code1);
        txtName = findViewById(R.id.name1);
        txtGroup = findViewById(R.id.group1);
        txtDay = findViewById(R.id.day1);
        txtTime = findViewById(R.id.time1);
        txtRoom = findViewById(R.id.room1);
        txtCode1 = findViewById(R.id.code2);
        txtName1 = findViewById(R.id.name2);
        txtGroup1 = findViewById(R.id.group2);
        txtDay1 = findViewById(R.id.day2);
        txtTime1 = findViewById(R.id.time2);
        txtRoom1 = findViewById(R.id.room2);
        txtCode2 = findViewById(R.id.code3);
        txtName2 = findViewById(R.id.name3);
        txtGroup2 = findViewById(R.id.group3);
        txtDay2 = findViewById(R.id.day3);
        txtTime2 = findViewById(R.id.time3);
        txtRoom2 = findViewById(R.id.room3);
        txtCode3 = findViewById(R.id.code4);
        txtName3 = findViewById(R.id.name4);
        txtGroup3 = findViewById(R.id.group4);
        txtDay3 = findViewById(R.id.day4);
        txtTime3 = findViewById(R.id.time4);
        txtRoom3 = findViewById(R.id.room4);
    }

}