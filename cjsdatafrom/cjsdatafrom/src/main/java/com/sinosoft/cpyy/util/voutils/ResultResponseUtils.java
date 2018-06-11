package com.sinosoft.cpyy.util.voutils;

import com.sinosoft.cpyy.model.constant.ExceptionEnum;

/**
 * 创建时间：2018/四月/20
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：ResultResponseUtils
 * 描述：前端返回vo的统一工具处理
 */
public class ResultResponseUtils {

    private static ResponseResult<Object> success(ExceptionEnum code, Object data) {
        return new ResponseResult<>(code.getCode(), code.getMessage(), data);

    }


    /**
     * Date 2017/6/1
     * Author 邱健[qiujian12150@sinosoft.com.cn]
     * <p>
     * 方法说明:仅仅为操作成功，无须任何自定义信息时,默认返回ResponseEnum.CODE_0
     *
     * @return ResultResponse返回状态为ResponseEnum.CODE_0
     */
    public static ResponseResult<Object> success() {
        return success(ExceptionEnum.INVOKING_SUCCESS, null);
    }

    /**
     * Date 2017/6/1
     * Author 邱健[qiujian12150@sinosoft.com.cn]
     * <p>
     * 方法说明:仅仅为操作成功，并返回数据，默认返回ResponseEnum.CODE_0
     *
     * @param data 需要返回的数据data
     * @return ResultResponse返回状态为ResponseEnum.CODE_0数据为传入的data
     */
    public static ResponseResult<Object> success(Object data) {
        return success(ExceptionEnum.INVOKING_SUCCESS, data);
    }

    /**
     * Date 2017/4/30
     * Author 邱健[qiujian12150@sinosoft.com.cn]
     * <p>
     * 方法说明:错误的时候传递的给前端的信息
     *
     * @param code         ResponseEnum的枚举状态码
     * @param errorMessage 如果为空则自动获取ResponseEnum中的信息
     * @return ResultResponse<Object>传递给前端的信息
     */
    public static ResponseResult<Object> error(ExceptionEnum code, String errorMessage) {
        return new ResponseResult<>(code.getCode(), code.getMessage(), null);
    }

    /**
     * Date 2017/4/30
     * Author 邱健[qiujian12150@sinosoft.com.cn]
     * <p>
     * 方法说明:错误的时候传递的给前端的信息
     *
     * @param code ResponseEnum的枚举状态码
     * @return ResultResponse<Object>传递给前端的信息，返回的消息自动从ResponseEnum获取，返回对象为null
     */
    public static ResponseResult<Object> error(ExceptionEnum code) {
        return code == null ? error(ExceptionEnum.SYSTEM_FAILURE, null) : error(code, null);
    }

    private ResultResponseUtils() {
    }

}
