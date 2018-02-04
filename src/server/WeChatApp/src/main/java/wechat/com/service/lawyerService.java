package wechat.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import wechat.com.common.errorCodeEnum;
import wechat.com.common.permissionConstant;
import wechat.com.dao.pojo.DBLawyer;
import wechat.com.dao.pojo.DBUser;
import wechat.com.protocol.myRuntimeException;
import wechat.com.protocol.serviceResponse;
@Service
public class lawyerService extends baseService {
	private final static Logger logger = LoggerFactory.getLogger(lawyerService.class);
	
	public serviceResponse importLawyer() {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			// read excel 
			List<DBLawyer> lawyerList = new ArrayList<DBLawyer>();
			for(DBLawyer lawyer : lawyerList) {
				Map<String, Object> query = 
						new HashMap<String, Object>();
				query.put("name", lawyer.getName());
				query.put("phone", lawyer.getPhone());
				List<DBLawyer> dbLawyerList = 
						super.lawyerDao.selectAll(query);
				if(dbLawyerList == null || 
						dbLawyerList.size() == 0) {
					super.lawyerDao.insert(lawyer);
					List<DBUser> dbUserList = 
							super.userDao.selectAll(query);
					for(DBUser user : dbUserList) {
						user.setPermission((long)permissionConstant.LAWYER);
						super.userDao.update(user);
					}
				}
			}
		} catch (myRuntimeException e) {
			logger.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new myRuntimeException(
					errorCodeEnum.SERVICE_ERR.toString());
		}
		return sr;
	}
}
