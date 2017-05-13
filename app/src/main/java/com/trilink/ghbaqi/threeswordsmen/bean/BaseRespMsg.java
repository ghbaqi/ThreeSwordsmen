
package com.trilink.ghbaqi.threeswordsmen.bean;

import java.io.Serializable;


public class BaseRespMsg implements Serializable {
    @Override
    public String toString() {
        return "BaseRespMsg{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public final static int    STATUS_SUCCESS =1;
    public final static int    STATUS_ERROR   =0;
    public final static String MSG_SUCCESS    ="success";

    protected  int status=STATUS_SUCCESS;
    protected String message;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
