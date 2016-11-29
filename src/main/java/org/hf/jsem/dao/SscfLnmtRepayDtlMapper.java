package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.SscfLnmtRepayDtl;
import org.hf.jsem.entity.SscfLnmtRepayDtlExample;

public interface SscfLnmtRepayDtlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int countByExample(SscfLnmtRepayDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByExample(SscfLnmtRepayDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insert(SscfLnmtRepayDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insertSelective(SscfLnmtRepayDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    List<SscfLnmtRepayDtl> selectByExample(SscfLnmtRepayDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExampleSelective(@Param("record") SscfLnmtRepayDtl record, @Param("example") SscfLnmtRepayDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_REPAY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExample(@Param("record") SscfLnmtRepayDtl record, @Param("example") SscfLnmtRepayDtlExample example);
}