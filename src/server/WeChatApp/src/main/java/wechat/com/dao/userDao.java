package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBUser;

@Repository
public class userDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBUser selectById(Long id) {
		return sqlSessionTemplate.selectOne("userMapper.selectById", id);
	}
	
	public List<DBUser> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("userMapper.selectAll", query);
	}
	
	public List<DBUser> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("userMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBUser user) {
		sqlSessionTemplate.insert("userMapper.insert", user);
	}
	
	public void update(DBUser user) {
		sqlSessionTemplate.update("userMapper.update", user);
	}
}
