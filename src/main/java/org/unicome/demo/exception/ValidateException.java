package org.unicome.demo.exception;

public class ValidateException extends Exception{

	public static final String SUCCESS_CODE = "1";
	public static final String FAIL_CODE = "0";
	public static final String ERROR_CODE = "-1";

    private static final long serialVersionUID = -2628004240502111575L;
    private String errCode;
    private String errMsg;
    private Object errBody;
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public Object getErrBody() {
        return errBody;
    }
    public void setErrBody(Object errBody) {
        this.errBody = errBody;
    }
    public ValidateException() {

    }

    public ValidateException(Object errBody) {
        this.errBody = errBody;
    }

    public ValidateException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ValidateException(String errCode, String errMsg, Object errBody) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errBody = errBody;
    }
}
