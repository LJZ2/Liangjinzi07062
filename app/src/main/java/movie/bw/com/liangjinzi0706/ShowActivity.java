package movie.bw.com.liangjinzi0706;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    protected static final int BENDI=0;
    protected static final int PAIZHAO=1;
    protected static final int CAIJIAN=2;
    protected static Uri tremuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDiaLog();
            }
        });
    }
//13274559090
    //    弹框
    private void PhoneDiaLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] item={"本地","拍照"};
        builder.setNegativeButton("取消",null);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case BENDI:
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,BENDI);
                        break;
                    case PAIZHAO:

                        break;

                }
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            switch (requestCode) {
                case PAIZHAO:
                    CutPhoto(tremuri);
                    break;
                case BENDI://本地图片
                    CutPhoto(data.getData());
                    break;
                case CAIJIAN://裁剪后的图片 显示
                    if (data!=null){
                        setPhotoCai(data);
                    }
                    break;
            }
        }
    }
    private void CutPhoto(Uri uri) {
        if (uri==null){
            Log.i("tag", "The uri is not exist.");
        }
        tremuri=uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
//        设置裁剪
        intent.putExtra("crop","true");
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        intent.putExtra("outputX",150);
        intent.putExtra("outputY",150);
        intent.putExtra("return-data",true);
        startActivityForResult(intent,CAIJIAN);
    }
    private void setPhotoCai(Intent data) {
        Bundle extras = data.getExtras();
        if (extras!=null){
            Bitmap data1 = extras.getParcelable("data");
            img.setImageBitmap(data1);
        }
    }
}
