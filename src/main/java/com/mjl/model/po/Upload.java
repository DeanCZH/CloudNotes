package com.mjl.model.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Alvin on 15/11/16.
 */
public class Upload implements Serializable{
    private int uploadId;
    private int uploadUserId;
    private String uploadUriList;
    private Timestamp uploadCreateTime;

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public int getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(int uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public String getUploadUrlList() {
        return uploadUriList;
    }

    public void setUploadUrlList(String uploadUrlList) {
        this.uploadUriList = uploadUrlList;
    }

    public Timestamp getUploadCreateTime() {
        return uploadCreateTime;
    }

    public void setUploadCreateTime(Timestamp uploadCreateTime) {
        this.uploadCreateTime = uploadCreateTime;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "uploadId=" + uploadId +
                ", uploadUserId=" + uploadUserId +
                ", uploadUriList='" + uploadUriList + '\'' +
                ", uploadCreateTime=" + uploadCreateTime +
                '}';
    }
}
