package com.springinpractice.ch13.sitemap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.springinpractice.ch13.sitemap.model.SiteNode;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@RestResource(exported = false)
public interface SiteNodeRepository extends JpaRepository<SiteNode, Long> {
	
	SiteNode findByKey(String key);
	
	SiteNode findByPath(String path);
}
