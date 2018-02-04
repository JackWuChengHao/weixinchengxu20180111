package wechat.com.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import wechat.com.common.errorCodeEnum;
import wechat.com.common.normalConstant;
import wechat.com.dao.pojo.DBArticle;
import wechat.com.protocol.myRuntimeException;
import wechat.com.protocol.serviceResponse;
@Service
public class articleService extends baseService {
	private final static Logger logger = LoggerFactory.getLogger(articleService.class);

	/**
	 * create an article
	 */
	public serviceResponse create(String ) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {

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

	/**
	 * release somewhere
	 */
	public serviceResponse release(Integer id, Integer somewhere) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			if(somewhere == null) {
				throw new myRuntimeException(
						errorCodeEnum.RELEASE_LOCATION.toString());
			}
			DBArticle article = super.articleDao.selectById(id);
			if(article == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_ARTICLE.toString());
			}
			String releaseStatus = article.getReleasePlace();
			if(somewhere.equals(normalConstant.BANNER)) {
				if(normalConstant.BANNER_STR.equals(releaseStatus)) {
					throw new myRuntimeException(
							errorCodeEnum.RE_RELEASE.toString());
				}
				article.setReleasePlace(normalConstant.BANNER_STR);
			} else if(somewhere.equals(normalConstant.LIST)) {
				if(normalConstant.LIST_STR.equals(releaseStatus)) {
					throw new myRuntimeException(
							errorCodeEnum.RE_RELEASE.toString());
				}
				article.setReleasePlace(normalConstant.LIST_STR);
			} else {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_LOCATION.toString());
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

	/**
	 * stop release
	 */
	public serviceResponse unRelease(Integer id) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			DBArticle article = super.articleDao.selectById(id);
			if(article == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_ARTICLE.toString());
			}
			article.setReleasePlace(null);
			super.articleDao.update(article);
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

	/**
	 * query article list
	 */
	public serviceResponse query(Map<String, Object> query) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			List<DBArticle> articleList = 
					super.articleDao.selectAll(query);
			sr.setObject(articleList);
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
