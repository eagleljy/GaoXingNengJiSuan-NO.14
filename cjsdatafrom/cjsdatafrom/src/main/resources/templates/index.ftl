<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>iview example</title>
    <link rel="stylesheet" type="text/css" href="/lib/iview.css">
    <script type="text/javascript" src="lib/vue.min.js"></script>
    <script type="text/javascript" src="lib/iview.min.js"></script>
    <script type="text/javascript" src="lib/commonPieOptions.js"></script>
    <script type="text/javascript" src="lib/commonTrendOptions.js"></script>
    <script src="lib/axios.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript"
            src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
    <script type="text/javascript"
            src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>

</head>
<body>
<div id="app">
    <div class="layout">
        <Upload
                multiple
                type="drag"
                formate="xlsx"
                :on-format-error="handleFormatError"
                :on-success="handleSuccess"
                action="/upload">
            <div style="padding: 20px 0">
                <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                <p>点击或者直接拖动待分析到此</p>
            </div>
        </Upload>
        <Layout>
            <Content :style="{margin: '50px 0',padding: '0 50px'}">
                <i-row>
                    <i-col span="10" offset="1">
                        <Card>
                            <p slot="title">
                                <Icon type="ios-pie"></Icon>
                                年龄分布图
                            </p>
                            <div class="demo-spin-container">
                                <Spin v-if="ageGeomData.length==0" fix size="large"></Spin>
                                <div id="ageGeom" style="min-height: 500px"></div>
                            </div>
                        </Card>
                    </i-col>
                    <i-col span="10" offset="2">
                        <Card>
                            <p slot="title">
                                <Icon type="ios-pie"></Icon>
                                专业领域分布
                            </p>
                            <div class="demo-spin-container">
                                <Spin v-if="majorGeomData.length==0" fix size="large"></Spin>
                                <div id="majorGeom" style="min-height: 500px"></div>
                            </div>
                        </Card>
                    </i-col>
                </i-row>
                <i-row>
                    <i-col span="10" offset="1">
                        <Card style="margin-top: 30px">
                            <p slot="title">
                                <Icon type="ios-pie"></Icon>
                                信息完善度比例
                            </p>
                            <div class="demo-spin-container">
                                <Spin v-if="infoGeomData.length==0" fix size="large"></Spin>
                                <div id="infoGeom" style="min-height: 500px"></div>
                            </div>
                        </Card>
                    </i-col>
                    <i-col span="10" offset="2">
                        <Card style="margin-top: 30px">
                            <p slot="title">
                                <Icon type="ios-pie"></Icon>
                                获得称号年趋势变化
                            </p>
                            <div class="demo-spin-container">
                                <Spin v-if="trendData.length==0" fix size="large"></Spin>
                                <div id="trend" style="min-height: 500px"></div>
                            </div>
                        </Card>
                    </i-col>
                </i-row>
            </Content>
        </Layout>

        <Layout>
            <Content :style="{margin: '50px 0',padding: '0 50px'}">
                <i-row>

                </i-row>
            </Content>
            <Footer class="layout-footer-center">卢俊宇[lujunyu@sinosoft.com.cn]</Footer>
        </Layout>
    </div>
</div>
</body>
<script>
    var ageGeom = null
    var majorGeom = null
    var infoGeom = null
    var trend = null
    new Vue({
        el: '#app',
        data: {
            visible: false,
            ageGeomData: [],
            majorGeomData: [],
            infoGeomData: [],
            trendData: []
        },
        methods: {
            show: function () {
                this.visible = true
            },
            handleFormatError (file) {
                this.$Notice.warning({
                    title: '文件类型不正确',
                    desc: '您上传的文件 ' + file.name + ' 是不正确的，请上传2007版本以上的EXCEL'
                })
            },
            handleSuccess (res, file) {
                var _this = this
                setTimeout(function () {
                    _this.initAgeGeom()
                    _this.getAgeGeomData()
                }, 1000)
                setTimeout(function () {
                    _this.initMajorGeom()
                    _this.getMajorGeomData()
                }, 1500)
                setTimeout(function () {
                    _this.initInfoGeom()
                    _this.getInfoGeomData()
                }, 2000)
                setTimeout(function () {
                    _this.initTrend()
                    _this.getTrendData()
                }, 2000)
            },
            getAgeGeomData: function () {
                var _this = this
                axios.post('/ageGeomResult', {}).then(function (response) {
                    if (response.data.code === "CPYY-00001") {
                        ageGeomResult = JSON.parse(response.data.data)
                        _this.ageGeomData.push({})
                        _this.ageGeomData = ageGeomResult
                        _this.updateAgeGeom(ageGeomResult)
                    }
                }).catch(function (response) {
                    this.$Notice.warning({
                        title: '获取年龄分布异常',
                        desc: '异常码:' + response.code
                    })
                })
            },
            initAgeGeom: function () {
                var dom = document.getElementById("ageGeom")
                ageGeom = echarts.init(dom)
                option = commonPirOptions()
                if (option && typeof option === "object") {
                    ageGeom.setOption(option, true)
                }
            },
            updateAgeGeom: function (data) {
                option = commonPirOptions("年龄分布")
                option.series[0].data = data
                ageGeom.setOption(option, true)
            },
            getMajorGeomData: function () {
                var _this = this
                axios.post('/majorGeomResult', {}).then(function (response) {
                    if (response.data.code === "CPYY-00001") {
                        majorGeomData = JSON.parse(response.data.data)
                        _this.majorGeomData.push({})
                        _this.majorGeomData = majorGeomData
                        _this.updateMajorGeom(majorGeomData)
                    }
                }).catch(function (response) {
                    this.$Notice.warning({
                        title: '获取专业分布异常',
                        desc: '异常码:' + response.code
                    })
                })
            },
            initMajorGeom: function () {
                var dom = document.getElementById("majorGeom")
                majorGeom = echarts.init(dom)
                option = commonPirOptions()
                if (option && typeof option === "object") {
                    majorGeom.setOption(option, true)
                }
            },
            updateMajorGeom: function (data) {
                option = commonPirOptions("专业分布")
                option.series[0].data = data
                majorGeom.setOption(option, true)
            },
            getInfoGeomData: function () {
                this.infoGeomData = [{value: 335, name: '直接访问'},
                    {value: 310, name: '邮件营销'},
                    {value: 274, name: '联盟广告'},
                    {value: 235, name: '视频广告'},
                    {value: 400, name: '搜索引擎'}]
                this.updateInfoGeom(this.infoGeomData)
            },
            initInfoGeom: function () {
                var dom = document.getElementById("infoGeom")
                infoGeom = echarts.init(dom)
                option = commonPirOptions()
                if (option && typeof option === "object") {
                    infoGeom.setOption(option, true)
                }
            },
            updateInfoGeom: function (data) {
                option = commonPirOptions("信息完善度")
                option.series[0].data = data
                infoGeom.setOption(option, true)
            },
            getTrendData: function () {
                var _this = this
                axios.post('/trendDataResult', {}).then(function (response) {
                    if (response.data.code === "CPYY-00001") {
                        trendData = response.data.data
                        _this.trendData.push({})
                        _this.updateTrend(trendData)
                    }
                }).catch(function (response) {
                    _this.$Notice.warning({
                        title: '获取分布异常',
                        desc: '异常码:' + response.code +response.message
                    })
                })
            },
            initTrend: function () {
                var dom = document.getElementById("trend")
                trend = echarts.init(dom)
                option = commonTrendOptions()
                if (option && typeof option === "object") {
                    trend.setOption(option, true)
                }
            },
            updateTrend: function (data) {
                var len = data.length
                var xAxisData = []
                var yAxisData = []
                for (var i = 0; i < len; i++) {
                    xAxisData.push(data[i].year)
                    yAxisData.push(data[i].num)
                }
                option = commonTrendOptions(xAxisData, yAxisData)
                trend.setOption(option, true)
            }
        },
        mounted: function () {

        }
    })
</script>
<style>
    .layout-footer-center {
        text-align: center;
    }
    .demo-spin-container {
        display: inline-block;
        width: 100%;
        position: relative;
        min-height: 500px
    }
</style>
<script type="text/javascript">
</script>
</html>
