package wechat.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import wechat.com.common.normalConstant;
import wechat.com.dao.PtBBSMessageRecordDao;
import wechat.com.dao.articleDao;
import wechat.com.dao.lawyerDao;
import wechat.com.dao.publicBBSMessageRecord;
import wechat.com.dao.questionDao;
import wechat.com.dao.signDao;
import wechat.com.dao.systemNoticeDao;
import wechat.com.dao.teacherDao;
import wechat.com.dao.userDao;

@Service
public class baseService {
	@Autowired
	protected articleDao articleDao;
	@Autowired
	protected lawyerDao lawyerDao;
	@Autowired
	protected PtBBSMessageRecordDao ptMRDao;
	@Autowired
	protected publicBBSMessageRecord publicMRDao;
	@Autowired
	protected questionDao questionDao;
	@Autowired
	protected signDao signDao;
	@Autowired
	protected systemNoticeDao systemNoticeDao;
	@Autowired
	protected teacherDao teacherDao;
	@Autowired
	protected userDao userDao;

	protected PageBounds getPageBounds(
			Integer page,
			Integer pageSize,
			String item,
			Integer rule) {

		if(page == null)
			page = 1;
		if(pageSize == null)
			pageSize = 10;
		List<Order> orderList = null;
		if(item != null) {
			if(rule == null || 
					rule.equals(normalConstant.ASC)) {
				orderList = Order.formString(item + ".asc");
			} else {
				orderList = Order.formString(item + ".desc");
			}
		}
		if(orderList != null)
			return new PageBounds(page, pageSize, orderList);
		return new PageBounds(page, pageSize);
	}
}
