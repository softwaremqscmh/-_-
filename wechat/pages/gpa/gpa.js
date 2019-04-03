var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置
const app = getApp();
let that = this;
Page({
  data: {
    tabs: ["GPA","绩点规划"],
    activeIndex: 0,
    sliderOffset: 0,
    sliderLeft: 0, 
    inputValue:'',
    gpa:0,
    openid:1,
    cname:'',
    credit:'',
    grade:'',
    category:'',
    periods: ['所有课程','专业课','非专业课'],
    value:['专业课','非专业课'],
    periodIndex:0,
  },

  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
          sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
        });
      }
    });

    wx:wx.request({
      url: 'http://localhost:8080/caculator/ResServlet',
      data: {
        openid: this.data.openid,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      responseType: 'text',
      success: function (res) {
        console.log(res)
        that.setData({
          data: res.data
        })

      },
      fail: function (res) { },
      complete: function (res) { },
    })

  },
  tabClick: function (e) {
    this.setData({
      sliderOffset: e.currentTarget.offsetLeft,
      activeIndex: e.currentTarget.id
    });

  },
  bindPeriodChange: function(e){
  //  let that = this;
    this.setData({
          periodIndex:e.detail.value
    })
    var items = [];
    var size = 0;
    
  },

  cname: function (e) {
    this.setData({
      cname: e.detail.value
    })
  },

  credit: function (e) {
    this.setData({
      credit: e.detail.value
    })
  },

  grade: function (e) {
    this.setData({
      grade: e.detail.value
    })
  },

  category: function (e) {
    this.setData({
      category: e.detail.value
    })
  },

  addCourse:function(){
    var that = this
    console.log(this.data)
    wx:wx.request({
      url: 'http://localhost:8080/caculator/WXServlet',
      data: {
        openid:this.data.openid,
        cname:this.data.cname,
        grade:this.data.grade,
        credit:this.data.credit,
        category:this.data.category
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      responseType: 'text',
      success: function(res) {
        console.log(res)
        that.setData({
          data:res.data
        })

      },
      fail: function(res) {},
      complete: function(res) {},
    })
  },

  clear:function(){
    this.data.cname = ''
    this.data.credit = ''
    this.data.grade = ''
    this.data.category = ''
    this.setData({
      inputValue:this.data.inputValue
    })
    console.log(this.data)
  },

  getCredit:function(){
    var that = this
    console.log("111")
    wx: wx.request({
      url: 'http://localhost:8080/caculator/Target',
      data: {
        openid: this.data.openid,
        target:this.data.target
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      responseType: 'text',
      success: function (res) {
        console.log(res)
        that.setData({
          res: res.data
        })

      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  target:function(e){
    this.setData({
      target:e.detail.value
    })
  }
});