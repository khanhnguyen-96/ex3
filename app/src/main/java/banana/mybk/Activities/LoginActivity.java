package banana.mybk.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import banana.mybk.Const;
import banana.mybk.Helpers.SharePreferenceHelper;
import banana.mybk.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    SharePreferenceHelper sharePreferenceHelper;
    EditText etId, etPw;
    Button btnReset, btnLogin;
    CheckBox cbRemember;
    boolean rememberPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharePreferenceHelper = new SharePreferenceHelper(this);
        rememberPassword = sharePreferenceHelper.getBoolean(Const.Key.REMEMBER_PASSWORD);
        cbRemember = findViewById(R.id.cb_remember);
        cbRemember.setChecked(rememberPassword);

        String oldId = sharePreferenceHelper.getString(Const.Key.SAVED_USER);


        etId = findViewById(R.id.input_id);
        etId.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    etPw.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    return true;
                }
                return false;
            }
        });

        etPw = findViewById(R.id.input_password);
        etPw.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    btnLoginClicked();
                    return true;
                }
                return false;
            }
        });

        btnReset = findViewById(R.id.btn_reset);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        //Start MainActivity with saved ID
        if (!oldId.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(Const.Key.SAVED_USER, oldId);
            getApplicationContext().startActivity(intent);
            this.finish();
        }
    }

    private void resetBtnClicked(){
        etPw.setText("");
        etId.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                btnLoginClicked();
                break;
            case R.id.btn_reset:
                resetBtnClicked();
                break;
        }
    }

    private void btnLoginClicked() {
        if (validateSuccess()) {
            rememberPassword = cbRemember.isChecked();
            String id = etId.getText().toString();
            sharePreferenceHelper.saveBoolean(Const.Key.REMEMBER_PASSWORD, rememberPassword);
            if (rememberPassword)
                sharePreferenceHelper.saveString(Const.Key.SAVED_USER, id);
            else
                sharePreferenceHelper.saveString(Const.Key.SAVED_USER, "");

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(Const.Key.SAVED_USER, id);
            LoginActivity.this.startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(getApplicationContext(), "User ID or password is incorrect", Toast.LENGTH_SHORT).show();
            resetBtnClicked();
        }
    }

    private boolean validateSuccess() {
        return (etId.getText().toString().equals(Const.USER_ID)) && (etPw.getText().toString().equals(Const.PASSWORD));
    }
}
