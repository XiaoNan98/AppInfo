package cn.appsys.dao.appinfo;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    /**
     * 查询字典
     * @param
     * @return
     */
    public List<DataDictionary> getAppInfo();

    /**
     * 查询所有APP种类
     * @return
     */
    public List<AppCategory> getAppCategory();

    /**
     * 查询
     * @return
     */
    public List<AppInfo> getAppInfoList();
}
