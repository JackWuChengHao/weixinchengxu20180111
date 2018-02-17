const utils = require("../../utils/util.js")
// pages/setInfo/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:{
      nichen:"xiaohei",
      telephone:"18852992317",
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    wx.hideLoading();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**11
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },
  change_nc:function(){
    var that = this;
    console.log("okok");
    that.setData({
      change_nichen:false
    });
  },
 change_tp: function () { 
   var that = this;
   that.setData({
     change_telephone:false
   });
 },
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})