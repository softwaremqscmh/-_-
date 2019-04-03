// pages/count/count.js
var app = getApp()

Page({

  data: {

  },

  onLoad: function(options) {
    this.setData({
      score:app.globalData.score,
      remain:app.globalData.remain,
      bmi:app.globalData.bmi,
    })
  },

  backCount: function(e) {
    wx.navigateBack({
      url: '../ex/ex'
    })
  },
  
})