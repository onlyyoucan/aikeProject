package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;

/**
 * 门诊卡信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface TMedicalCostOutpatientInfoMapper 
{
    /**
     * 查询门诊卡信息
     * 
     * @param id 门诊卡信息主键
     * @return 门诊卡信息
     */
    public TMedicalCostOutpatientInfo selectTMedicalCostOutpatientInfoById(Long id);

    /**
     * 查询门诊卡信息列表
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 门诊卡信息集合
     */
    public List<TMedicalCostOutpatientInfo> selectTMedicalCostOutpatientInfoList(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo);

    /**
     * 新增门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    public int insertTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo);

    /**
     * 修改门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    public int updateTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo);

    /**
     * 删除门诊卡信息
     * 
     * @param id 门诊卡信息主键
     * @return 结果
     */
    public int deleteTMedicalCostOutpatientInfoById(Long id);

    /**
     * 批量删除门诊卡信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalCostOutpatientInfoByIds(Long[] ids);
}
