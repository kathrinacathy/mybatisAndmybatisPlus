package com.mybatisPlus.entity;

/**
 * Created by admin on 2019/7/25 17:13
 *
 * @Author: created by admin
 * @Date: created in 17:13 2019/7/25
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public enum EmpStatus {
    LOGIN("100","登录成功"),LOGOUT("200","登录失败"),REMOVE("300","退出登录");

    private String code;
    private String msg;

    EmpStatus() {
    }

    EmpStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static EmpStatus getEmpStatusByCode(String code) {
        switch (code) {
            case "100":
                return LOGIN;
            case "200":
                return LOGOUT;
            case "300":
                return REMOVE;
            default:
               return LOGOUT;
        }

    }
}
