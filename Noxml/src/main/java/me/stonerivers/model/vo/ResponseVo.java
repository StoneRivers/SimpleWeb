package me.stonerivers.model.vo;

/**
 * Created by zhang on 16/7/27.
 */
public class ResponseVo {

    protected Object data;
    protected int rescode;

    public ResponseVo() {
    }

    public ResponseVo(int rescode, Object data) {
        this.rescode = rescode;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getRescode() {
        return rescode;
    }

    public void setRescode(int rescode) {
        this.rescode = rescode;
    }
}
