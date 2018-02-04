//app.js
App({
  onLaunch: function () {
    console.log('App Launch')
    //调用API从本地缓存中获取数据
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
  },
  getUserInfo:function(cb){
    var that = this
    if(this.globalData.userInfo){
      typeof cb == "function" && cb(this.globalData.userInfo)
    }else{
      //调用登录接口
      wx.login({
        success: function (ee) {
          console.log(ee);
          wx.getUserInfo({
            success: function (res) {
              console.log(res)
              that.globalData.userInfo = res.userInfo
              typeof cb == "function" && cb(that.globalData.userInfo)
            }
          })
        }
      })
      // wx.login({
      //   success: function (res) {
      //     wx.request({
      //       //获取openid接口  
      //       url: 'https://api.weixin.qq.com/sns/jscode2session',
      //       data: {
      //         appid: "wxe8c01284a821705f",
      //         secret: "wxe8c01284a821705f",
      //         js_code: res.code,
      //         grant_type: 'authorization_code'
      //       },
      //       method: 'GET',
      //       success: function (res) {
      //         console.log(res.data)
      //         OPEN_ID = res.data.openid;//获取到的openid  
      //         SESSION_KEY = res.data.session_key;//获取到session_key  
      //         console.log(OPEN_ID.length)
      //         console.log(SESSION_KEY.length)
      //         that.setData({
      //           openid: res.data.openid.substr(0, 10) + '********' + res.data.openid.substr(res.data.openid.length - 8, res.data.openid.length),
      //           session_key: res.data.session_key.substr(0, 8) + '********' + res.data.session_key.substr(res.data.session_key.length - 6, res.data.session_key.length)
      //         })
      //       }
      //     })
        // }
      // })  
    }
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  },
  globalData:{
    userInfo:null
  }
})
