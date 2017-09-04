package me.stonerivers.model.vo;

import java.util.HashMap;

/**
 * Created by zhang on 16/7/27.
 */
public class SuccessVo extends ResponseVo {

    public SuccessVo(Object data) {
        this.data = data;
        this.rescode = 0;
    }

    public static final SuccessVo BLANK_SUCCESS_VO = new SuccessVo(new Object());

    public static SuccessVo keyValueVo(String key, Object value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return new SuccessVo(map);
    }
}
