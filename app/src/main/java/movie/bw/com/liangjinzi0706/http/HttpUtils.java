package movie.bw.com.liangjinzi0706.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author：梁金子
 * @Date：2019/7/6
 * @Description：描述信息
 */
public class HttpUtils {

    private final Retrofit retrofit;
    public static HttpUtils instance;
    public static HttpUtils getInstance(){
        if (instance==null){
            instance=new HttpUtils();
        }
        return instance;
    }
    private HttpUtils(){
        OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://172.17.8.100/small/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
