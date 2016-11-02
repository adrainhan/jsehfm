package org.hf.jsem.serviceI;

import org.hf.jsem.entity.JcmJobInfo;

import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
public interface JcmJobInfoServiceI {
    JcmJobInfo getById(String jobCd);

    List<JcmJobInfo> getByWorkType(String workType);

    boolean validateAllFinishedByWorkType(String workType);

    int updateByPk(String jobCd);


}
