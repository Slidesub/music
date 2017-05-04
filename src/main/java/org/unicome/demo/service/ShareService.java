package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.Share;

public interface ShareService {

    public List<Share> listSharesByCreateDate(int curPage, int pageSize);

    public void upShare(String id);

    public int getCount();
}
