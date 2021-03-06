package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.SscfLnmtReadpyDtl;
import org.hf.jsem.entity.SscfLnmtReadpyDtlExample;

public interface SscfLnmtReadpyDtlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int countByExample(SscfLnmtReadpyDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByExample(SscfLnmtReadpyDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insert(SscfLnmtReadpyDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insertSelective(SscfLnmtReadpyDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    List<SscfLnmtReadpyDtl> selectByExample(SscfLnmtReadpyDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExampleSelective(@Param("record") SscfLnmtReadpyDtl record, @Param("example") SscfLnmtReadpyDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_READPY_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExample(@Param("record") SscfLnmtReadpyDtl record, @Param("example") SscfLnmtReadpyDtlExample example);
}