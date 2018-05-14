package banana.mybk.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import banana.mybk.R;

public class LoginActivity extends AppCompatActivity {
    EditText etId, etPw;
    Button btnReset, btnLogin;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etId = findViewById(R.id.input_id);
        etPw = findViewById(R.id.input_password);
        btnReset = findViewById(R.id.btn_reset);
        btnLogin = findViewById(R.id.btn_login);
        cbRemember = findViewById(R.id.cb_remember);
    }

}
