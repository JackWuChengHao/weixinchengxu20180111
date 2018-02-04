package wechat.com.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import wechat.com.common.answerWayEnum;
import wechat.com.common.errorCodeEnum;
import wechat.com.common.normalConstant;
import wechat.com.common.questionStateEnum;
import wechat.com.dao.pojo.DBQuestion;
import wechat.com.dao.pojo.DBUser;
import wechat.com.protocol.myRuntimeException;
import wechat.com.protocol.pageResult;
import wechat.com.protocol.serviceResponse;

@Service
public class questionService extends baseService {
	private final static Logger logger = LoggerFactory.getLogger(questionService.class);
	
	/**
	 * ask
	 */
	public serviceResponse ask(Long questionerId,
			String content,
			Long questionerContactInfo,
			Boolean pay) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			DBUser user = super.userDao.selectById(questionerId);
			if(user == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_QUESTIONER.toString());
			}
			if(StringUtils.isBlank(content)) {
				throw new myRuntimeException(
						errorCodeEnum.NULL_QUESTION.toString());
			}
			DBQuestion question = new DBQuestion();
			question.setQuestioner(user);
			question.setContent(content);
			question.setCreateAt(new Date());
			question.setState(questionStateEnum.SUBMIT.getMsg());
			if(pay) {
				question.setPay(normalConstant.PAY);
				question.
				setQuestionerContactInfo(questionerContactInfo);
			} else {
				question.setPay(normalConstant.NO_PAY);
			}
			super.questionDao.insert(question);
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
	 * urgent
	 */
	public serviceResponse urgent(Long questionId,
			Long questionerContactInfo) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			DBQuestion question = super.
					questionDao.selectById(questionId);
			if(question == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_QUESTION.toString());
			}
			if(question.getState().equals(
					questionStateEnum.FINISH.getMsg())) {
				throw new myRuntimeException(
						errorCodeEnum.FINISHED_NONEED.toString());
			}
			question.setPay(normalConstant.PAY);
			question.setQuestionerContactInfo(
					questionerContactInfo);
			super.questionDao.update(question);
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
	 * answer
	 */
	public serviceResponse answer(Long answerId,
			Long questionId,
			String answerWay) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			DBUser user = super.userDao.selectById(answerId);
			if(user == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_QUESTIONER.toString());
			}
			DBQuestion question = super.
					questionDao.selectById(questionId);
			if(question == null) {
				throw new myRuntimeException(
						errorCodeEnum.UNKNOW_QUESTION.toString());
			}
			if(answerWay == null) {
				question.setAnswerWay(answerWayEnum.OTHER.getMsg());
			} else if(answerWay.equals(answerWayEnum.WRITTEN.getMsg())) {
				question.setAnswerWay(answerWayEnum.WRITTEN.getMsg());
			} else if(answerWay.equals(answerWayEnum.PHONE.getMsg())) {
				question.setAnswerWay(answerWayEnum.PHONE.getMsg());
			} else {
				question.setAnswerWay(answerWayEnum.OTHER.getMsg());
			}
			question.setAnswer(user);
			question.setAnswerAt(new Date());
			question.setState(questionStateEnum.FINISH.getMsg());
			super.questionDao.update(question);
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
	 * query
	 */
	public serviceResponse query(Map<String, Object> query,
			Integer page) {
		serviceResponse sr = new 
				serviceResponse(errorCodeEnum.SUCCESS);
		try {
			PageBounds pageBounds = 
					super.getPageBounds(page, normalConstant.PAGE_SIZE, null, null);
			List<DBQuestion> questionList = 
					super.questionDao.selectAll(query, pageBounds);
			PageList<DBQuestion> questionPageList = 
					(PageList<DBQuestion>)questionList;
			pageResult<DBQuestion> questionPageResult = 
					new pageResult<DBQuestion>();
			questionPageResult.setTotal(
					questionPageList.getPaginator().getTotalPages());
			questionPageResult.setResultList(questionList);
			sr.setObject(questionPageResult);
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
