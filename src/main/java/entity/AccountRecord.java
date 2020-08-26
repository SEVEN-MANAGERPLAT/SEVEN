package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AccountRecord)实体类
 *
 * @author makejava
 * @since 2020-06-29 17:25:07
 */
public class AccountRecord implements Serializable {
    private static final long serialVersionUID = -25953569878633713L;
    
    private Integer accrId;
    
    private String memNum;
    
    private String phone;
    
    private String appNum;
    
    private Double momey;
    
    private Date createDate;
    
    private String remark;
    
    private Integer empId;
    /**
    * 1.充值
        2.消费
        3.退款
    */
    private Integer costType;
    /**
    * 0：非初办
        1：初办
    */
    private Integer isfirst;
    
    private Double balance;
    /**
    * 0：充值
        1：耗卡70%
        2：完结
    */
    private Integer state;
    
    private Integer storeId;
    /**
    * 1:是
        0:否
    */
    private Integer transferCard;
    /**
    * 0:充值
        1:耗卡70%
        2:完成
        
    */
    private Integer royProcess;
    /**
    * 0：初访
        1：在访
    */
    private Integer visitType;
    
    private Integer clerkId;
    
    private Integer operatorId;
    /**
    * 1:实体卡首充（不计算提成）
        0:计算
    */
    private Integer firstCharge;


    public Integer getAccrId() {
        return accrId;
    }

    public void setAccrId(Integer accrId) {
        this.accrId = accrId;
    }

    public String getMemNum() {
        return memNum;
    }

    public void setMemNum(String memNum) {
        this.memNum = memNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public Double getMomey() {
        return momey;
    }

    public void setMomey(Double momey) {
        this.momey = momey;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(Integer isfirst) {
        this.isfirst = isfirst;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getTransferCard() {
        return transferCard;
    }

    public void setTransferCard(Integer transferCard) {
        this.transferCard = transferCard;
    }

    public Integer getRoyProcess() {
        return royProcess;
    }

    public void setRoyProcess(Integer royProcess) {
        this.royProcess = royProcess;
    }

    public Integer getVisitType() {
        return visitType;
    }

    public void setVisitType(Integer visitType) {
        this.visitType = visitType;
    }

    public Integer getClerkId() {
        return clerkId;
    }

    public void setClerkId(Integer clerkId) {
        this.clerkId = clerkId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getFirstCharge() {
        return firstCharge;
    }

    public void setFirstCharge(Integer firstCharge) {
        this.firstCharge = firstCharge;
    }

}