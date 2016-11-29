package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.JcmJobInnerLog;

/**
 * Created by adramer on 2016/11/15.
 */
public interface JcmJobIneerLogServerI {
    void saveOrUpdate(JcmJobInnerLog log);


}
