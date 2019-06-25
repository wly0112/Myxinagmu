package com.itheima.domian;

import com.itheima.until.datauntil;


import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
public class orders {

    private String id;// 主键
    private String orderNum;//订单编号 不为空 唯一
    private Date orderTime;   //下单时间
    private String orderTimeStr;
    private int orderStatus;   //订单状态(0 未支付 1 已支付)
    private String  orderStatusstr;
    private int peopleCount;   //出行人数
    private product product;   // 产品
    private List<traveller> travellers;  //旅客信息
    private member  member;  // 会员信息
    private Integer payType;  //支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private String orderDesc; //订单描述(其它信息)

    public String getOrderStatusstr() {
        if (orderStatus==0){
            orderStatusstr = "未支付";
        }else if (orderStatus==1){
            orderStatusstr = "已支付";
        }
        return orderStatusstr;
    }

    public void setOrderStatusstr(String orderStatusstr) {
        this.orderStatusstr = orderStatusstr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
             orderTimeStr = datauntil.date(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public com.itheima.domian.product getProduct() {
        return product;
    }

    public void setProduct(com.itheima.domian.product product) {
        this.product = product;
    }

    public List<traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<traveller> travellers) {
        this.travellers = travellers;
    }

    public com.itheima.domian.member getMember() {
        return member;
    }

    public void setMember(com.itheima.domian.member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType==0){
            payTypeStr="支付宝";
        }else if (payType==1){
            payTypeStr="微信";

        }else if (payType==2){
            payTypeStr="其他支付方式";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
