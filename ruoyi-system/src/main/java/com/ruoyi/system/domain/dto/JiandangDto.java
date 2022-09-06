package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.TMedicalCostOutpatientInfo;
import com.ruoyi.system.domain.TMedicalCostPersonArchives;

public class JiandangDto {

    private TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo;

    private TMedicalCostPersonArchives tMedicalCostPersonArchives;


    public JiandangDto() {
    }


    public TMedicalCostOutpatientInfo gettMedicalCostOutpatientInfo() {
        return tMedicalCostOutpatientInfo;
    }

    public void settMedicalCostOutpatientInfo(TMedicalCostOutpatientInfo tMedicalCostOutpatientInfo) {
        this.tMedicalCostOutpatientInfo = tMedicalCostOutpatientInfo;
    }

    public TMedicalCostPersonArchives gettMedicalCostPersonArchives() {
        return tMedicalCostPersonArchives;
    }

    public void settMedicalCostPersonArchives(TMedicalCostPersonArchives tMedicalCostPersonArchives) {
        this.tMedicalCostPersonArchives = tMedicalCostPersonArchives;
    }
}
