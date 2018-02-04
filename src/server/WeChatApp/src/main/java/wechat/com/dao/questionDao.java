package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBQuestion;

@Repository
public class questionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBQuestion selectById(Long id) {
		return sqlSessionTemplate.selectOne("questionMapper.selectById", id);
	}
	
	public List<DBQuestion> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("questionMapper.selectAll", query);
	}
	
	public List<DBQuestion> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("questionMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBQuestion question) {
		sqlSessionTemplate.insert("questionMapper.insert", question);
	}
	
	public void update(DBQuestion question) {
		sqlSessionTemplate.update("questionMapper.update", question);
	}
}
