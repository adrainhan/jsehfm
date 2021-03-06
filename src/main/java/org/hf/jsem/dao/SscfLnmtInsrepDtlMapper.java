package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.SscfLnmtInsrepDtl;
import org.hf.jsem.entity.SscfLnmtInsrepDtlExample;

public interface SscfLnmtInsrepDtlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int countByExample(SscfLnmtInsrepDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByExample(SscfLnmtInsrepDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insert(SscfLnmtInsrepDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insertSelective(SscfLnmtInsrepDtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    List<SscfLnmtInsrepDtl> selectByExample(SscfLnmtInsrepDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExampleSelective(@Param("record") SscfLnmtInsrepDtl record, @Param("example") SscfLnmtInsrepDtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_INSREP_DTL
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExample(@Param("record") SscfLnmtInsrepDtl record, @Param("example") SscfLnmtInsrepDtlExample example);
}