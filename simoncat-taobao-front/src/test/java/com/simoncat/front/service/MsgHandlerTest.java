package com.simoncat.front.service;

import org.junit.Test;

import cn.zhouyafeng.itchat4j.beans.BaseMsg;

public class MsgHandlerTest {

	private static final String INCOMMING_MESSAGE = "【WD西部数据 移动硬盘1tb Elements 1T西数硬盘新元素 USB3.0高速】http://m.tb.cn/h.Wy5DJZg 点击链接，再选择浏览器打开；或复制这条信息￥mXex0tNHS5m￥后打开手淘";

	private final MsgHandler handler = new MsgHandler();

	@Test
	public void testTextMsgHandle() {
		BaseMsg msg = new BaseMsg();
		msg.setText(INCOMMING_MESSAGE);
		Object result = handler.textMsgHandle(msg);
		System.out.println(result);
	}

	@Test
	public void testCreateWelcomeMessage() {
		String result = handler.createWelcomeMessage("上海", "上海", "小丫头");
		System.out.println(result);
	}
}
