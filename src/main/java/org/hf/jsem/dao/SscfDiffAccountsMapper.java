package org.hf.jsem.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.SscfDiffAccounts;
import org.hf.jsem.entity.SscfDiffAccountsExample;

public interface SscfDiffAccountsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int countByExample(SscfDiffAccountsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByExample(SscfDiffAccountsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal diffId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insert(SscfDiffAccounts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insertSelective(SscfDiffAccounts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    List<SscfDiffAccounts> selectByExample(SscfDiffAccountsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    SscfDiffAccounts selectByPrimaryKey(BigDecimal diffId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExampleSelective(@Param("record") SscfDiffAccounts record, @Param("example") SscfDiffAccountsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExample(@Param("record") SscfDiffAccounts record, @Param("example") SscfDiffAccountsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByPrimaryKeySelective(SscfDiffAccounts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_DIFF_ACCOUNTS
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByPrimaryKey(SscfDiffAccounts record);
}