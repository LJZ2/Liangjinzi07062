package movie.bw.com.liangjinzi0706;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import movie.bw.com.liangjinzi0706.core.DataCall;
import movie.bw.com.liangjinzi0706.entity.Result;
import movie.bw.com.liangjinzi0706.persenter.LoginPersenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DataCall {
    @BindView(R.id.edit_login_phone)
    EditText phone;
    @BindView(R.id.edit_login_pwd)
    EditText pwd;
    @BindView(R.id.btn_login)
    Button login;
    @BindView(R.id.text_register)
    TextView reg;
    private LoginPersenter loginPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
        loginPersenter = new LoginPersenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login://登录
                String phones = phone.getText().toString();
                String pwds = pwd.getText().toString();
                if (TextUtils.isEmpty(phones)) {
                    Toast.makeText(MainActivity.this, "输入内容不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pwds)) {
                    Toast.makeText(MainActivity.this, "输入内容不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                HashMap<String,String> hashMap = new HashMap();
                hashMap.put("phone",phones);
                hashMap.put("pwd",pwds);
                loginPersenter.request(hashMap);
                break;
            case R.id.text_register://注册
                startActivity(new Intent(MainActivity.this,RegActivity.class));
                break;
        }
    }
    //18904551234
    @Override
    public void success(Object data) {
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void fail(Result data) {

    }
}
