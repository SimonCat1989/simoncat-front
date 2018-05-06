package com.simoncat.front.service;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.common.annotations.VisibleForTesting;

import cn.zhouyafeng.itchat4j.api.MessageTools;
import cn.zhouyafeng.itchat4j.beans.BaseMsg;
import cn.zhouyafeng.itchat4j.beans.RecommendInfo;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import cn.zhouyafeng.itchat4j.utils.enums.MsgTypeEnum;
import cn.zhouyafeng.itchat4j.utils.tools.DownloadTools;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsgHandler implements IMsgHandlerFace {

	private static final String RESOURCE_FOLDER = MsgHandler.class.getResource("/").getPath();
	private static final String TAOBAO_TOKEN_PATTEN = "￥";

	@Override
	public String textMsgHandle(BaseMsg msg) {
		String text = msg.getText();

		switch (text) {
		case "帮助":
			return createHelpMessage();
		case "信息": {
			return createUserMessage("0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
		}
		default: {
			// Extract Taobao token
			String itemName = text.substring(text.indexOf("【"), text.lastIndexOf("】") + 1);
			String token = text.substring(text.indexOf(TAOBAO_TOKEN_PATTEN), text.lastIndexOf(TAOBAO_TOKEN_PATTEN) + 1);
			if (StringUtils.isAnyBlank(itemName, token)) {
				return StringUtils.EMPTY;
			}
			// Use taobao token to get item information
			// mock
			return createTaobaoItemMessage(itemName, "400.00", "380.00", "1.60", "20.00", "http://www.baidu.com");
		}
		}
	}

	@Override
	public String picMsgHandle(BaseMsg msg) {
		// 这里使用收到图片的时间作为文件名
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpg";
		// 保存图片的路径
		String picPath = Paths.get(RESOURCE_FOLDER, "picture", fileName).normalize().toString();
		// 调用此方法来保存图片
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.PIC.getType(), picPath);
		return "图片保存成功";
	}

	@Override
	public String voiceMsgHandle(BaseMsg msg) {
		// 这里使用收到语音的时间作为文件名
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp3";
		// 保存语音的路径
		String voicePath = Paths.get(RESOURCE_FOLDER, "voice", fileName).normalize().toString();
		// 调用此方法来保存语音
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VOICE.getType(), voicePath);
		return "声音保存成功";
	}

	@Override
	public String viedoMsgHandle(BaseMsg msg) {
		// 这里使用收到小视频的时间作为文件名
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp4";
		// 保存小视频的路径
		String viedoPath = Paths.get(RESOURCE_FOLDER, "video", fileName).normalize().toString();
		// 调用此方法来保存小视频
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VIEDO.getType(), viedoPath);
		return "视频保存成功";
	}

	@Override
	public String nameCardMsgHandle(BaseMsg msg) {
		return "收到名片消息";
	}

	@Override
	public void sysMsgHandle(BaseMsg msg) {
		// 收到系统消息
		String text = msg.getContent();
		log.info(text);
	}

	@Override
	public String verifyAddFriendMsgHandle(BaseMsg msg) {
		// 同意好友请求，false为不接受好友请求
		MessageTools.addFriend(msg, true);
		RecommendInfo recommendInfo = msg.getRecommendInfo();
		String nickName = recommendInfo.getNickName();
		String province = recommendInfo.getProvince();
		String city = recommendInfo.getCity();
		return createWelcomeMessage(city, province, nickName);
	}

	@VisibleForTesting
	String createWelcomeMessage(String city, String province, String nickName) {
		StringBuilder result = new StringBuilder();
		result.append("您好，来自【");
		result.append(province);
		result.append("】【");
		result.append(city);
		result.append("】的【");
		result.append(nickName);
		result.append("】，欢迎添加我为好友！\n\n很高兴为您服务：");
		result.append("\n1、我将尽力为您省钱！");
		result.append("\n2、您将淘宝商品链接发送给我，我将会帮您查询该商品的优惠券！");
		result.append("\n3、完成该笔订单后，可领取现金返利！");
		result.append("\n\n发送【帮助】二字，学习如何使用机器人。");
		return result.toString();
	}

	@VisibleForTesting
	String createHelpMessage() {
		StringBuilder result = new StringBuilder();
		result.append("一一一一常 用 指 令一一一一");
		result.append("\n提现--提取返利红包");
		result.append("\n信息--查看个人信息");
		result.append("\n绑定--绑定支付宝");
		result.append("\n订单--订单记录");
		result.append("\n订单绑定--找回丢失订单");
		result.append("\n邀请好友--邀请并绑定好友");
		result.append("\n反映问题--人工处理问题");
		result.append("\n\n购物返利图文教程：");
		result.append("\nhttp://mp.weixin.qq.com/s/_BmMSfO_3VFVwSNLFwmSFg");
		return result.toString();
	}

	@VisibleForTesting
	String createTaobaoItemMessage(String itemName, String oringalPrice, String currentPrice, String estimateProfit,
			String discount, String url) {
		StringBuilder result = new StringBuilder();
		result.append("一一一一返 利 消 息一一一一\n");
		result.append(itemName);
		result.append("\n\n");

		result.append("原价：");
		result.append(oringalPrice);
		result.append("元\n");

		result.append("付费参考：");
		result.append(currentPrice);
		result.append("元\n");

		result.append("预计返利：");
		result.append(estimateProfit);
		result.append("元\n");

		result.append("优惠金额：");
		result.append(discount);
		result.append("元优惠卷\n");

		result.append("返利链接：");
		result.append(url);
		result.append("\n");

		result.append("↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n");
		result.append("【点击打开返利链接，进入点击一键复制按钮后，打开淘宝购买】");
		result.append("\n↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

		return result.toString();
	}

	@VisibleForTesting
	String createUserMessage(String totalDeposit, String availableDeposit, String frozenDeposit,
			String unavailableDeposit, String totalSuccessOrder, String SignInCount, String SignInDeposit,
			String popularizedCount, String popularizedDeposit, String inProgressDeposit) {
		StringBuilder result = new StringBuilder();
		result.append("一一一一个 人 信 息一一一一\n");

		result.append("总提现金额：");
		result.append(totalDeposit);
		result.append("元\n");

		result.append("可提现金额：");
		result.append(availableDeposit);
		result.append("元\n");

		result.append("冻结金额：");
		result.append(frozenDeposit);
		result.append("元\n");

		result.append("未收货金额：");
		result.append(unavailableDeposit);
		result.append("元\n");

		result.append("总成功订单：");
		result.append(totalSuccessOrder);
		result.append("单\n\n");

		result.append("签到次数：");
		result.append(SignInCount);
		result.append("次\n");

		result.append("签到奖励：");
		result.append(SignInDeposit);
		result.append("元\n");

		result.append("推广人数：");
		result.append(popularizedCount);
		result.append("人\n");

		result.append("推广奖励：");
		result.append(popularizedDeposit);
		result.append("元\n");

		result.append("提现中：");
		result.append(inProgressDeposit);
		result.append("元\n");

		return result.toString();
	}

	@Override
	public String mediaMsgHandle(BaseMsg msg) {
		return null;
	}

}
