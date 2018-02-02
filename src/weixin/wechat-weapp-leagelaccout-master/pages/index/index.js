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
          { title: '胡律师人好' },
          { title: '胡律师人好' },
          { title: '胡律师人好' },
          { title: '胡律师人好' },
          { title: '胡律师人好' },
          { title: '胡律师人好' },
          { title: '胡律师人好' },
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

        //sliderList
        wx.request({
            url: 'https://huanqiuxiaozhen.com/wemall/slider/list',
            method: 'GET',
            data: {},
            header: {
                'Accept': 'application/json'
            },
            success: function(res) {
                that.setData({
                    images: res.data
                })
            }
        })

        //venuesList
        wx.request({
            url: 'https://huanqiuxiaozhen.com/wemall/venues/venuesList',
            method: 'GET',
            data: {},
            header: {
                'Accept': 'application/json'
            },
            success: function(res) {
                that.setData({
                    venuesItems: res.data.data
                })
                setTimeout(function () {
                    that.setData({
                        loadingHidden: true
                    })
                }, 1500)
            }
        })

        //choiceList
        wx.request({
            url: 'https://huanqiuxiaozhen.com/wemall/goods/choiceList',
            method: 'GET',
            data: {},
            header: {
                'Accept': 'application/json'
            },
            success: function(res) {
                that.setData({
                    choiceItems: res.data.data.dataList
                })
                setTimeout(function () {
                    that.setData({
                        loadingHidden: true
                    })
                }, 1500)
            }
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