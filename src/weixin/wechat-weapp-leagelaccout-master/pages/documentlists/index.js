const utils = require("../../utils/util.js")
// pages/documentlists/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    modalHidden:true,
    documentlistcolor: [{ color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }],
    filelistcolor: [{ color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }],
        documentlist:[
        {
          id:"1",
          name:"对外合同签订篇",
          color: "black" 
        },
        {
          id:"2",
          name:"教师职业保护篇",
          color: "black" 
        },
        {
          id: "3",
          name: "日常教育教学篇",
          color: "black" 
        },
        {
          id: "4",
          name: "校园安全管理篇",
          color: "black" 
        },
        {
          id: "5",
          name: "学生权利维护篇",
          color: "black" 
        },
        {
          id: "6",
          name: "预防违法犯罪篇",
          color: "black" 
        }
        
        ],
        filenamelists:
        [[{ id: "1-1", name: "对外合同签订", color: "black" }], [{ id: "2-1", name: "教师职业保护", color: "black" }], [{ id: "3-1", name: "日常教育教学" }], [{ id: "4-1", name: "校园安全管理" }], [{ id: "5-1", name: "学生权利维护" }], [{ id: "6-1", name: "预防违法犯罪" }]]
      
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
  closeModal: function () {
    var that = this
    that.setData({
      modalHidden: true
    })
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
  openfile:function(e){
    console.log(e);
    var that = this;
    that.setData({
      modalHidden:false,
    })
    wx.downloadFile({
      url: "https://www.bafy.gov.cn/uploadfiles/files/zfl.doc",
      success: function (res){
        var filePath = res.tempFilePath 
        wx.openDocument({
          filePath: 'filePath',
          success: function (res) {
            console.log(res);
          }
        })
      }
    })
    
  }
  ,
  change_filename:function(e){
    var that = this;
    if (e.currentTarget.dataset.classifyId == 2){
   that.data.documentlist.map(function(x,index,arr){
        var y;
        if(index == 1){
         y = x 
          y.color = "#0a4e27"
          x = y 
        }else{
          y = x
          y.color = "#black"
          x = y 
        }
      })
        that.setData({
          documentlist: that.data.documentlist,
          now_filename: that.data.filename1,
    })
    }else{
     that.data.documentlist.map(function (x, index, arr) {
        if (index == 0) {
          x.color = "#0a4e27";
        } else {
          x.color = "black";
        }
      })

      that.setData({
        documentlist: that.data.documentlist,
        now_filename: that.data.filename
      })
    }
  }
})