package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmProcess;

/**
 * Created by adramer on 2016/10/25.
 */
public interface JcmProcessServiceI {
    JcmProcess getByPk(String key);

    boolean  getCurrentRunStatus(String workType);

    boolean  getCurrentRunStatus(JcmProcess process);

}
