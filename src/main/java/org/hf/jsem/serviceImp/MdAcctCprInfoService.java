package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.SscfLnmtCaafverDtlMapper;
import org.hf.jsem.entity.*;
import org.hf.jsem.serviceI.MdAcctCprInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by adramer on 2016/11/29.
 */
@Service
public class MdAcctCprInfoService implements MdAcctCprInfoServiceI {
    @Autowired
    private SscfLnmtCaafverDtlMapper caafverDtlMapper;

    /**
     * @Author: adrainhan
     * @Time: 2016-11-29 16:13:13
     * @Description: 核销
     * @Param:dataDate 数据日期
     * @Return:List<SscfLnmtCaafverDtl>
     */
    public List<SscfLnmtCaafverDtl> getLnmtCaafverDtls(Date dataDate) {
        SscfLnmtCaafverDtlExample example = new SscfLnmtCaafverDtlExample();
        example.createCriteria().andXdCrtDateEqualTo(dataDate);

        return this.caafverDtlMapper.selectByExample(example);
    }

    public List<SscfLnmtReadpyDtl> getLnmtReadpyDtls(Date dataDate) {
        return null;
    }

    public List<SscfLnmtDiffDeco> getLnmtDiffDeco(Date dataDate) {
        return null;
    }

    public List<SscfLnmtInsrepDtl> getLnmtInsrepDtl(Date dataDate) {
        return null;
    }

    public List<SscfLnmtLoanDtl> getLnmtLoanDtl(Date dataDate) {
        return null;
    }

    public List<SscfLnmtRepayDtl> getLnmtRepayDtl(Date dataDate) {
        return null;
    }
}
