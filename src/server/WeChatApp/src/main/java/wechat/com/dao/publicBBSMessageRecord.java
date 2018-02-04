package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBPublicBBSMessageRecord;

@Repository
public class publicBBSMessageRecord {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBPublicBBSMessageRecord selectById(Long id) {
		return sqlSessionTemplate.selectOne("publicBBSMessageRecordMapper.selectById", id);
	}
	
	public List<DBPublicBBSMessageRecord> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("publicBBSMessageRecordMapper.selectAll", query);
	}
	
	public List<DBPublicBBSMessageRecord> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("publicBBSMessageRecordMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBPublicBBSMessageRecord publicBBSMessageRecord) {
		sqlSessionTemplate.insert("publicBBSMessageRecordMapper.insert", publicBBSMessageRecord);
	}
	
	public void update(DBPublicBBSMessageRecord publicBBSMessageRecord) {
		sqlSessionTemplate.update("publicBBSMessageRecordMapper.update", publicBBSMessageRecord);
	}
}
