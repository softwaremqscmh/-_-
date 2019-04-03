var app = getApp()


Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: [{
      name: '男',
      value: '男',
      checked: 'true'
    },
    {
      name: '女',
      value: '女'
    }
    ],
    gender:'',
    grade:'',
    height: '',
    weight: '',
    capacity:'',
    run:'',
    pull:'',
    reach:'',
    jump:'',
    dash:'',
    showOrHidden:false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      item:this.data.items
    })
  },

  height:function(e){
    this.setData({
      height:e.detail.value
    })
  },

  weight: function (e) {
    this.setData({
      weight: e.detail.value
    })
  },

  capacity: function (e) {
    this.setData({
      capacity: e.detail.value
    })
  },

  run: function (e) {
    this.setData({
      run: e.detail.value
    })
  },

  pull: function (e) {
    this.setData({
      pull: e.detail.value
    })
  },

  reach: function (e) {
    this.setData({
      reach: e.detail.value
    })
  },

  jump: function (e) {
    this.setData({
      jump: e.detail.value
    })
  },

  dash: function (e) {
    this.setData({
      dash: e.detail.value
    })
  },

  gender:function(e){
    this.setData({
      gender:e.detail.value
    })
  },

  grade: function (e) {
    this.setData({
      grade: e.detail.value
    })
  },

  count:function(){
    wx: wx.request({
      url: 'http://localhost:8080/caculator/Exercise',
      data: {
        gender:this.data.gender,
        grade:this.data.grade,
        height:this.data.height,
        weight:this.data.weight,
        capacity:this.data.capacity,
        run:this.data.run,
        reach:this.data.reach,
        jump:this.data.jump,
        pull:this.data.pull,
        dash:this.data.dash
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      responseType: 'text',
      success: function (res) {
        console.log(res)
        app.globalData.score = res.data.score
        app.globalData.remain = res.data.remain
        app.globalData.bmi = res.data.bmi
        console.log(app.globalData.result)
        wx.navigateTo({
          url: '../count/count',
        })
      },
      fail: function (res) { 
        this.showOrHidden = true
      },
      complete: function (res) { },
    })

    wx:wx.navigateTo({
      url: '../count/count',
      success: function(res) {
      },
      fail: function(res) {},
      complete: function(res) {},
    })
  }
})