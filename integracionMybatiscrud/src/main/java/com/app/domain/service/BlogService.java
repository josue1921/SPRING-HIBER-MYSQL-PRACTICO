package com.app.domain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.domain.dto.Blog;
import com.app.domain.mappers.BlogMapper;

@Service
@Transactional
public class BlogService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	public void insertBlog(Blog blog) {
		blogMapper.insertBlog(blog);
	}

	public Blog getBlogById(Integer blogId) {
		return blogMapper.getBlogById(blogId);
	}

	public List<Blog> getAllBlogs() {
		return blogMapper.getAllBlogs();
	}

	public void updateBlog(Blog blog) {
		blogMapper.updateBlog(blog);
	}

	public void deleteBlog(Integer blogId) {
		blogMapper.deleteBlog(blogId);
	}
}
