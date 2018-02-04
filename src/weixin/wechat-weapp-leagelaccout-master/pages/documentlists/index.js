// pages/documentlists/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    documentlistcolor: [{ color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }],
    filelistcolor: [{ color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }, { color: "black" }],
        documentlist:[
        {
          id:"1",
          name:"劳动人事制度",
          color: "black" 
        },
        {
          id:"2",
          name:"伤害事故处理",
          color: "black" 
        },
        {
          id: "3",
          name: "幼儿园专题",
          color: "black" 
        },
        {
          id: "4",
          name: "培训机构专题",
          color: "black" 
        },
        {
          id: "5",
          name: "诉讼案例",
          color: "black" 
        },
        {
          id: "6",
          name: "理论研究",
          color: "black" 
        }
        
        ],
        filename:
        [{ id: "1", name: "从《劳动合同法》看学校该如何完善用工制度", color: "black" }, { id: "2", name: "单位不得收取押金、扣留证件或档案", color: "black" }, { id: "3", name: "女职工在孕、产、哺期间的劳动保护", color: "black" }, { id: "4", name: "如何申请工伤认定", color: "black" }, { id: "5", name: "用人单位违法解除劳动合同的责任", color: "black"}],
        filename1:
        [{ id: "1", name: "地震中的逃生避险策略", color: "black" }, { id: "2", name: "发生火灾后如何紧急逃生", color: "black" }, { id: "3", name: "洪水到来时的紧急避险措施", color: "black" }, { id: "4", name: "投保校方责任险", color: "black" }, { id: "5", name: "拥挤踩踏事故的安全对策", color: "black"}],
        filename2:
        [{ id: "1", name: "成都市民办幼儿园教育现状" }, { id: "4", name: "投保校方责任险" }],
        filename3:
        [{ id: "4", name: "发生火灾后如何紧急逃生" }, { id: "4", name: "投保校方责任险" }],
        filename4:
        [{ id: "5", name: "发生火灾后如何紧急逃生" }, { id: "4", name: "投保校方责任险" }],
        filename5:
        [{ id: "6", name: "发生火灾后如何紧急逃生" }, { id: "4", name: "投保校方责任险" }],
        
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
  openfile:function(e){
    console.log(e);
    wx.openDocument({
      filePath: '../../files/从《劳动合同法》看学校该如何完善用工制度.docx',
      fileType:'docx',
      success:function(){
        console.log("asdasd");
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