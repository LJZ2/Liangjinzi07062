package movie.bw.com.liangjinzi0706.persenter;

import java.util.HashMap;

import io.reactivex.Observable;
import movie.bw.com.liangjinzi0706.core.DataCall;
import movie.bw.com.liangjinzi0706.model.IRquest;

/**
 * @Author：梁金子
 * @Date：2019/7/6
 * @Description：描述信息
 */
public class LoginPersenter extends BasePersenter {
    public LoginPersenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable LoginModel(IRquest iRquest, Object... args) {
        return iRquest.login((HashMap<String,String>)args[0]);
    }
}
