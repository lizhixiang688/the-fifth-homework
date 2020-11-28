package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private EditText editText_login_ID;
    private EditText editText_login_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonregister=(Button)findViewById(R.id.button_for_register);
        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent1);
            }
        });

        Button buttonweibo=(Button)findViewById(R.id.button_weibo);
        buttonweibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你想用微博登录",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://weibo.com"));
                startActivity(intent);
            }
        });

        Button buttonshouji=(Button)findViewById(R.id.button_shouji);
        buttonshouji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你想用手机号登录",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Use_number_login.class);
                startActivity(intent);
            }
        });

        editText_login_ID=(EditText)findViewById(R.id.edittext_login_ID);
        editText_login_password=(EditText)findViewById(R.id.edittext_login_password);
        Button buttonlogin=(Button)findViewById(R.id.button_login);
        CheckBox checkBox=(CheckBox)findViewById(R.id.checkbox_1);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID=editText_login_ID.getText().toString();
                String password=editText_login_password.getText().toString();
                sp = getSharedPreferences("database",MODE_PRIVATE);
                String Password=sp.getString(ID,"0");
                if(checkBox.isChecked()) {
                    if (password.equals(Password)) {
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, Activity.class);
                        startActivity(intent2);
                    } else if (ID.isEmpty()||password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "密码或账号不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "密码或账号错误", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"请同意用户协议",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}