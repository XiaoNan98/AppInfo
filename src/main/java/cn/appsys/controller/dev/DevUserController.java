package cn.appsys.controller.dev;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.dev.DevUserService;
import cn.appsys.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private DevUserService service = null;

    /**
     * 跳转到用户登录页面
     * @return
     */
    @RequestMapping("/login")
    public String loginUser(){
        System.out.println("login======================>");
        return "devlogin";
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/dologin")
    public String dologinUser(@RequestParam String devCode, @RequestParam String devPassword,
                              HttpSession session, HttpServletRequest request){
        System.out.println("dologin======================>");
        DevUser devUser = null;
        //调用service方法,进行用户拼配
        devUser = service.login(devCode,devPassword);
        if (null != devUser){
            session.setAttribute(Constants.USER_SESSION,devUser);
            //成功,跳转到主页(main.jsp)
            return "redirect:/dev/flatform/main";
        }else{
            //保留在登录页面
            request.setAttribute("error","用户名或密码有误!");
            return "devlogin";
        }
    }

    /**
     * 主页页面
     * @param session
     * @return
     */
    @RequestMapping("/flatform/main")
    public String main(HttpSession session){
        if (session.getAttribute(Constants.USER_SESSION) == null){
            return "redirect:/dev/login";
        }
        return "dev/main";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        //清除session
        session.removeAttribute(Constants.USER_SESSION);
        return "devlogin";
    }
}
