package movie.bw.com.liangjinzi0706.persenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import movie.bw.com.liangjinzi0706.core.DataCall;
import movie.bw.com.liangjinzi0706.entity.Result;
import movie.bw.com.liangjinzi0706.http.HttpUtils;
import movie.bw.com.liangjinzi0706.model.IRquest;

/**
 * @Author：梁金子
 * @Date：2019/7/6
 * @Description：描述信息
 */
public abstract class BasePersenter {
    public DataCall dataCall;

    public BasePersenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    //登录,注册
    public void request(Object...args){
        IRquest iRquest = HttpUtils.getInstance().create(IRquest.class);
        LoginModel(iRquest,args)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result o) throws Exception {
                        if (o.status.equals("0000")){
                            dataCall.success(o.result);
                        }else {
                            dataCall.fail(o);
                        }
                    }
                });
    }
    protected abstract Observable LoginModel(IRquest iRquest, Object...args);
}
