package com.ihbut0.server.bean;


import com.ihbut0.server.dao.UserDAO;


public class Friend extends User{

    private String label;
    private float index;
    private String addTime;

    public Friend(){}

    public Friend(String friendAccount, String label, float index){
        User user = UserDAO.getUser(friendAccount);
        super.setAccount(user.getAccount());
        super.setNickname(user.getNickname());
        super.setAddress(user.getAddress());
        super.setBirthday(user.getBirthday());
        super.setEducation(user.getEducation());
        super.setHeadImg(user.getHeadImg());
        super.setSex(user.getSex());
        super.setSign(user.getSign());

        this.label = label;
        this.index = index;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getIndex() {
        return index;
    }

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public void setIndex(float index) {
		this.index = index;
	}
    
}
