package com.lykos.httpclient.login;

/**
 * Created by liujun on 16/11/18.
 */
public class LoginParam {
    private String userName;
    private String userPwd;
    private String code;
    private String paramName = "name";
    private String paramPwd = "pwd";
    private String paramCode = "code";
    private String loginUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamPwd() {
        return paramPwd;
    }

    public void setParamPwd(String paramPwd) {
        this.paramPwd = paramPwd;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }


    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
