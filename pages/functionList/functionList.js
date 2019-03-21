Page({

  /**
   * 页面的初始数据
   */
  data: {

    routers: [
      {
        name: '普通计算器',
        url: '/pages/general/general',
        icon: '/image/jiandan.png',
        code: '10'
      },
      {
        name: '体锻计算器',
        url: '/pages/exercise/exercise',
        icon: '/image/tiduan.png',
        code: '11'
      },
      {
        name: '绩点计算器',
        url: '/pages/gpa/gpa',
        icon: '/image/jidian.png',
        code: '10'
      },
      {
        name: '距离计算器',
        url:'/pages/distance/distance',
        icon: '/image/juli.png',
        code: '11'
      },
      {
        name: '亲戚计算器',
        url: '/pages/relationship/relationship',
        icon: '/image/qinqi.png',
        code: '10'
      },
      {
        name: '敬请期待...',
        icon: '/image/qidai.png',
        code: '11'
      },

    ]

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

  general:function(){
    wx.navigateTo({
      url: '../general/general',
    })
  },

  relationship:function(){
    wx.navigateTo({
      url: '../relationship/relationship',
    })
  }
})