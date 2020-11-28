package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private EditText editText_register_ID;
    private EditText editText_register_password1;
    private EditText editText_register_password2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Button buttonregister=(Button)findViewById(R.id.button_register);
        Button buttonreturn=(Button)findViewById(R.id.button_return);
        editText_register_ID=(EditText)findViewById(R.id.edittext_register_ID);
        editText_register_password1=(EditText)findViewById(R.id.edittext_register_password1);
        editText_register_password2=(EditText)findViewById(R.id.edittext_register_password2);
        buttonregister.setOnClickListener(v -> {
            sp=getSharedPreferences("database",MODE_PRIVATE);
            String registerID=editText_register_ID.getText().toString();
            String registerpassword1=editText_register_password1.getText().toString();
            String registerpassword2=editText_register_password2.getText().toString();
            if(!registerpassword1.equals(registerpassword2)){
                Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            }
            else if(registerID.isEmpty() || registerpassword1.isEmpty()){
                Toast.makeText(RegisterActivity.this,"密码或账号不能为空",Toast.LENGTH_SHORT).show();
            }
            else {
                SharedPreferences.Editor editor=sp.edit();
                editor.putString(registerID,registerpassword1);
                editor.apply();
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        buttonreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}