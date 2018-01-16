const config = require('../config.js');

/**
 * 判断手机号是否合法并返回内容
 */
function isMobileNumber(phone) {
  var flag = false;
  var message = "";
  var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[4-9]{1})|(18[0-9]{1})|(199))+\d{8})$/;
  if (phone === '') {
    // console.log("手机号码不能为空");  
    message = "手机号码不能为空！";
  } else if (phone.length != 11) {
    //console.log("请输入11位手机号码！");  
    message = "请输入11位手机号码！";
  } else if (!myreg.test(phone)) {
    //console.log("请输入有效的手机号码！");  
    message = "请输入有效的手机号码！";
  } else {
    flag = true;
  }
  if (message != "") {
    // alert(message);  
  }
  return flag;
}  

/**
 * 用于发送消息至服务端
 */
function AJAX( data = '', fn, method = "get", header = {}) {
    wx.request({
      url: config.ServerHost + data,
      method: method ? method : 'get',
      data: {},
      header: header ? header : { "Content-Type": "application/json" },
      success: function (res) {
        fn(res);
      }
    });
}

function formatTime(date) {
  var year = date.getFullYear()
  var month = date.getMonth() + 1
  var day = date.getDate()

  var hour = date.getHours()
  var minute = date.getMinutes()
  var second = date.getSeconds()


  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
  n = n.toString()
  return n[1] ? n : '0' + n
}

module.exports = {
  formatTime:formatTime,
  formatNumber: formatNumber,
  isMobileNumber: isMobileNumber
}
