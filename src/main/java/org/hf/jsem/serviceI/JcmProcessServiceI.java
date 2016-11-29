package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmProcess;

/**
 * Created by adramer on 2016/10/25.
 */
public interface JcmProcessServiceI {
    public JcmProcess getByPk(String key);

    public void saveOrUpdate(JcmProcess process);

}
