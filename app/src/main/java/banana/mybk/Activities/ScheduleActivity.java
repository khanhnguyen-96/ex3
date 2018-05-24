package banana.mybk.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.List;

import banana.mybk.Const;
import banana.mybk.Database.ScheduleDataSource;
import banana.mybk.Database.Subject;
import banana.mybk.R;

public class ScheduleActivity extends AppCompatActivity {

    private ScheduleDataSource datasource;
    private TextView txtCode, txtName, txtCredit, txtCreditFee, txtFee, txtGroup, txtDate, txtLesson, txtRoom, txtWeek;
    private TextView txtCode1, txtName1, txtCredit1, txtCreditFee1, txtFee1, txtGroup1, txtDate1, txtLesson1, txtRoom1, txtWeek1;
    private TextView txtCode2, txtName2, txtCredit2, txtCreditFee2, txtFee2, txtGroup2, txtDate2, txtLesson2, txtRoom2, txtWeek2;
    private TextView txtCode3, txtName3, txtCredit3, txtCreditFee3, txtFee3, txtGroup3, txtDate3, txtLesson3, txtRoom3, txtWeek3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
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
        ScheduleActivity.this.startActivity(intent);
        this.finish();
    }

    public void bindDataToTable(List<Subject> values){
        txtCode.setText(values.get(0).getCode());
        txtName.setText(values.get(0).getName());
        txtCredit.setText(String.valueOf(values.get(0).getCredit()));
        txtCreditFee.setText(String.valueOf(values.get(0).getCreditFee()));
        txtFee.setText(String.valueOf(values.get(0).getFee()));
        txtGroup.setText(values.get(0).getGroup());
        txtDate.setText(String.valueOf(values.get(0).getDate()));
        txtLesson.setText(values.get(0).getLesson());
        txtRoom.setText(values.get(0).getRoom());
        txtWeek.setText(values.get(0).getWeek());
        txtCode1.setText(values.get(1).getCode());
        txtName1.setText(values.get(1).getName());
        txtCredit1.setText(String.valueOf(values.get(1).getCredit()));
        txtCreditFee1.setText(String.valueOf(values.get(1).getCreditFee()));
        txtFee1.setText(String.valueOf(values.get(1).getFee()));
        txtGroup1.setText(values.get(1).getGroup());
        txtDate1.setText(String.valueOf(values.get(1).getDate()));
        txtLesson1.setText(values.get(1).getLesson());
        txtRoom1.setText(values.get(1).getRoom());
        txtWeek1.setText(values.get(1).getWeek());
        txtCode2.setText(values.get(2).getCode());
        txtName2.setText(values.get(2).getName());
        txtCredit2.setText(String.valueOf(values.get(2).getCredit()));
        txtCreditFee2.setText(String.valueOf(values.get(2).getCreditFee()));
        txtFee2.setText(String.valueOf(values.get(2).getFee()));
        txtGroup2.setText(values.get(2).getGroup());
        txtDate2.setText(String.valueOf(values.get(2).getDate()));
        txtLesson2.setText(values.get(2).getLesson());
        txtRoom2.setText(values.get(2).getRoom());
        txtWeek2.setText(values.get(2).getWeek());
        txtCode3.setText(values.get(3).getCode());
        txtName3.setText(values.get(3).getName());
        txtCredit3.setText(String.valueOf(values.get(3).getCredit()));
        txtCreditFee3.setText(String.valueOf(values.get(3).getCreditFee()));
        txtFee3.setText(String.valueOf(values.get(3).getFee()));
        txtGroup3.setText(values.get(3).getGroup());
        txtDate3.setText(String.valueOf(values.get(3).getDate()));
        txtLesson3.setText(values.get(3).getLesson());
        txtRoom3.setText(values.get(3).getRoom());
        txtWeek3.setText(values.get(3).getWeek());
    }
    public void setUp(){
        txtCode = findViewById(R.id.code1);
        txtCredit = findViewById(R.id.credit1);
        txtName = findViewById(R.id.name1);
        txtCreditFee = findViewById(R.id.creditfee1);
        txtFee = findViewById(R.id.fee1);
        txtGroup = findViewById(R.id.group1);
        txtDate = findViewById(R.id.date1);
        txtLesson = findViewById(R.id.lesson1);
        txtRoom = findViewById(R.id.room1);
        txtWeek = findViewById(R.id.week1);
        txtCode1 = findViewById(R.id.code2);
        txtCredit1 = findViewById(R.id.credit2);
        txtName1 = findViewById(R.id.name2);
        txtCreditFee1 = findViewById(R.id.creditfee2);
        txtFee1 = findViewById(R.id.fee2);
        txtGroup1 = findViewById(R.id.group2);
        txtDate1 = findViewById(R.id.date2);
        txtLesson1 = findViewById(R.id.lesson2);
        txtRoom1 = findViewById(R.id.room2);
        txtWeek1 = findViewById(R.id.week2);
        txtCode2 = findViewById(R.id.code3);
        txtCredit2 = findViewById(R.id.credit3);
        txtName2 = findViewById(R.id.name3);
        txtCreditFee2 = findViewById(R.id.creditfee3);
        txtFee2 = findViewById(R.id.fee3);
        txtGroup2 = findViewById(R.id.group3);
        txtDate2 = findViewById(R.id.date3);
        txtLesson2 = findViewById(R.id.lesson3);
        txtRoom2 = findViewById(R.id.room3);
        txtWeek2 = findViewById(R.id.week3);
        txtCode3 = findViewById(R.id.code4);
        txtCredit3 = findViewById(R.id.credit4);
        txtName3 = findViewById(R.id.name4);
        txtCreditFee3 = findViewById(R.id.creditfee4);
        txtFee3 = findViewById(R.id.fee4);
        txtGroup3 = findViewById(R.id.group4);
        txtDate3 = findViewById(R.id.date4);
        txtLesson3 = findViewById(R.id.lesson4);
        txtRoom3 = findViewById(R.id.room4);
        txtWeek3 = findViewById(R.id.week4);
    }

}
