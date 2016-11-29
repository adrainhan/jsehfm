package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmProcess;
import org.hf.jsem.entity.JcmProcessLog;

import java.sql.Date;

/**
 * Created by adramer on 2016/11/18.
 */
public interface JcmPorcessLogSercieI {
    public void  saveOrUPdate(JcmProcessLog log);

}
