package com.simoncat.front.controller;

import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simoncat.front.service.MsgHandler;

import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws Exception {
		Thread weiChatLoginThread = new Thread() {

			@Override
			public void run() {
				// 保存登陆二维码图片的路径
				String qrPath = Paths.get(request.getServletContext().getRealPath("/"), "qrcode").normalize()
						.toString();
				// 实现IMsgHandlerFace接口的类
				IMsgHandlerFace msgHandler = new MsgHandler();
				// 【注入】
				Wechat wechat = new Wechat(msgHandler, qrPath);
				// 启动服务，会在qrPath下生成一张二维码图片，扫描即可登陆，
				// 注意，二维码图片如果超过一定时间未扫描会过期，过期时会自动更新，所以你可能需要重新打开图片
				wechat.start();
			}
		};
		weiChatLoginThread.start();
		Thread.sleep(2000);
		return new ModelAndView("/login", modelMap);
	}
}
