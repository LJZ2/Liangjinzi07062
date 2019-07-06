package movie.bw.com.liangjinzi0706.entity;

/**
 * @Author：梁金子
 * @Date：2019/7/6
 * @Description：描述信息
 */
public class Result<T> {
    public String message;
    public String status;
    public T result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
