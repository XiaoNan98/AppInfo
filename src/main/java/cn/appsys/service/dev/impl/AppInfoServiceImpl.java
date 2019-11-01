package cn.appsys.service.dev.impl;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.dev.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper mapper;

    @Override
    public List<DataDictionary> findAppInfo() {
        return mapper.getAppInfo();
    }

    @Override
    public List<AppCategory> findAppCategory() {
        return mapper.getAppCategory();
    }

    @Override
    public List<AppInfo> findAppInfoList() {
        return  mapper.getAppInfoList();
    }
}
