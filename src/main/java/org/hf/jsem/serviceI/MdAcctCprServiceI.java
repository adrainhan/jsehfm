package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.SscfWorkMain;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/3.
 */
public interface MdAcctCprServiceI {
    Map<String, String> doHxAcctCpr(List<SscfWorkMain> workMains, String dataDate);

    Map<String, String> doHkAcctCpr(List<SscfWorkMain> workMains, String dataDate);

    Map<String, String> doBkAcctCpr(List<SscfWorkMain> workMains, String dataDate);

    Map<String, String> doFkAcctCpr(List<SscfWorkMain> workMains, String dataDate);

    Map<String, String> doDcAcctCpr(List<SscfWorkMain> workMains, String dataDate);

    Map<String, String> doCyAcctCpr(List<SscfWorkMain> workMains, String dataDate);


}
