package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;

/**
 * 个人档案Service接口
 * 
 * @author ruoyi
 * @date 2022-09-01
 */
public interface ITMedicalCostPersonArchivesService 
{
    /**
     * 查询个人档案
     * 
     * @param id 个人档案主键
     * @return 个人档案
     */
    public TMedicalCostPersonArchives selectTMedicalCostPersonArchivesById(String id);

    /**
     * 查询个人档案列表
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 个人档案集合
     */
    public List<TMedicalCostPersonArchives> selectTMedicalCostPersonArchivesList(TMedicalCostPersonArchives tMedicalCostPersonArchives);

    /**
     * 新增个人档案
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 结果
     */
    public int insertTMedicalCostPersonArchives(TMedicalCostPersonArchives tMedicalCostPersonArchives);

    /**
     * 修改个人档案
     * 
     * @param tMedicalCostPersonArchives 个人档案
     * @return 结果
     */
    public int updateTMedicalCostPersonArchives(TMedicalCostPersonArchives tMedicalCostPersonArchives);

    /**
     * 批量删除个人档案
     * 
     * @param ids 需要删除的个人档案主键集合
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesByIds(String[] ids);

    /**
     * 删除个人档案信息
     * 
     * @param id 个人档案主键
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesById(String id);
}
