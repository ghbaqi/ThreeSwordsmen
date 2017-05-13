
package com.trilink.ghbaqi.threeswordsmen.bean;


public class LoginRespMsg extends BaseRespMsg {
    @Override
    public String toString() {
        return "LoginRespMsg{" +
                "token='" + token + '\'' +
                ", data=" + data +
                '}';
    }

    private String token;

    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
