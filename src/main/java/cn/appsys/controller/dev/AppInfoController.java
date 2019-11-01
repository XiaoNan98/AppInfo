package cn.appsys.controller.dev;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.dev.AppInfoService;
import cn.appsys.service.dev.impl.AppInfoServiceImpl;
import cn.appsys.tools.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * APP信息控制器
 */
@Controller
@RequestMapping("/dev")
public class AppInfoController {

    @Autowired
    private AppInfoService service;

    @RequestMapping("/appinfo")
    public String AppInfoList(HttpSession session,Model model){
        System.out.println("appinfo===========================>");
        if (session.getAttribute(Constants.USER_SESSION) == null){
            return "redirect:/dev/login";
        }
        List<DataDictionary> list = service.findAppInfo();
        List<AppCategory> listCategory = service.findAppCategory();
        List<AppInfo> listAppInfo = service.findAppInfoList();
        model.addAttribute("list",list);//App字典
        model.addAttribute("list2",listCategory);//所有APP种类
        model.addAttribute("list3",listAppInfo);
        return "dev/appinfolist";
    }

    @RequestMapping("/appinfolistAjax")
    @ResponseBody
    public Object AppinfolistAjax(){
        System.out.println("/appinfolistAjax=================>");
        List<AppCategory> list = service.findAppCategory();
        return JSONArray.toJSONString(list);
    }
}
