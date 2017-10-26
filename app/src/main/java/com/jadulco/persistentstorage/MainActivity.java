package com.jadulco.persistentstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_save, bt_display;
    TextView tv_display;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_save = (Button) findViewById(R.id.bt_save);
        tv_display = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",et_username.getText().toString());
        editor.putString("pwd",et_password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void loadInfo (View view){
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd", "");
        tv_display.setText("User is " + user +" and the password is " + password);
    }
}
