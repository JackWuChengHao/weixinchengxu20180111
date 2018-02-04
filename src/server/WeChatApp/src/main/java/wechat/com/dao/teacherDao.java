package wechat.com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.dao.pojo.DBTeacher;

@Repository
public class teacherDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DBTeacher selectById(Integer id) {
		return sqlSessionTemplate.selectOne("teacherMapper.selectById", id);
	}
	
	public List<DBTeacher> selectByName(String name) {
		return sqlSessionTemplate.selectList("teacherMapper.selectByName", name);
	}
	
	public List<DBTeacher> selectByPhone(Long phone) {
		return sqlSessionTemplate.selectList("teacherMapper.selectByPhone", phone);
	}
	
	public List<DBTeacher> selectAll(Map<String, Object> query) {
		return sqlSessionTemplate.selectList("teacherMapper.selectAll", query);
	}
	
	public List<DBTeacher> selectAll(Map<String, Object> query, PageBounds pageBounds) {
		return sqlSessionTemplate.selectList("teacherMapper.selectAll", query, pageBounds);
	}
	
	public void insert(DBTeacher teacher) {
		sqlSessionTemplate.insert("teacherMapper.insert", teacher);
	}
	
	public void update(DBTeacher teacher) {
		sqlSessionTemplate.update("teacherMapper.update", teacher);
	}
}
