Page({
  data: {
    content: [
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
]
},
  onLoad() {

  },
  onShow(){
    wx.hideLoading();
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