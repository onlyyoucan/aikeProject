package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.mapper.TMedicalCostOutpatientInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.service.ITMedicalCostOutpatientInfoService;

/**
 * 门诊卡信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Service
public class TMedicalCostOutpatientInfoServiceImpl implements ITMedicalCostOutpatientInfoService 
{
    @Autowired
    private TMedicalCostOutpatientInfoMapper tMedicalCostOutpatientInfoMapper;

    /**
     * 查询门诊卡信息
     * 
     * @param id 门诊卡信息主键
     * @return 门诊卡信息
     */
    @Override
    public TMedicalCostOutpatientInfo selectTMedicalCostOutpatientInfoById(Long id)
    {
        return tMedicalCostOutpatientInfoMapper.selectTMedicalCostOutpatientInfoById(id);
    }

    /**
     * 查询门诊卡信息列表
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 门诊卡信息
     */
    @Override
    public List<TMedicalCostOutpatientInfo> selectTMedicalCostOutpatientInfoList(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.selectTMedicalCostOutpatientInfoList(tMedicalCostOutpatientInfo);
    }

    /**
     * 新增门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    @Override
    public int insertTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.insertTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo);
    }

    /**
     * 修改门诊卡信息
     * 
     * @param tMedicalCostOutpatientInfo 门诊卡信息
     * @return 结果
     */
    @Override
    public int updateTMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo)
    {
        return tMedicalCostOutpatientInfoMapper.updateTMedicalCostOutpatientInfo(tMedicalCostOutpatientInfo);
    }

    /**
     * 批量删除门诊卡信息
     * 
     * @param ids 需要删除的门诊卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientInfoByIds(Long[] ids)
    {
        return tMedicalCostOutpatientInfoMapper.deleteTMedicalCostOutpatientInfoByIds(ids);
    }

    /**
     * 删除门诊卡信息信息
     * 
     * @param id 门诊卡信息主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostOutpatientInfoById(Long id)
    {
        return tMedicalCostOutpatientInfoMapper.deleteTMedicalCostOutpatientInfoById(id);
    }
}
