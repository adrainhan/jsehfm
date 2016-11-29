package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.JcmJobInfoExample;

import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
public interface JcmJobInfoServiceI {
    List<JcmJobInfo> getByWorkType(String workType);

    int getCountByExample(JcmJobInfoExample example);

    boolean saveOrUpdate(JcmJobInfo jcmJobInfo);


}
