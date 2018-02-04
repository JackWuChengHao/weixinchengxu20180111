//获取应用实例
var app = getApp()
Page({
    data: {
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1000,
        loadingHidden: true,  // loading
        y_menus: [
          { id:"1",title: '胡律师人好' },
          { id: "2",title: '胡律师人好' },
          { id: "3",title: '胡律师人好' },
          { id: "4",title: '胡律师人好' },
          { id: "5",title: '胡律师人好' },
          { id: "6",title: '胡律师人好' },
          { id: "7",title: '胡律师人好' },
        ],
        x_menus: [
          { title: '教师', 
          icon: '../../images/consult-enterance/teacher.png',          withinfotoconsult: 'teacher'},
          { title: '学生', icon: '../../images/consult-enterance/student.png', classes: 'two_side'
            , withinfotoconsult: 'student'  },
          {
            title: '学校', icon: '../../images/consult-enterance/school.png', classes: 'two_side',
            withinfotoconsult: 'school'},
          { title: '其他', icon: '../../images/consult-enterance/other.png',
            withinfotoconsult: 'other' },
        ],
    },

    //事件处理函数
    swiperchange: function(e) {
        //console.log(e.detail.current)
    },
    
    onLoad: function() {
        console.log('onLoad')
        var that = this
            //调用应用实例的方法获取全局数据
        app.getUserInfo(function(userInfo) {
            //更新数据
            that.setData({
                userInfo: userInfo
            })
        })
    },
  todetail:function(e){
    wx.showLoading({
      title: '请稍等',
    })
    wx.navigateTo({
      url: "../detailmessage/index?id=" + e.currentTarget.dataset.id,
})

  },
    navtoConsultPage: function (item) {
      wx.showLoading({
        title: '请稍等',
      });
      var withinfotoconsult = item.currentTarget.dataset.withinfotoconsult;
      wx.navigateTo({
        url: '../consult/index',
        complete:function(){
          
        }
      })
     },
})