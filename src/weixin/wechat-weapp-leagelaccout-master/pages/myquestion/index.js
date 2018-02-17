const utils = require("../../utils/util.js")
Page({
  data: {
    undo:"block",
    hasdo:"none",
    undocolor:'#0a4e27',
    hasdocolor:'#13773d',
    hasdo_content: [
      {
      id: '01',
      contents: 'question',
      status:'0',
      apply: '没问题',
},
{
    id: '02',
    contents: 'question',
    status: '0',
    apply: '没问题',
}, 
{
    id: '03',
    contents: 'question',
    status: '0',
    apply: '没问题',
}
    ],undo_content:[
    { id: '4', contents: '求解决' }, { id: '5', contents: '求解决' },
     {id: '6', contents: '求解决' },
      {id: '7', contents: '求解决' }
]
},
  onLoad() {

  },
  onShow(){
    wx.hideLoading();
  },
  swiper:function(e){

    var that = this;
    if (e.currentTarget.dataset.status == 0){
        that.setData({
       
          undo: "block",
          hasdo: "none",
          undocolor: '#0a4e27',
          hasdocolor: '#13773d',
        })
     }else{
      that.setData({
     
        undo: "none",
        hasdo: "block",
        undocolor: '#13773d',
        hasdocolor: '#0a4e27',
      })
    }
  }
  ,
  showHide(e) {

    var contentFor = this.data.content;

    for(var i = 0; i<contentFor.length; i++) {
  　　if (e.currentTarget.dataset.changeid == contentFor[i].id) {
    　　　　var printPrice = "content[" + i + "].shows";
    　　　　if (this.data.content[i].shows) {
      　　　　　　this.setData({
        　　　　　　　　[printPrice]: false
      　　　　　　});
    　　　　} else {
      　　　　　　this.setData({
        　　　　　　　　[printPrice]: true
      　　　　　　});
    　　　　}
  　　} else {
    　　　　　　var printPrice1 = "content[" + i + "].shows";
    　　　　　　this.setData({
      　　　　　　　　[printPrice1]: false
    　　　　　　});
  　　　　}
　　}
}
})