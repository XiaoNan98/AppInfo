package cn.appsys.dao.devUser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 开发人员接口
 */
@Repository
public interface DevUserMapper {
    /*
    根据devCode获取用户记录
     */
    public DevUser getLoginUser(@Param("devCode") String devCode);
}
