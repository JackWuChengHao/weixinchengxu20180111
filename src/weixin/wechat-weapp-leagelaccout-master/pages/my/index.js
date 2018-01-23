//获取应用实例
var app = getApp()
Page({
    data:{
      userInfo: {},
      userListInfo: [
        {
          icon: '../../images/questionlist.png',
          text: '我的问题',
          isunread: true,
          unreadNum: 1
        },
        {
          icon: '../../images/systemmsg.png',
          text: '系统消息',
          isunread: false,
          unreadNum: 1
        },
        {
          icon: '../../images/customer service.png',
          text: '联系客服'
        }]
    },



      onLoad: function () {
      var that = this
      //调用应用实例的方法获取全局数据
      app.getUserInfo(function (userInfo) {
        //更新数据
        that.setData({
          userInfo: userInfo
        })
      })
    }
})
