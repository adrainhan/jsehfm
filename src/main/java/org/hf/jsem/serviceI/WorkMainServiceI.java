package org.hf.jsem.serviceI;

import org.hf.jsem.entity.SscfWorkMain;

import java.sql.Date;
import java.util.List;

/**
 * Created by adramer on 2016/11/3.
 */
public interface WorkMainServiceI {

    List<SscfWorkMain> getCompareObjBetw(Date currentDate);


}
