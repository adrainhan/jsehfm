package org.hf.jsem.entity;

import java.util.Date;

public class AmMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.menu_id
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.menu_name
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.menu_desc
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String menuDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.url
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.is_group
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String isGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.parent_menu
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private Integer parentMenu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.crt_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String crtUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.crt_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private Date crtDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.last_update_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String lastUpdateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.last_update_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private Date lastUpdateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column am_menu.icon
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    private String icon;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.menu_id
     *
     * @return the value of am_menu.menu_id
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.menu_id
     *
     * @param menuId the value for am_menu.menu_id
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.menu_name
     *
     * @return the value of am_menu.menu_name
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.menu_name
     *
     * @param menuName the value for am_menu.menu_name
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.menu_desc
     *
     * @return the value of am_menu.menu_desc
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.menu_desc
     *
     * @param menuDesc the value for am_menu.menu_desc
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.url
     *
     * @return the value of am_menu.url
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.url
     *
     * @param url the value for am_menu.url
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.is_group
     *
     * @return the value of am_menu.is_group
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getIsGroup() {
        return isGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.is_group
     *
     * @param isGroup the value for am_menu.is_group
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setIsGroup(String isGroup) {
        this.isGroup = isGroup == null ? null : isGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.parent_menu
     *
     * @return the value of am_menu.parent_menu
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public Integer getParentMenu() {
        return parentMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.parent_menu
     *
     * @param parentMenu the value for am_menu.parent_menu
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setParentMenu(Integer parentMenu) {
        this.parentMenu = parentMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.crt_user
     *
     * @return the value of am_menu.crt_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.crt_user
     *
     * @param crtUser the value for am_menu.crt_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser == null ? null : crtUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.crt_date
     *
     * @return the value of am_menu.crt_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public Date getCrtDate() {
        return crtDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.crt_date
     *
     * @param crtDate the value for am_menu.crt_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.last_update_user
     *
     * @return the value of am_menu.last_update_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.last_update_user
     *
     * @param lastUpdateUser the value for am_menu.last_update_user
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.last_update_date
     *
     * @return the value of am_menu.last_update_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.last_update_date
     *
     * @param lastUpdateDate the value for am_menu.last_update_date
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column am_menu.icon
     *
     * @return the value of am_menu.icon
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column am_menu.icon
     *
     * @param icon the value for am_menu.icon
     *
     * @mbggenerated Mon Oct 31 21:34:23 CST 2016
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}