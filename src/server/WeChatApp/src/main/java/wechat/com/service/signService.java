package wechat.com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import wechat.com.common.errorCodeEnum;
import wechat.com.dao.pojo.DBSign;
import wechat.com.dao.pojo.DBUser;
import wechat.com.protocol.myRuntimeException;
import wechat.com.protocol.serviceResponse;
import wechat.com.utils.datetimeUtil;

@Service
public class signService extends baseService {

	private final static Logger logger = LoggerFactory.getLogger(signService.class);
	
	public serviceResponse sign(Long operatorId) {
		serviceResponse sr = new serviceResponse(
				errorCodeEnum.SUCCESS);
		try {
			if(operatorId == null)
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_SIGNER.toString());
			DBUser operator = 
					super.userDao.selectById(operatorId);
			if(operator == null)
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_SIGNER.toString());
			Map<String, Object> query = 
					new HashMap<String, Object>();
			query.put("user", operator);
			Date begin = datetimeUtil.OneDayBegin(new Date());
			query.put("startSignAt", begin);
			query.put("endSignAt", 
					datetimeUtil.OneDayAfter(begin));
			List<DBSign> signList = super.signDao.selectAll(query);
			if(signList == null || signList.size() == 0) {
				DBSign sign = new DBSign();
				sign.setUser(operator);
				sign.setSignAt(new Date());
				super.signDao.insert(sign);
				
				operator.setIntegral(operator.getIntegral() + 5);
				super.userDao.update(operator);
			} else {
				throw new myRuntimeException(
						errorCodeEnum.RE_SIGN.toString());
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
