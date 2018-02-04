// pages/documentlists/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
        documentlist:[
        {
          id:"1",
          name:"劳动人事制度",
        },
        {
          id:"2",
          name:"伤害事故处理",
        }
        ],
        filename:
          [{ id: "1", name: "单位不得收取押金、扣留证件或档案" }, { id: "2", name: "如何申请工伤认定" }],
        filename1:
        [{ id: "3", name: "发生火灾后如何紧急逃生" }, { id: "4", name: "投保校方责任险" }],
        
        now_filename:[]
      
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
       now_filename:that.data.filename
    })
    
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

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  change_filename:function(e){
    var that = this;
    if (e.currentTarget.dataset.classifyId == 2){
        that.setData({
       now_filename: that.data.filename1
    })
    }else{
      that.setData({
        now_filename: that.data.filename
      })
    }
  }
})