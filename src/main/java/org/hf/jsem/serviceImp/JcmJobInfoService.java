package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JcmJobInfoMapper;
import org.hf.jsem.dao.JobInfoDao;
import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.JcmJobInfoExample;
import org.hf.jsem.serviceI.JcmJobInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
@Service
public class JcmJobInfoService implements JcmJobInfoServiceI {
    @Autowired
    private JobInfoDao jobInfoDao;

    public JcmJobInfo getById(String jobCd) {
        return this.jobInfoDao.getById(jobCd);
    }

    public List<JcmJobInfo> getByWorkType(String workType) {
        JcmJobInfoExample example = new JcmJobInfoExample();
        JcmJobInfoExample.Criteria criteria = example.createCriteria();
        criteria.andWorkTypeEqualTo(workType).andStatusEqualTo("Y");
        return this.jobInfoDao.findAll(example);
    }

    public int getCountByExample(JcmJobInfoExample example) {
        return this.jobInfoDao.findAll(example).size();
    }

    public boolean saveOrUpdate(JcmJobInfo jcmJobInfo) {
        JcmJobInfo info = this.jobInfoDao.getById(jcmJobInfo.getJobCd());
        if (info == null) {
            this.jobInfoDao.save(info);
        } else {
            this.jobInfoDao.updateSelective(info);
        }


        return false;
    }

}