package com.tensorflow.lite.examples.classification.Users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tensorflow.lite.examples.classification.DataBase.FlowerHobby;
import com.tensorflow.lite.examples.classification.DataBase.MyDao;
import com.tensorflow.lite.examples.classification.DataBase.UserInfo;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUsername;
    private EditText etPasswordSet;
    private EditText etPasswordComfirm;
    private Button btnConfirm;
    String name=null;
    String password=null;
    String password_confirm=null;
    UserInfo users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        addFlower();
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPasswordSet = (EditText) findViewById(R.id.et_password_set);
        etPasswordComfirm = (EditText) findViewById(R.id.et_password_comfirm);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirm:
                if(isEmptyForText()){
                    if(isSamePassword()){
                        //将注册信息存入数据库
                        register();

                    }

                }
                break;
        }
    }
    public void register(){
        users = new UserInfo(name,password);
        users.save();
        //注册成功，返回登录页面
        startActivity(new Intent(this,LoginActivity.class));
    }
    //判断输入内容是否为空
    public boolean isEmptyForText(){
        name=etUsername.getText().toString().trim();
        password=etPasswordSet.getText().toString().trim();
        password_confirm=etPasswordComfirm.getText().toString().trim();
        if(name.isEmpty()||password.isEmpty()||password_confirm.isEmpty()){
            Toast.makeText(this,"输入内容为空",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    public boolean isSamePassword(){
        password=etPasswordSet.getText().toString().trim();
        password_confirm=etPasswordComfirm.getText().toString().trim();
        if(password.equals(password_confirm)){
            return true;
        }
        return false;
    }
    public void addFlower(){
        List<FlowerHobby> list =new ArrayList<>();
        list.add(new FlowerHobby("玫瑰","花期5～6月份","适合生长在潮湿、微酸、排水良好的花园壤土中，阳光充足，部分遮荫，但也适合一些贫瘠的土壤，包括沙地、粘土或砾石土壤"));
        list.add(new FlowerHobby("雏菊","适温22-28℃，生育适温20-25℃","雏菊在能够渡夏的寒冷地区可以进行分枝繁殖"));
        list.add(new FlowerHobby("蒲公英","花果期4～10月份","广泛生于中、低海拔地区的山坡草地、路边、田野、河滩"));
        list.add(new FlowerHobby("郁金香","花期4～5月份","郁金香属长日照花卉，喜向阳、避风，冬季温暖湿润，夏季凉爽干燥的气候。喜腐殖质丰富、疏松肥沃、排水良好的微酸陛沙质土壤。"));
        list.add(new FlowerHobby("栀子花","花期3-7月，果期5月至翌年2月","性喜温暖湿润气候，好阳光但又不能经受强烈阳光照射，适宜生长在疏松、肥沃、排水良好、轻粘性酸性土壤中，抗有害气体能力强，萌芽力强，耐修剪。是典型的酸性花卉"));
        list.add(new FlowerHobby("月季","花期4月-9月","月季花对气候、土壤要求虽不严格，但以疏松、肥沃、富含有机质、微酸性、排水良好的的壤土较为适宜。性喜温暖、日照充足、空气流通的环境"));
        LitePal.saveAll(list);

    }
}