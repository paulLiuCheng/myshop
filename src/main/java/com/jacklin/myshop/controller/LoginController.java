package com.jacklin.myshop.controller;

import com.google.code.kaptcha.Producer;
import com.jacklin.myshop.entity.AdminUser;
import com.jacklin.myshop.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 后台系统登入控制器
 */
@Api(value = "登入接口API")
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入
    @Autowired
    private Producer producer;

    @Autowired
    private AdminUserService adminUserService;

    /**
     * @return
     */
    @ApiOperation(value = "控制登入跳转", notes = "登入控制器跳转")
    @GetMapping("/admin/login")
    public String showLogin() {

        return "admin/login";
    }

    @ApiOperation(value = "登入处理接口", notes = "根据json对象处理登入")
    @PostMapping("/admin/login_do")
    @ResponseBody
    public String loginDo(@RequestBody AdminUser user, HttpServletRequest request) {
        logger.info("登入用户的信息：" + user);
        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        if (user != null) {
            AdminUser adminUser = adminUserService.selectByUser(user.getAusername(), user.getApassword());
            if (adminUser == null) {
                return "passwordError";
            } else if (!vrifyCode.equals(user.getVercode())) {
                return "vrifyCodeErroe";
            }
            request.getSession().setAttribute("loginName", user);
            return "success";
        } else {
            return "userNull";
        }
    }


    /**
     * 生成验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @ApiOperation(value = "验证码接口API", notes = "用于更新验证码")
    @GetMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = producer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = producer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @ApiOperation(value = "登出接口", notes = "注销接口")
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //销毁session
        session.invalidate();
        return "/admin/login";
    }

}
