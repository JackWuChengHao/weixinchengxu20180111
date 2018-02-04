package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBPtBBSMessageRecord;

@Repository
public class PtBBSMessageRecordDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBPtBBSMessageRecord selectById(Long id) {
		return sqlSessionTemplate.selectOne("PtBBSMessageRecordMapper.selectById", id);
	}
	
	public List<DBPtBBSMessageRecord> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("PtBBSMessageRecordMapper.selectAll", query);
	}
	
	public List<DBPtBBSMessageRecord> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("PtBBSMessageRecordMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBPtBBSMessageRecord PtBBSMessageRecord) {
		sqlSessionTemplate.insert("PtBBSMessageRecordMapper.insert", PtBBSMessageRecord);
	}
	
	public void update(DBPtBBSMessageRecord PtBBSMessageRecord) {
		sqlSessionTemplate.update("PtBBSMessageRecordMapper.update", PtBBSMessageRecord);
	}
}
