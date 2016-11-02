package org.hf.jsem.entity;

import java.util.Date;

public class JcmProcess {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.WORK_TYPE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private String workType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.WORK_TYPE_DESC
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private String workTypeDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.LAST_RUN_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private Date lastRunDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.CURRENT_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private Date currentDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.RUN_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private String runFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.CURRENT_DATE_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private String currentDateFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column JCM_PROCESS.LAST_RUN_INFO
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    private String lastRunInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.WORK_TYPE
     *
     * @return the value of JCM_PROCESS.WORK_TYPE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.WORK_TYPE
     *
     * @param workType the value for JCM_PROCESS.WORK_TYPE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.WORK_TYPE_DESC
     *
     * @return the value of JCM_PROCESS.WORK_TYPE_DESC
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public String getWorkTypeDesc() {
        return workTypeDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.WORK_TYPE_DESC
     *
     * @param workTypeDesc the value for JCM_PROCESS.WORK_TYPE_DESC
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setWorkTypeDesc(String workTypeDesc) {
        this.workTypeDesc = workTypeDesc == null ? null : workTypeDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.LAST_RUN_DATE
     *
     * @return the value of JCM_PROCESS.LAST_RUN_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public Date getLastRunDate() {
        return lastRunDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.LAST_RUN_DATE
     *
     * @param lastRunDate the value for JCM_PROCESS.LAST_RUN_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setLastRunDate(Date lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.CURRENT_DATE
     *
     * @return the value of JCM_PROCESS.CURRENT_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.CURRENT_DATE
     *
     * @param currentDate the value for JCM_PROCESS.CURRENT_DATE
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.RUN_FLAG
     *
     * @return the value of JCM_PROCESS.RUN_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public String getRunFlag() {
        return runFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.RUN_FLAG
     *
     * @param runFlag the value for JCM_PROCESS.RUN_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setRunFlag(String runFlag) {
        this.runFlag = runFlag == null ? null : runFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.CURRENT_DATE_FLAG
     *
     * @return the value of JCM_PROCESS.CURRENT_DATE_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public String getCurrentDateFlag() {
        return currentDateFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.CURRENT_DATE_FLAG
     *
     * @param currentDateFlag the value for JCM_PROCESS.CURRENT_DATE_FLAG
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setCurrentDateFlag(String currentDateFlag) {
        this.currentDateFlag = currentDateFlag == null ? null : currentDateFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column JCM_PROCESS.LAST_RUN_INFO
     *
     * @return the value of JCM_PROCESS.LAST_RUN_INFO
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public String getLastRunInfo() {
        return lastRunInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column JCM_PROCESS.LAST_RUN_INFO
     *
     * @param lastRunInfo the value for JCM_PROCESS.LAST_RUN_INFO
     *
     * @mbggenerated Tue Nov 01 14:20:05 CST 2016
     */
    public void setLastRunInfo(String lastRunInfo) {
        this.lastRunInfo = lastRunInfo == null ? null : lastRunInfo.trim();
    }
}