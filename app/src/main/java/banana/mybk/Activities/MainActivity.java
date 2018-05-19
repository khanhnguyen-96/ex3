package banana.mybk.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import banana.mybk.Const;
import banana.mybk.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imgSchedule;
    ImageView imgExam;

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
}
