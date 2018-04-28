package com.jztey.omronhealth.entity;

import java.io.Serializable;

/**
 * 封装消息的实体
 * 
 * @author yushi 2017-11-11
 */
public class MessageVo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6788943332381403485L;
    // 消息内容
    public String             message;
    // 消息得到时间
    public String             dateReceive;
    // 消息发送时间
    public String             dateSend;
    // 消息的队列名称
    public String             queue;
    // 状态
    public int                state;
    // 会员号
    public String             openId;
    // 设备号
    public String             deviceDigitalId;

    public String             updateAt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(String dateReceive) {
        this.dateReceive = dateReceive;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDeviceDigitalId() {
        return deviceDigitalId;
    }

    public void setDeviceDigitalId(String deviceDigitalId) {
        this.deviceDigitalId = deviceDigitalId;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "MessageVo [message=" + message + ", dateReceive=" + dateReceive + ", dateSend=" + dateSend + ", queue="
               + queue + ", state=" + state + ", openId=" + openId + ", deviceDigitalId=" + deviceDigitalId
               + ", updateAt=" + updateAt + "]";
    }

}
