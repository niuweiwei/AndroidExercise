package cn.edu.hebtu.software.taobao.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.Bean.User;
import cn.edu.hebtu.software.taobao.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        Button login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userName=findViewById(R.id.userName);
                final String name=userName.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("userName",name);
                setResult(200,intent);
                finish();
            }
        });
    }
}
