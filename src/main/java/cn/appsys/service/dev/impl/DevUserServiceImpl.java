package cn.appsys.service.dev.impl;

import cn.appsys.dao.devUser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.dev.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper mapper;

    @Override
    public DevUser login(String devCode, String password) {
        DevUser devUser = null;
        devUser = mapper.getLoginUser(devCode);
        if (null != devUser) {
            if (!devUser.getDevPassword().equals(password)){
                devUser = null;
            }
        }
        return devUser;
    }
}
