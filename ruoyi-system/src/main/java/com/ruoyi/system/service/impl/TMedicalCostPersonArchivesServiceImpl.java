package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalCostPersonArchivesMapper;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesService;

/**
 * 个人档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
@Service
public class TMedicalCostPersonArchivesServiceImpl implements ITMedicalCostPersonArchivesService 
{
    @Autowired
    private TMedicalCostPersonArchivesMapper tMedicalCostPersonArchivesMapper;

    /**
     * 查询个人档案
     * 
     * @param id 个人档案主键
     * @return 个人档案
     */
    @Override
    public TMedicalCostPersonArchives selectTMedicalCostPersonArchivesById(String id)
    {
        return tMedicalCostPersonArchivesMapper.selectTMedicalCostPersonArchivesById(id);
    }

    /**
     * 查询个人档案列表
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 个人档案
     */
    @Override
    public List<TMedicalCostPersonArchives> selectTMedicalCostPersonArchivesList(TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        return tMedicalCostPersonArchivesMapper.selectTMedicalCostPersonArchivesList(tMedicalCostPersonArchives);
    }

    /**
     * 新增个人档案
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 结果
     */
    @Override
    public int insertTMedicalCostPersonArchives(TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        return tMedicalCostPersonArchivesMapper.insertTMedicalCostPersonArchives(tMedicalCostPersonArchives);
    }

    /**
     * 修改个人档案
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 结果
     */
    @Override
    public int updateTMedicalCostPersonArchives(TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        return tMedicalCostPersonArchivesMapper.updateTMedicalCostPersonArchives(tMedicalCostPersonArchives);
    }

    /**
     * 批量删除个人档案
     * 
     * @param ids 需要删除的个人档案主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostPersonArchivesByIds(String[] ids)
    {
        return tMedicalCostPersonArchivesMapper.deleteTMedicalCostPersonArchivesByIds(ids);
    }

    /**
     * 删除个人档案信息
     * 
     * @param id 个人档案主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalCostPersonArchivesById(String id)
    {
        return tMedicalCostPersonArchivesMapper.deleteTMedicalCostPersonArchivesById(id);
    }
}
