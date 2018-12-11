package cn.edu.hebtu.software.taobao.Bean;

import java.io.Serializable;

public class User implements Serializable{
    private int portraitId;
    private String userName;

    public User(int portraitId, String userName) {
        this.portraitId = portraitId;
        this.userName = userName;
    }

    public int getPortraitId() {
        return portraitId;
    }

    public void setPortraitId(int portraitId) {
        this.portraitId = portraitId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
