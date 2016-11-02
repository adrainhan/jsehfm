package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JcmJobInfoMapper;
import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.serviceI.JcmJobInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adramer on 2016/10/25.
 */
@Service("jcmJobInfoService")
public class JcmJobInfoService{
    private JcmJobInfoMapper jobInfoDao;

}