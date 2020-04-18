package com.jiu.sys.utils;

import com.jiu.sys.constant.SysConstant;

public class ResultObj {

    private Integer code=0;
    private String msg;

    /**
     * 添加成功
     */
    public static final ResultObj ADD_SUCCESS=new ResultObj(SysConstant.CODE_SUCCESS,SysConstant.ADD_SUCCESS);

    /**
     * 添加失败
     */
    public static final ResultObj ADD_FAILED=new ResultObj(SysConstant.CODE_FAILED, SysConstant.ADD_FAILED);
    /**
     * 更新成功
     */
    public static final ResultObj UPDATE_SUCCESS=new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.UPDATE_SUCCESS);
    /**
     * 更新失败
     */
    public static final ResultObj UPDATE_FAILED=new ResultObj(SysConstant.CODE_FAILED, SysConstant.UPDATE_FAILED);
    /**
     * 删除成功
     */
    public static final ResultObj DELETE_SUCCESS=new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.DELETE_SUCCESS);
    /**
     * 删除失败
     */
    public static final ResultObj DELETE_FAILED=new ResultObj(SysConstant.CODE_FAILED, SysConstant.DELETE_FAILED);

    /**
     * 重置成功
     */
    public static final ResultObj RESET_SUCCESS=new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.RESET_SUCCESS);
    /**
     * 重置失败
     */
    public static final ResultObj RESET_FAILED=new ResultObj(SysConstant.CODE_FAILED, SysConstant.RESET_FAILED);
    /**
     * 分配成功
     */
    public static final ResultObj DISPATCH_SUCCESS=new ResultObj(SysConstant.CODE_SUCCESS, SysConstant.DISPATCH_SUCCESS);
    /**
     * 分配失败
     */
    public static final ResultObj DISPATCH_FAILED=new ResultObj(SysConstant.CODE_FAILED, SysConstant.DISPATCH_FAILED);

    public static final ResultObj STATUS_TRUE=new ResultObj(SysConstant.CODE_SUCCESS);

    public static final ResultObj STATUS_FALSE=new ResultObj(SysConstant.CODE_FAILED);

    private ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private ResultObj(Integer code) {
        this.code = code;

    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

