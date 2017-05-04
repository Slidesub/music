package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.UserSheet;

public interface UserSheetService {
    public List<UserSheet> listUserSheet(int currentPage, int pageSize, int userId);
}
