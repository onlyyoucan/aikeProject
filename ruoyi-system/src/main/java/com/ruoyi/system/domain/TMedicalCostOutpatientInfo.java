package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门诊卡信息对象 t_medical_cost_outpatient_info
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public class TMedicalCostOutpatientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 门诊卡信息编号 */
    private Long id;

    /** 金额 */
    @Excel(name = "金额")
    private Long money;

    /** 启用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "启用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enabletime;

    /** 挂失日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂失日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date losstime;

    /** 卡作废日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "卡作废日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadtime;

    /** 退卡日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退卡日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date returntime;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 押金 */
    @Excel(name = "押金")
    private Long deposit;

    /** 个人档案编号 */
    @Excel(name = "个人档案编号")
    private String personid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMoney(Long money) 
    {
        this.money = money;
    }

    public Long getMoney() 
    {
        return money;
    }
    public void setEnabletime(Date enabletime) 
    {
        this.enabletime = enabletime;
    }

    public Date getEnabletime() 
    {
        return enabletime;
    }
    public void setLosstime(Date losstime) 
    {
        this.losstime = losstime;
    }

    public Date getLosstime() 
    {
        return losstime;
    }
    public void setDeadtime(Date deadtime) 
    {
        this.deadtime = deadtime;
    }

    public Date getDeadtime() 
    {
        return deadtime;
    }
    public void setReturntime(Date returntime) 
    {
        this.returntime = returntime;
    }

    public Date getReturntime() 
    {
        return returntime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDeposit(Long deposit) 
    {
        this.deposit = deposit;
    }

    public Long getDeposit() 
    {
        return deposit;
    }
    public void setPersonid(String personid) 
    {
        this.personid = personid;
    }

    public String getPersonid() 
    {
        return personid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("money", getMoney())
            .append("enabletime", getEnabletime())
            .append("losstime", getLosstime())
            .append("deadtime", getDeadtime())
            .append("returntime", getReturntime())
            .append("status", getStatus())
            .append("deposit", getDeposit())
            .append("personid", getPersonid())
            .toString();
    }
}
