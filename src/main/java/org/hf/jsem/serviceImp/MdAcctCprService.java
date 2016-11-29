package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JcmJobInnerLogMapper;
import org.hf.jsem.dao.JcmJobLogMapper;
import org.hf.jsem.dao.SscfLnmtCaafverDtlMapper;
import org.hf.jsem.entity.*;
import org.hf.jsem.enums.ClTradeStatus;
import org.hf.jsem.enums.ClTradeTypes;
import org.hf.jsem.enums.ZfTradeStatus;
import org.hf.jsem.keypool.KeyGenerator;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.hf.jsem.serviceI.DiffAcctServiceI;
import org.hf.jsem.serviceI.MdAcctCprInfoServiceI;
import org.hf.jsem.serviceI.MdAcctCprServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/3.
 */
@Service
public class MdAcctCprService implements MdAcctCprServiceI {
    @Autowired
    private MdAcctCprInfoServiceI mdAcctCprInfoServiceI;


    public Map<String, String> doHxAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
            List<SscfLnmtCaafverDtl> lnmtCaafverDtls = this.mdAcctCprInfoServiceI.getLnmtCaafverDtls(deaDataDate);
            //当获取到的记录为空时直接返回
            if (!(lnmtCaafverDtls == null || lnmtCaafverDtls.size() == 0)) {

            }
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }


        return result;
    }

    public Map<String, String> doHkAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }
        return result;
    }

    public Map<String, String> doBkAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }
        return result;
    }

    public Map<String, String> doFkAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }
        return result;
    }

    public Map<String, String> doDcAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }
        return result;
    }

    public Map<String, String> doCyAcctCpr(List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("result", "SUCCESS");
        result.put("info", "委贷对账业务核销完成");
        try {
            Date deaDataDate = new Date(new SimpleDateFormat("yyyyMMdd").parse(dataDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            result.put("result", "FAILED");
            result.put("info", e.getMessage());
        }
        return result;
    }
}
