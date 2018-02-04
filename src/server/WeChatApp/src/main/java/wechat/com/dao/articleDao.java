package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBArticle;

@Repository
public class articleDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBArticle selectById(Integer id) {
		return sqlSessionTemplate.selectOne("articleMapper.selectById", id);
	}
	
	public List<DBArticle> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("articleMapper.selectAll", query);
	}
	
	public List<DBArticle> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("articleMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBArticle article) {
		sqlSessionTemplate.insert("articleMapper.insert", article);
	}
	
	public void update(DBArticle article) {
		sqlSessionTemplate.update("articleMapper.update", article);
	}
}
