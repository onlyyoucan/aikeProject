package com.ruoyi.system.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;
import com.ruoyi.system.service.ITMedicalCostPersonArchivesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人档案Controller
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@RestController
@RequestMapping("/system/archives")
public class TMedicalCostPersonArchivesController extends BaseController
{
    @Autowired
    private ITMedicalCostPersonArchivesService tMedicalCostPersonArchivesService;

    /**
     * 查询个人档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:archives:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        startPage();
        List<TMedicalCostPersonArchives> list = tMedicalCostPersonArchivesService.selectTMedicalCostPersonArchivesList(tMedicalCostPersonArchives);
        return getDataTable(list);
    }

    /**
     * 导出个人档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:archives:export')")
    @Log(title = "个人档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        List<TMedicalCostPersonArchives> list = tMedicalCostPersonArchivesService.selectTMedicalCostPersonArchivesList(tMedicalCostPersonArchives);
        ExcelUtil<TMedicalCostPersonArchives> util = new ExcelUtil<TMedicalCostPersonArchives>(TMedicalCostPersonArchives.class);
        util.exportExcel(response, list, "个人档案数据");
    }

    /**
     * 获取个人档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:archives:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tMedicalCostPersonArchivesService.selectTMedicalCostPersonArchivesById(id));
    }

    /**
     * 新增个人档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:add')")
    @Log(title = "个人档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        String replace = tMedicalCostPersonArchives.getName()+UUID.randomUUID().toString().replace("-", "");
        tMedicalCostPersonArchives.setId(replace);
        return toAjax(tMedicalCostPersonArchivesService.insertTMedicalCostPersonArchives(tMedicalCostPersonArchives));
    }

    /**
     * 修改个人档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:edit')")
    @Log(title = "个人档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalCostPersonArchives tMedicalCostPersonArchives)
    {
        return toAjax(tMedicalCostPersonArchivesService.updateTMedicalCostPersonArchives(tMedicalCostPersonArchives));
    }

    /**
     * 删除个人档案
     */
    @PreAuthorize("@ss.hasPermi('system:archives:remove')")
    @Log(title = "个人档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tMedicalCostPersonArchivesService.deleteTMedicalCostPersonArchivesByIds(ids));
    }
}
