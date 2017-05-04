package org.unicome.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.ShareRepository;
import org.unicome.demo.po.Share;
import org.unicome.demo.service.ShareService;
import org.unicome.demo.util.DateUtil;

import net.sf.json.JSONObject;

@Service
public class ShareServiceImpl implements ShareService{

    @Autowired
    private ShareRepository shareRepo;
	@Override
	public List<Share> listSharesByCreateDate(int curPage, int pageSize) {
		Date startDate = DateUtil.getDate(0);
		Date endDate = DateUtil.getDate(1);
		Sort sort = new Sort(Direction.ASC, "createDate");
		Pageable pageable = new PageRequest(curPage - 1, pageSize, sort);
		List<Share> shares = (List<Share>) shareRepo.findShareByCreateDate(startDate, endDate, pageable);
		return shares;
	}
	@Override
	public void upShare(String id) {
		shareRepo.updateUp(Integer.valueOf(id));
	}
	@Override
	public int getCount() {
		Date startDate = DateUtil.getDate(0);
		Date endDate = DateUtil.getDate(1);
		int count= (int)shareRepo.findCount(startDate, endDate);
		return count;
	}
}
