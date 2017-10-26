package com.flora.florasharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etPassWord;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText)findViewById(R.id.username_field);
        etPassWord = (EditText)findViewById(R.id.password_field);
        btnSave = (Button)findViewById(R.id.saveInfo_button);
        btnDisplay = (Button)findViewById(R.id.displayInfo_button);
        tvDisplay = (TextView)findViewById(R.id.tv_display);

        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",etUserName.getText().toString());
        editor.putString("pwd", etPassWord.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view){
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd","");

        tvDisplay.setText("User is " + user + " and the password is " + password);
    }

}
