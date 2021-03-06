package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.JcmJobInfoExample;

public interface JcmJobInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int countByExample(JcmJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int deleteByExample(JcmJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int deleteByPrimaryKey(String jobCd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int insert(JcmJobInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int insertSelective(JcmJobInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    List<JcmJobInfo> selectByExample(JcmJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    JcmJobInfo selectByPrimaryKey(String jobCd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int updateByExampleSelective(@Param("record") JcmJobInfo record, @Param("example") JcmJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int updateByExample(@Param("record") JcmJobInfo record, @Param("example") JcmJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int updateByPrimaryKeySelective(JcmJobInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_JOB_INFO
     *
     * @mbggenerated Tue Nov 29 14:18:05 CST 2016
     */
    int updateByPrimaryKey(JcmJobInfo record);
}