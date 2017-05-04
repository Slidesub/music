package org.unicome.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.unicome.demo.service.MusicService;

@RestController
@RequestMapping("/")
public class DemoController {

    private final String APP_PAGE = "demo/app";
    private final String INDEX_PAGE = "demo/index";
    private final String HEADER_PAGE = "demo/header";
    private final String MUSIC_PAGE = "demo/music";
    private final String USER_PAGE = "demo/user";
    private final String SETTING_PAGE = "demo/setting";
    private final String SONGS_PAGE = "demo/songs";
    private final String SANCHOR_PAGE = "demo/anchor";
    private final String RANKING_PAGE = "demo/ranking";
    private final String RECOMMEND_PAGE = "demo/recommend";
    private final String USER_FRIENDS_PAGE = "demo/user_friends";
    private final String REGISTER_PAGE = "demo/register";
    private final String LOGIN_PAGE = "demo/login";

    @Autowired
    MusicService musicService;

    @RequestMapping("/")
    @ResponseBody
    ModelAndView app(ModelAndView model) {
        model.setViewName(APP_PAGE);
        return model;
    }

    @RequestMapping("/index")
    @ResponseBody
    ModelAndView index(ModelAndView model) {
        model.setViewName(INDEX_PAGE);
        return model;
    }

    @RequestMapping("/login")
    @ResponseBody
    ModelAndView home(ModelAndView model) {
        model.setViewName(LOGIN_PAGE);
        return model;
    }

    @RequestMapping("/register")
    @ResponseBody
    ModelAndView register(ModelAndView model) {
        model.setViewName(REGISTER_PAGE);
        return model;
    }

//    @RequestMapping("/index/recommend")
//    @ResponseBody
//    List<Music> recommend(@RequestParam(name="currentPage", defaultValue = "1") int currentPage,
//            @RequestParam(name="pageSize", defaultValue = "10") int pageSize) {
//    	List<Music> musics = musicService.listMusic(currentPage, pageSize);
//        return musics;
//    }


    /*
    @RequestMapping("music/{id}")
    public ModelAndView toPage(ModelAndView model, @PathVariable(name="id") String id) {
        if (id.equalsIgnoreCase("header")) {
            model.setViewName(HEADER_PAGE);
        } else if (id.equalsIgnoreCase("music")) {
            model.setViewName(MUSIC_PAGE);
        } else if (id.equalsIgnoreCase("user")) {
            model.setViewName(USER_PAGE);
        } else if (id.equalsIgnoreCase("setting")) {
            model.setViewName(SETTING_PAGE);
        } else if (id.equalsIgnoreCase("songs")) {
            model.setViewName(SONGS_PAGE);
        } else if (id.equalsIgnoreCase("anchor")) {
            model.setViewName(SANCHOR_PAGE);
        } else if (id.equalsIgnoreCase("ranking")) {
            model.setViewName(RANKING_PAGE);
        } else if (id.equalsIgnoreCase("recommend")){
            model.setViewName(RECOMMEND_PAGE);
        } else if (id.equalsIgnoreCase("friends")) {
        	model.setViewName(USER_FRIENDS_PAGE);
        }
        return model;
    }
    */
}
