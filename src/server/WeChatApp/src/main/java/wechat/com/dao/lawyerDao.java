package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBLawyer;

@Repository
public class lawyerDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBLawyer selectById(Integer id) {
		return sqlSessionTemplate.selectOne("lawyerMapper.selectById", id);
	}
	
	public List<DBLawyer> selectByName(String name) {
		return sqlSessionTemplate.selectList("lawyerMapper.selectByName", name);
	}
	
	public List<DBLawyer> selectByPhone(Long phone) {
		return sqlSessionTemplate.selectList("lawyerMapper.selectByPhone", phone);
	}
	
	public List<DBLawyer> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("lawyerMapper.selectAll", query);
	}
	
	public List<DBLawyer> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("lawyerMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBLawyer lawyer) {
		sqlSessionTemplate.insert("lawyerMapper.insert", lawyer);
	}
	
	public void update(DBLawyer lawyer) {
		sqlSessionTemplate.update("lawyerMapper.update", lawyer);
	}
}
