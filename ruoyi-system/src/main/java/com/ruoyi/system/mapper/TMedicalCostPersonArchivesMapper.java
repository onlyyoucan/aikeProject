package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;

/**
 * 个人档案Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface TMedicalCostPersonArchivesMapper 
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
     * 删除个人档案
     * 
     * @param id 个人档案主键
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesById(String id);

    /**
     * 批量删除个人档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalCostPersonArchivesByIds(String[] ids);
}
