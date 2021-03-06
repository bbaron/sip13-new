package com.springinpractice.ch13.sitemap.service;

import java.util.List;
import java.util.Map;

import com.springinpractice.ch13.sitemap.model.SiteNode;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface SitemapService {
	
	Map<String, SiteNode> getNodeMap();
	
	List<SiteNode> getTopLevelNodes();
	
	SiteNode findNodeByKey(String key);
	
	SiteNode findNodeByMethodAndPath(String method, String path);
}
