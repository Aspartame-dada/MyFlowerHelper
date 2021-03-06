package com.tensorflow.lite.examples.classification.Users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tensorflow.lite.examples.classification.DataBase.MyDao;
import com.tensorflow.lite.examples.classification.DataBase.UserInfo;
import com.tensorflow.lite.examples.classification.MainActivity2;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.util.List;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnRegiste;
    private Button btnUp;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnRegiste = (Button) findViewById(R.id.btn_registe);
        btnUp = (Button) findViewById(R.id.btn_up);
        textView = (TextView) findViewById(R.id.textView);
        btnRegiste.setOnClickListener(this);
        btnUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MyDao myDao = new MyDao(this);

        switch (v.getId()){
            case R.id.btn_registe:
                //点击注册按钮，跳转进入注册页面
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.btn_up:
//                String myname,mypassword;
//                myname = etUsername.getText().toString().trim();
//                mypassword=etPassword.getText().toString().trim();
//                if(myDao.select_username(myname,mypassword)){
//                    startActivity(new Intent(this, MainActivity2.class));
//
//                }else {
//                    Toast.makeText(this,"密码输入错误，请重新输入",Toast.LENGTH_SHORT).show();
//                }
                if(checkEt()){
                    if(checkUsers(etUsername.getText().toString().trim(),etPassword.getText().toString().trim())){
                        startActivity(new Intent(this, MainActivity2.class));

                    }else {
                        Toast.makeText(this,"用户不存在，请注册后重新登录",Toast.LENGTH_LONG).show();

                    }
                }

                break;


        }
    }
    public boolean checkUsers(String username,String password){
        List<UserInfo> users = LitePal.findAll(UserInfo.class);
        boolean isCheck=false;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUser_name().equals(username)||users.get(i).getUser_password().equals(password)){
                isCheck = true;
            }
        }

        return isCheck;
    }
    public boolean checkEt(){
        if(etUsername.getText().toString().equals(null)&etPassword.getText().toString().equals(null)){
            Toast.makeText(this,"输入为空，请检查后再登录",Toast.LENGTH_LONG).show();
            return false;
        }else {
            return true;
        }
    }
}