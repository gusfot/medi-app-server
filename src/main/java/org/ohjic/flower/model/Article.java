package org.ohjic.flower.model;

import java.util.Date;

public class Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.article_seq
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private Integer articleSeq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.writer
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private String writer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.title
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.reg_time
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private String regTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.check_count
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private Integer checkCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.attached_file
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private String attachedFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.content
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.article_seq
     *
     * @return the value of article.article_seq
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public Integer getArticleSeq() {
        return articleSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.article_seq
     *
     * @param articleSeq the value for article.article_seq
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setArticleSeq(Integer articleSeq) {
        this.articleSeq = articleSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.writer
     *
     * @return the value of article.writer
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public String getWriter() {
        return writer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.writer
     *
     * @param writer the value for article.writer
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.title
     *
     * @return the value of article.title
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.title
     *
     * @param title the value for article.title
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.reg_time
     *
     * @return the value of article.reg_time
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.reg_time
     *
     * @param regTime the value for article.reg_time
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.check_count
     *
     * @return the value of article.check_count
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public Integer getCheckCount() {
        return checkCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.check_count
     *
     * @param checkCount the value for article.check_count
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.attached_file
     *
     * @return the value of article.attached_file
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public String getAttachedFile() {
        return attachedFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.attached_file
     *
     * @param attachedFile the value for article.attached_file
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setAttachedFile(String attachedFile) {
        this.attachedFile = attachedFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.content
     *
     * @return the value of article.content
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.content
     *
     * @param content the value for article.content
     *
     * @mbggenerated Thu Jul 28 11:14:45 KST 2016
     */
    public void setContent(String content) {
        this.content = content;
    }
}