package movie.bw.com.liangjinzi0706.model;

import java.util.HashMap;

import io.reactivex.Observable;
import movie.bw.com.liangjinzi0706.entity.LoginEntity;
import movie.bw.com.liangjinzi0706.entity.Result;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author：梁金子
 * @Date：2019/7/6
 * @Description：描述信息
 */
public interface IRquest {
    //登录
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<Result<LoginEntity>> login(@FieldMap HashMap<String,String> map);

    //注册
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<Result> register(@FieldMap HashMap<String,String> map);
}
