package com.shirman.ishangchi.weixin.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;






import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shirman.ishangchi.rest.ctrl.LoginCtrl;
import com.shirman.ishangchi.rest.dao.ArticleDao;
import com.shirman.ishangchi.rest.entity.Article;

/**
 * 
 * @ClassName: PushManageUtil
 * @Description: 微信返回数据xml格式化
 * @author Shirman
 * @date 2016年1月25日 下午3:22:21
 * @version V1.0
 */
@Service("pushManageService")
public class PushManageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginCtrl.class);	

	
	@Autowired
	private ArticleDao articleDao;
	
	public String buildReturnXmlMessage(InputStream is) throws JDOMException {

		String returnStr = ""; // 反回Servlet字符串
		String toName = ""; // 开发者微信号
		String fromName = ""; // 发送方帐号（一个OpenID）
		String type = ""; // 请求类型
		String con = ""; // 消息内容(接收)
		String event = ""; // 自定义按钮事件请求
		String eKey = ""; // 事件请求key值

		try {

			SAXBuilder sax = new SAXBuilder();
			Document doc = sax.build(is);
			// 获得文件的根元素
			Element root = doc.getRootElement();

			// 获得根元素的第一级子节点
			List list = root.getChildren();
			for (int j = 0; j < list.size(); j++) {
				// 获得结点
				Element first = (Element) list.get(j);

				if (first.getName().equals("ToUserName")) {
					toName = first.getValue().trim();
				} else if (first.getName().equals("FromUserName")) {
					fromName = first.getValue().trim();
				} else if (first.getName().equals("MsgType")) {
					type = first.getValue().trim();
				} else if (first.getName().equals("Content")) {
					con = first.getValue().trim();
				} else if (first.getName().equals("Event")) {
					event = first.getValue().trim();
				} else if (first.getName().equals("EventKey")) {
					eKey = first.getValue().trim();
				}
			}
		} catch (IOException e) {
			// 异常
		}

		if (type.equals("event")) { // 此为事件
			if (event.equals("subscribe")) {// 此为 关注事件

			} else if (event.equals("unsubscribe")) { // 此为取消关注事件

			} else if (event.equals("CLICK")) { // 此为 自定义菜单按钮点击事件
				// 以下为自定义按钮事件
				if (eKey.equals("V1")) { // 菜单1
					returnStr = getBackXMLTypeText(toName, fromName, "点击了菜单1");
				} else if (eKey.equals("V2")) { // 菜单2
					returnStr = getBackXMLTypeText(toName, fromName, "点击了菜单2");
				}
			}
		} else if (type.equals("text")) { // 此为 文本信息
			LOGGER.info("收到微信消息："+con);
			returnStr = getBackXMLTypeText(toName, fromName, "漂流瓶：" + con+" 飘向深海…… 访问：http://www.ishangchi.cn/ishangchi 前往深海沙滩 ");
			List<Article> articles = new ArrayList<Article>();
			Article article = new Article();
			article.setContent(con);
			article.setTitle("漂流瓶");
			article.setAuthor(fromName);
			article.setType(2);
			article.setCreateTime(new Date());
			articles.add(article);
			articleDao.insertArticles(articles);
		}

		return returnStr;
	}

	/**
	 * 编译文本信息
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeText(String toName, String fromName,
			String content) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("text"));
		rootXML.addContent(new Element("Content").setText(content));

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * 编译图片信息(单图模式)
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeImg(String toName, String fromName,
			String title, String content, String url, String pUrl) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("news"));
		rootXML.addContent(new Element("ArticleCount").setText("1"));

		Element fXML = new Element("Articles");
		Element mXML = null;

		mXML = new Element("item");
		mXML.addContent(new Element("Title").setText(title));
		mXML.addContent(new Element("Description").setText(content));
		mXML.addContent(new Element("PicUrl").setText(pUrl));
		mXML.addContent(new Element("Url").setText(url));
		fXML.addContent(mXML);
		rootXML.addContent(fXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * 编译图片信息(无图模式)
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeImg(String toName, String fromName,
			String title, String content, String url) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("news"));
		rootXML.addContent(new Element("ArticleCount").setText("1"));

		Element fXML = new Element("Articles");
		Element mXML = null;

		// String url = "";
		String ss = "";
		mXML = new Element("item");
		mXML.addContent(new Element("Title").setText(title));
		mXML.addContent(new Element("Description").setText(content));
		mXML.addContent(new Element("PicUrl").setText(ss));
		mXML.addContent(new Element("Url").setText(url));
		fXML.addContent(mXML);
		rootXML.addContent(fXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * 编译音乐信息
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getBackXMLTypeMusic(String toName, String fromName,
			String content) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("music"));

		Element mXML = new Element("Music");

		mXML.addContent(new Element("Title").setText("音乐"));
		mXML.addContent(new Element("Description").setText("音乐让人心情舒畅！"));
		mXML.addContent(new Element("MusicUrl").setText(content));
		mXML.addContent(new Element("HQMusicUrl").setText(content));

		rootXML.addContent(mXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}
}
