package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人档案对象 t_medical_cost_person_archives
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
public class TMedicalCostPersonArchives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 个人档案编号 */
    private String id;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private Long age;

    /** 患者身份证 */
    @Excel(name = "患者身份证")
    private String code;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String sex;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("code", getCode())
            .append("sex", getSex())
            .toString();
    }
}
