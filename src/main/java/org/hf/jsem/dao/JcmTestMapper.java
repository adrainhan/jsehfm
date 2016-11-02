package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.JcmTest;
import org.hf.jsem.entity.JcmTestExample;
import org.hf.jsem.orm.DataSourceClassAnnotaion;

public interface JcmTestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int countByExample(JcmTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int deleteByExample(JcmTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int deleteByPrimaryKey(String fId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int insert(JcmTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int insertSelective(JcmTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    List<JcmTest> selectByExample(JcmTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int updateByExampleSelective(@Param("record") JcmTest record, @Param("example") JcmTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JCM_TEST
     *
     * @mbggenerated Mon Oct 31 15:57:43 CST 2016
     */
    int updateByExample(@Param("record") JcmTest record, @Param("example") JcmTestExample example);
}