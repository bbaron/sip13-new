package com.springinpractice.ch13.helpdesk.web.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springinpractice.ch13.helpdesk.model.SiteNodeTemplate;
import com.springinpractice.ch13.helpdesk.service.SitemapService;
import com.springinpractice.ch13.helpdesk.web.util.ModelKeys;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Component
public class SitemapHandlerInterceptor extends HandlerInterceptorAdapter {
	@Inject private SitemapService sitemap;
	
	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView)
		throws Exception {
		
		// Controller has processed the request, but the view hasn't done so yet. This is where we want to instantiate
		// the node templates--we need the controller output to do it, but we need to make it available for the view.
		String method = request.getMethod();
		String path = request.getServletPath();
		SiteNodeTemplate node = sitemap.findNodeByMethodAndPath(method, path);
		
		if (node != null) {
			request.setAttribute(ModelKeys.NODE, node);
			request.setAttribute(ModelKeys.NODE_KEY, node.getKey());
			request.setAttribute(ModelKeys.NODES, sitemap.getNodeMap());
			request.setAttribute(ModelKeys.TOP_LEVEL_NODES, sitemap.getTopLevelNodes());
		}
	}
}
