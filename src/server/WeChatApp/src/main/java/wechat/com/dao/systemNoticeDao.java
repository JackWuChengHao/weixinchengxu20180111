package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBSystemNotice;

@Repository
public class systemNoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBSystemNotice selectById(Long id) {
		return sqlSessionTemplate.selectOne("systemNoticeMapper.selectById", id);
	}
	
	public List<DBSystemNotice> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("systemNoticeMapper.selectAll", query);
	}
	
	public List<DBSystemNotice> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("systemNoticeMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBSystemNotice systemNotice) {
		sqlSessionTemplate.insert("systemNoticeMapper.insert", systemNotice);
	}
	
	public void update(DBSystemNotice systemNotice) {
		sqlSessionTemplate.update("systemNoticeMapper.update", systemNotice);
	}
}
