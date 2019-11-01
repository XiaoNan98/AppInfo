package cn.appsys.service.dev;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    /**
     * 查询字典
     * @return
     */
    public List<DataDictionary> findAppInfo();

    /**
     * 查询所有APP种类
     * @return
     */
    public List<AppCategory> findAppCategory();

    public List<AppInfo> findAppInfoList();

}
