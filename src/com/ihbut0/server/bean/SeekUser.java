package com.ihbut0.server.bean;


import com.ihbut0.server.dao.UserDAO;

public class SeekUser extends User {

    private float index;

    public SeekUser(String account, float index){
        User user = UserDAO.getUser(account);
        super.setAccount(user.getAccount());
        super.setHeadImg(user.getHeadImg());
        super.setNickname(user.getNickname());
        this.index = index;
    }

    public float getIndex() {
        return index;
    }

    public void setIndex(float index) {
        this.index = index;
    }
}
