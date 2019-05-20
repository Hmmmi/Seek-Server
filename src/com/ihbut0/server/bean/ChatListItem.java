//package com.ihbut0.server.bean;
//
//
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ChatListItem extends Friend implements Comparable<ChatListItem>{
//
//    private boolean isLastSend;//true表示本地用户最后发送
//    private String lastMsgCtx;
//    private String lastTime;
//
////    public ChatListItem(){}
//
//    public ChatListItem(String chatAccount){
//        Friend friend = AllInformation.getFriend(chatAccount);
//        super.setAccount(chatAccount);
//        super.setHeadImg(friend.getHeadImg());
//        super.setLabel(friend.getLabel());
//    }
//
//    public String getChatAccount() {
//        return super.getAccount();
//    }
//
//    public int getChatHeadImg() {
//        return super.getHeadImg();
//    }
//
//    public String getChatLabel() {
//        return super.getLabel();
//    }
//
//    public boolean isLastSend() {
//        return isLastSend;
//    }
//
//    public void setLastSend(boolean lastSend) {
//        isLastSend = lastSend;
//    }
//
//    public String getLastMsg() {
//        return lastMsgCtx;
//    }
//
//    public void setLastMsg(String lastMsg) {
//        this.lastMsgCtx = lastMsg;
//    }
//
//    public String getLastTime() {
//        return lastTime;
//    }
//
//    public void setLastTime(String lastTime) {
//        this.lastTime = lastTime;
//    }
//
//    @Override
//    public int compareTo(@NonNull ChatListItem o) {
//        int res = Util.compareTime(lastTime, o.getLastTime());
//        return -res;
//    }
//
//    @Override
//    public String toString() {
//        return "哈哈 item:("+getChatLabel()+") "+lastMsgCtx+" "+lastTime;
//    }
//}
