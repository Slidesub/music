package org.unicome.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.Music;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.SheetMusic;
import org.unicome.demo.po.UserMusic;
import org.unicome.demo.po.UserSheet;
import org.unicome.demo.service.MusicService;
import org.unicome.demo.service.SheetMusicService;
import org.unicome.demo.service.SheetService;
import org.unicome.demo.service.UserMusicService;
import org.unicome.demo.service.UserSheetService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;
    @Autowired
    private UserMusicService userMusicService;
    @Autowired
    private UserSheetService userSheetService;
    @Autowired
    private SheetService sheetService;
    @Autowired
    private SheetMusicService sheetMusicService;
    

    @RequestMapping(value = "/getMusic", method = RequestMethod.GET)
    public Music getMusic(@RequestParam(name="id", defaultValue = "1") int id) {
        Music music = musicService.getMusic(id);
        return music;
    }

    @RequestMapping(value = "/listUserMusic", method = RequestMethod.GET)
    public String listUserMusic(
    		@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "userId", defaultValue = "0") String userId) {
        List<UserMusic> userMusics = userMusicService.listUserMusic(currentPage <= 0 ? 1: currentPage, pageSize, Integer.parseInt(userId));
        int pageCount = 0;
        int count = userMusicService.findCount(Integer.parseInt(userId));
        if (count % pageSize == 0) {
        	pageCount = count / pageSize;
        } else {
        	pageCount = (int)(count / pageSize) + 1;
        }
        String page = "{count:" + count + ", pageCount:" + pageCount + ", currentPage:" + currentPage + ", pageSize:" + pageSize + "}";
        JSONObject json = JSONObject.fromObject(page);
        JSONArray array1 = JSONArray.fromObject(userMusics);
        JSONArray array = new JSONArray();
        array.add(array1);
        array.add(json);
        return array.toString();
    }

    @RequestMapping(value = "/listUserSheet", method = RequestMethod.GET)
    public List<UserSheet> listUserSheet(
            @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "userId", defaultValue = "0") String userId) {
        List<UserSheet> songs = userSheetService.listUserSheet(currentPage, pageSize, Integer.parseInt(userId));
        return songs;
    }

    @RequestMapping(value = "/loadSheet", method = RequestMethod.GET)
    public String loadSheet(
    		 @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
             @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(name = "userId", defaultValue = "0") String userId) {
    	List<Sheet> sheets = sheetService.listSheetByUser(currentPage <= 0 ? 1 : currentPage, pageSize, Integer.parseInt(userId));
    	int pageCount = 0;
    	int count = sheetService.getCountByUser(Integer.parseInt(userId));
    	if (count % pageSize == 0) {
    		pageCount = count / pageSize;
    	} else {
    		pageCount = (int)(count / pageSize) + 1;
    	}
    	String page = "{count:" + count + ", pageCount:" + pageCount + ", currentPage:" + currentPage + ", pageSize:" + pageSize + "}";
    	JSONObject json = JSONObject.fromObject(page);
    	JSONArray array1 = JSONArray.fromObject(sheets);
    	JSONArray array = new JSONArray();
    	array.add(array1);
    	array.add(json);
    	return array.toString();
    }

    @RequestMapping(value = "/loadSheetMusic", method = RequestMethod.GET)
    public String loadSheetMusic(
             @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
             @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(name = "sheetId", defaultValue = "0") String sheetId) {
        List<SheetMusic> sheetMusics = sheetMusicService.listSheetMusicBySheet(currentPage <= 0 ? 1 : currentPage, pageSize, Integer.parseInt(sheetId));
        int pageCount = 0;
        int count = sheetService.getCountByUser(Integer.parseInt(sheetId));
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = (int)(count / pageSize) + 1;
        }
        String page = "{count:" + count + ", pageCount:" + pageCount + ", currentPage:" + currentPage + ", pageSize:" + pageSize + "}";
        JSONObject json = JSONObject.fromObject(page);
        JSONArray array1 = JSONArray.fromObject(sheetMusics);
        JSONArray array = new JSONArray();
        array.add(array1);
        array.add(json);
        return array.toString();
    }

    @RequestMapping(value ="/createSheet", method = RequestMethod.POST)
    public ValidateException createSheet(@RequestBody(required = true) String jsonString) {
    	try {
    		Sheet sheet = sheetService.createSheet(jsonString);
    		return new ValidateException(ValidateException.SUCCESS_CODE, "", sheet);
    	} catch (ValidateException ve) {
    		return new ValidateException(ValidateException.FAIL_CODE, "名称不能重复");
    	} catch(Exception e) {
    		e.printStackTrace();
            return new ValidateException(ValidateException.ERROR_CODE, "创建失败, 请重新创建");
    	}
    }

    //alter table `sheet` add constraint FK_sheet_user foreign key(user_id) references `user`(id);
}