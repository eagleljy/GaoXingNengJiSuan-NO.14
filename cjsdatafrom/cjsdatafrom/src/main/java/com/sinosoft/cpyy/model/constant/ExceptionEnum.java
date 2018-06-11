package com.sinosoft.cpyy.model.constant;


/**
 * @author nicai
 */
public enum ExceptionEnum {

    //------------------------------系统类-------------------------------
    INVOKING_ERROR("CPYY-00000", "调用失败"),
    INVOKING_SUCCESS("CPYY-00001", "调用成功"),
    SYSTEM_FAILURE("CPYY-00002", "系统异常"),
    JSON_FAILURE("CPYY-00003", "Json序列化对象错误"),
    METHOD_NOT_ALLOWED("CPYY-00004", "POST/GET请求方式错误"),
    JSON_DATA_ERROR("CPYY-00005", "JSON数据格式错误"),
    UNSUPPORTED_MEDIA_TYPE("CPYY-00006", "请求数据类型不正确"),
    SERVICE_NOT_FOUND_ERROR("CPYY-00008", "不存在此接口"),


    //------------------------------上传文件-------------------------------
    UPLOAD_PARAM_MAP_IS_NULL("CPYY-00009", "请求参数全部为空"),
    UPLOAD_PARAM_FILE_UPLOADER_ENUM_IS_NULL("CPYY-0001O", "模块名为空"),
    UPLOAD_PARAM_FILE_UPLOADER_ENUM_IS_INVALID("CPYY-00010", "模块名未识别"),
    UPLOAD_PARAM_FILE_INPUT_STREAM_IS_NULL("CPYY-00011", "上传文件流为空"),
    UPLOAD_PARAM_FILE_INPUT_STREAM_TOO_MUCH("CPYY-00011", "上传的文件过多"),
    UPLOAD_PARAM_FILE_NAME_IS_NULL("CPYY-00012", "文件名为空"),

    //------------------------------下载文件-------------------------------
    DOWNLOAD_UNIQUENO_PARMA_IS_NULL("CPYY-00013", "文件名为空"),
    DOWNLOAD_FILE_IS_NOT_EXIST("CPYY-00013", "文件不存在"),

    //------------------------------下载文件-------------------------------
    PREVIEW_FILE_IS_NOT_EXIST("CPYY-04001", "需要预览的文件不存在"),
    PREVIEW_PATH_CREATE_EXCEPTION("CPYY-04002", "预览创建文件异常"),
    PREVIEW_COPY_FILE_EXCEPTION("CPYY-04003", "预览文件拷贝异常"),
    PREVIEW_SUB_TEMP_PATH_EXCEPTION("CPYY-04004", "获取临时文件相对路径异常"),

    //------------------------------临时文件下载-------------------------------
    TEMP_DOWNLOAD_FILE_IS_NOT_EXIST("CPYY-05001", "需要下载的临时文件不存在"),
    TEMP_DOWNLOAD_SUB_TEMP_PATH_EXCEPTION("CPYY-05002", "获取临时文件相对路径异常"),
    TEMP_DOWNLOAD_ZIP_EXCEPTION("CPYY-05003", "临时文件压缩异常"),
    TEMP_DOWNLOAD_CREATE_EXCEPTION("CPYY-05004", "临时文件拷贝异常"),

    //------------------------------批量下载永久文件-------------------------------
    BATCH_DOWNLOAD_UNIQUENO_PARMA_IS_NULL("CPYY-06001", "需要下载的文件唯一号为空"),
    BATCH_DOWNLOAD_CREATE_SPACE("CPYY-06002", "生成下载空间目录异常"),
    BATCH_DOWNLOAD_ZIP_FAIL("CPYY-06003", "批量下载完全失败"),

    //------------------------------视频文件上传-------------------------------
    VIDEO_UPLOAD_ERROR("CPYY-07001", "视频文件上传失败"),
    VIDEO_UNIQUE_PARAM_IS_NULL("CPYY-07002", "视频文件唯一号不存在"),
    VIDEO_IS_INVAILD("CPYY-07003", "视频文件不存在"),

    //------------------------------视频文件上传-------------------------------
    VIDEO_CAPTURE_VIDEO_INDEX_INVALID("CPYY-08001", "视频文件索引信息不存在"),
    VIDEO_CAPTURE_VIDEO_INVALID("CPYY-08002", "视频文不存在"),
    VIDEO_CAPTURE_IMAGE_ERROR("CPYY-08002", "生成帧失败"),
    VIDEO_UPLOAD_ONLY_ONE("CPYY-08003", "只能上传一个视频文件");

    /**
     * ===============================================================================
     *
     * @return MESSAGE
     */
    public String getMessage() {
        if (message == null) {
            return "";
        }
        return message;
    }

    public String getCode() {
        return code;
    }

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
