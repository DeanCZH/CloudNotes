package com.mjl.dao;

import com.mjl.model.po.Upload;

/**
 * Created by Alvin on 15/11/17.
 */
public interface UploadDaoI {
    public Upload selete(int uploadId);
    public void add(Upload upload);
    public void delete(int uploadId);
    public void update(Upload upload);
}
