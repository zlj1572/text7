package com.example.administrator.text7;

import android.content.DialogInterface;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button)this.findViewById(R.id.login);
        Button bn2 = (Button)this.findViewById(R.id.tips);

        bn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String tip = "点击登录，输入用户名和密码";
                builder.setMessage(tip).setTitle("提示");
                builder.show();
            }
        });


        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.login_dialog, null);  //同时声明两个布局

                builder.setView(view).setTitle("Login");

                builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et1 = (EditText)view.findViewById(R.id.editTextUserId);
                        EditText et2 = (EditText)view.findViewById(R.id.editTextPwd);
                        String str1 = et1.getText().toString();
                        String str2 = et2.getText().toString();
                        if(str1.equals("abc")&&str2.equals("123")){
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNeutralButton("取消", null);
                builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
            }
        });
    }
}