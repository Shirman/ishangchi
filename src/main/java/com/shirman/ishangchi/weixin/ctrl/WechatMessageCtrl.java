package com.shirman.ishangchi.weixin.ctrl;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shirman.ishangchi.common.util.StringUtil;
import com.shirman.ishangchi.rest.ctrl.LoginCtrl;
import com.shirman.ishangchi.weixin.service.PushManageService;

/**
 * 
 * @ClassName: WechatMessageCtrl 
 * @Description: 接受微信消息入口
 * @author Shirman
 * @date 2016年1月25日 下午3:00:59 
 * @version V1.0
 */
@RequestMapping(value="/wechat")
@Controller
public class WechatMessageCtrl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginCtrl.class);	
	
	@Resource
	private PushManageService pushManageService;
	/**
	 * 
	 * @author Shirman	
	 * @projectNo:
	 * @date 2016年1月25日 下午3:02:39 
	 * @param response
	 * @param request
	 * @update 2016年1月25日 下午3:02:39 
	 * <pre>
	 *   微信消息入口
	 * <pre>
	 */
	@RequestMapping(value="/message")
	@ResponseBody
	public void wechat(HttpServletResponse response,HttpServletRequest request,String echostr){
	    PrintWriter out = null;  
		    try {  
		    	response.setCharacterEncoding("UTF-8");  
			    request.setCharacterEncoding("UTF-8");  
		    	out = response.getWriter();
		        InputStream is = request.getInputStream();  
		        if(StringUtil.isNotEmpty(echostr)){
		        	 out.print(echostr);  
		        }else{
		        	 String getXml = pushManageService.buildReturnXmlMessage(is);  
		        	 LOGGER.info("回复消息： "+getXml);
		        	out.print(getXml);  
		        }
		    } catch (JDOMException e) {  
		        e.printStackTrace();  
		        out.print("");  
		    } catch (Exception e) {  
		        out.print("");  
		    } finally {   
		        if(out!=null) {   
		            out.flush();  
		            out.close();  
		        }  
		    }  
	}
}
