package movie.bw.com.liangjinzi0706;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import movie.bw.com.liangjinzi0706.core.DataCall;
import movie.bw.com.liangjinzi0706.entity.Result;
import movie.bw.com.liangjinzi0706.persenter.RegPersenter;

public class RegActivity extends AppCompatActivity implements DataCall {

    private EditText phone;
    private EditText pwd;
    private EditText mode;
    private RegPersenter regPersenter;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        phone = findViewById(R.id.edit_register_phone);
        pwd = findViewById(R.id.edit_register_pwd);
        register = findViewById(R.id.btn_register);
        regPersenter = new RegPersenter(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phones = phone.getText().toString();
                String pwds = pwd.getText().toString();
                if (TextUtils.isEmpty(phones)) {
                    Toast.makeText(RegActivity.this, "输入内容不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pwds)) {
                    Toast.makeText(RegActivity.this, "输入内容不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                HashMap<String,String> hashMap = new HashMap();
                hashMap.put("phone",phones);
                hashMap.put("pwd",pwds);
                regPersenter.request(hashMap);
            }
        });
    }

    @Override
    public void success(Object data) {
        Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void fail(Result data) {

    }

}
