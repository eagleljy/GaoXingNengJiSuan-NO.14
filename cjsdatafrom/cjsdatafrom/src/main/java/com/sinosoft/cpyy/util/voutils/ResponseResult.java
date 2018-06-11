package com.sinosoft.cpyy.util.voutils;


import com.sinosoft.cpyy.model.constant.ResponseConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创建时间：2018/四月/17
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：ResponseResult
 * 描述：webservice返回客户端对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -8688072985562369039L;
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功结果
     *
     * @return 不带返回参数的成功
     */
    public <T> ResponseResult<T> success() {
        return new ResponseResult<>(new ResponseConstant().getSuccess(), null, null);
    }

    /**
     * 成功结果
     *
     * @param t 结果对象
     * @return 带成功对象
     */
    public <T> ResponseResult<T> success(T t) {
        return new ResponseResult<>(new ResponseConstant().getSuccess(), null, t);
    }


    /**
     * 失败结果
     *
     * @param msg 错误信息
     * @return 带错误信息
     */
    public <T> ResponseResult<T> fail(String msg) {
        return new ResponseResult<>(new ResponseConstant().getFail(), msg, null);
    }

    /**
     * 失败结果
     *
     * @param code 错误代码
     * @param msg  错误消息
     * @return 带错误码、错误信息
     */
    public <T> ResponseResult<T> fail(String code, String msg) {
        return new ResponseResult<>(code, msg, null);
    }

    /**
     * 创建失败结果
     *
     * @param code 错误代码
     * @param msg  错误消息
     * @param obj  结果对象
     * @return 带错误信息、错误对象、错误状态码
     */
    public <T> ResponseResult<T> fail(String code, String msg, T obj) {
        return new ResponseResult<>(code, msg, obj);
    }


}
