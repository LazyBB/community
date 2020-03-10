package com.bbdemo.model;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.ID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.NOTIFIER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Long notifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.RECEIVER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Long receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.OUTERID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Long outerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.TYPE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.GMT_CREATE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.STATUS
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.NOTIFIER_NAME
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private String notifierName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTICE.OUTER_TITLE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    private String outerTitle;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.ID
     *
     * @return the value of NOTICE.ID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.ID
     *
     * @param id the value for NOTICE.ID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.NOTIFIER
     *
     * @return the value of NOTICE.NOTIFIER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.NOTIFIER
     *
     * @param notifier the value for NOTICE.NOTIFIER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.RECEIVER
     *
     * @return the value of NOTICE.RECEIVER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.RECEIVER
     *
     * @param receiver the value for NOTICE.RECEIVER
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.OUTERID
     *
     * @return the value of NOTICE.OUTERID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Long getOuterid() {
        return outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.OUTERID
     *
     * @param outerid the value for NOTICE.OUTERID
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setOuterid(Long outerid) {
        this.outerid = outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.TYPE
     *
     * @return the value of NOTICE.TYPE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.TYPE
     *
     * @param type the value for NOTICE.TYPE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.GMT_CREATE
     *
     * @return the value of NOTICE.GMT_CREATE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.GMT_CREATE
     *
     * @param gmtCreate the value for NOTICE.GMT_CREATE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.STATUS
     *
     * @return the value of NOTICE.STATUS
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.STATUS
     *
     * @param status the value for NOTICE.STATUS
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.NOTIFIER_NAME
     *
     * @return the value of NOTICE.NOTIFIER_NAME
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public String getNotifierName() {
        return notifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.NOTIFIER_NAME
     *
     * @param notifierName the value for NOTICE.NOTIFIER_NAME
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName == null ? null : notifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTICE.OUTER_TITLE
     *
     * @return the value of NOTICE.OUTER_TITLE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public String getOuterTitle() {
        return outerTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTICE.OUTER_TITLE
     *
     * @param outerTitle the value for NOTICE.OUTER_TITLE
     *
     * @mbg.generated Tue Mar 10 09:35:42 CST 2020
     */
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle == null ? null : outerTitle.trim();
    }
}