package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBSign;

@Repository
public class signDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBSign selectById(Long id) {
		return sqlSessionTemplate.selectOne("signMapper.selectById", id);
	}
	
	public List<DBSign> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("signMapper.selectAll", query);
	}
	
	public List<DBSign> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("signMapper.selectAll", query, pageBounds);
	}
	
	public DBSign selectByUserId(Long userId) {
		return sqlSessionTemplate.selectOne("signMapper.selectByUserId", userId);
	}
	
	public void insert(DBSign sign) {
		sqlSessionTemplate.insert("signMapper.insert", sign);
	}
	
	public void update(DBSign sign) {
		sqlSessionTemplate.update("signMapper.update", sign);
	}
}
