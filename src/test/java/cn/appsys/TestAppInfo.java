package cn.appsys;

import cn.appsys.pojo.AppInfo;
import cn.appsys.service.dev.AppInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationCotenxt.xml")
public class TestAppInfo {

    @Autowired
    AppInfoService service;

    @Test
    public void TestApp(){
        List<AppInfo> appInfoList = service.findAppInfoList();
        System.out.println("-------------->"+appInfoList.size());
        for (AppInfo appInfo:appInfoList) {
            System.out.println("other===============>"+appInfo.getApkName());
            System.out.println(appInfo.getCategoryName1());
            System.out.println(appInfo.getCategoryName2());
            System.out.println(appInfo.getCategoryName3());
            System.out.println(appInfo.getValueName1());
            System.out.println(appInfo.getValueName2());

        }

    }
}
