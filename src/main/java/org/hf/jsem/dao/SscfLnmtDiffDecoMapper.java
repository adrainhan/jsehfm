package org.hf.jsem.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hf.jsem.entity.SscfLnmtDiffDeco;
import org.hf.jsem.entity.SscfLnmtDiffDecoExample;

public interface SscfLnmtDiffDecoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int countByExample(SscfLnmtDiffDecoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int deleteByExample(SscfLnmtDiffDecoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insert(SscfLnmtDiffDeco record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int insertSelective(SscfLnmtDiffDeco record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    List<SscfLnmtDiffDeco> selectByExample(SscfLnmtDiffDecoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExampleSelective(@Param("record") SscfLnmtDiffDeco record, @Param("example") SscfLnmtDiffDecoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SSCF_LNMT_DIFF_DECO
     *
     * @mbggenerated Fri Nov 04 11:37:37 CST 2016
     */
    int updateByExample(@Param("record") SscfLnmtDiffDeco record, @Param("example") SscfLnmtDiffDecoExample example);
}