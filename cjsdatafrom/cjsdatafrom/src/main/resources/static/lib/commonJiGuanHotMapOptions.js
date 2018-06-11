function commonJiGuanMapOptions () {
    var UnitGeo = [[108.648277,21.973679,1], [116.347313,39.981771,10], [114.173355,22.320047,1], [116.310880,39.992810,50], [116.326759,40.003304,54], [116.715622,40.411160,6], [108.984598,34.246033,9], [121.529015,38.880379,5], [114.268623,22.334459,4], [116.358990,39.984304,1], [86.398926,37.771183,1], [118.779430,32.055015,19], [117.167299,39.103693,14], [114.356026,30.474377,5], [113.393740,22.527466,20], [121.394003,31.315989,2], [120.644403,31.303672,2], [119.198453,26.056812,3], [108.149384,30.653883,3], [114.026222,22.537685,3], [119.308138,26.034952,1], [123.410439,41.793594,1], [120.376091,31.482067,11], [118.857244,32.026884,3], [108.078491,34.272434,3], [108.904854,34.241802,9], [116.169473,39.727356,6], [104.085486,30.629794,9], [106.456879,29.541143,1], [114.434479,30.511049,18], [113.383772,22.524818,1], [116.347459,40.005875,2], [116.359072,39.990221,5], [123.411255,41.795269,1], [113.367149,23.110704,8], [116.503517,39.803913,1], [114.365248,30.537860,16], [116.348713,39.998089,2], [120.336266,36.061840,4], [121.390923,31.230452,10], [116.365772,39.961557,6], [114.384018,30.506981,1], [116.419853,39.972249,5], [116.346695,39.991074,5], [112.926247,28.174528,4], [117.108284,39.071904,1], [121.529205,31.304544,1], [113.987724,22.593590,2], [116.757576,39.588718,7], [117.175667,39.101806,1], [116.247681,40.218418,2], [107.104836,24.629082,1], [120.673859,31.323008,1], [118.102523,24.435954,8], [121.670288,31.276854,1], [126.621542,45.724084,1], [115.806623,28.666681,1], [108.927414,34.248524,5], [116.358103,39.961554,4], [121.425413,31.206075,18], [111.161201,24.795296,1], [120.195418,30.270760,28], [116.333580,39.988014,2], [118.820289,32.035021,3], [114.208725,22.415375,3], [114.184593,22.301607,1], [116.380180,40.003597,2], [114.336666,30.376437,1], [117.138371,36.666552,6], [120.202304,30.256360,1], [121.210938,31.059938,3], [115.867828,28.745691,1], [116.309749,39.996025,1], [120.568047,31.300606,5], [104.147257,30.674912,1], [116.186398,28.486009,1], [112.443680,39.374947,1], [121.210861,31.288713,7], [103.725305,36.106754,1], [125.322187,43.873607,16], [103.445503,29.575670,6], [103.856071,36.048653,3], [113.316177,23.120075,15], [113.360382,23.167627,2], [116.323341,39.924248,2], [126.632461,45.743237,14], [118.611369,32.062679,1], [114.114540,22.429071,1], [118.768589,32.052786,1], [121.498718,31.336472,31], [116.377182,39.950947,2], [108.966933,34.237085,1], [106.468822,29.564916,3], [112.944703,28.178119,6], [108.375046,30.790291,5], [106.672804,26.444340,1], [116.432205,39.909214,1], [118.747472,32.020332,1], [116.361839,39.988369,1], [117.170383,39.110144,9], [121.454504,31.213507,1], [99.949417,32.261948,1], [121.518044,31.211321,1], [113.347717,23.128052,3], [107.228500,24.312637,1], [118.816814,32.078689,1], [121.899288,30.878786,1], [118.956947,32.112366,1], [125.326599,43.841724,1], [107.358475,32.014805,1], [114.352786,30.523933,3], [108.959464,34.233499,1], [113.000954,28.229031,2], [117.184323,39.107393,4], [108.291451,22.841658,2], [121.529038,38.869782,1], [122.049721,37.207397,1], [117.820328,30.958990,1], [116.325768,39.748175,1], [116.447594,39.872643,1], [125.330933,43.895599,1], [113.936239,22.533883,1], [117.200020,34.221153,4], [118.814559,32.070412,1], [103.602356,28.990128,1], [120.396751,30.313467,1], [113.256112,23.134057,1], [126.726219,45.743717,2], [120.394204,30.315728,1], [123.419479,41.767193,6], [108.916752,34.230859,4], [112.588142,37.800370,2], [117.296095,31.843676,1], [117.384293,27.105503,1], [123.515950,41.743230,1], [117.278442,39.061219,1], [116.417236,39.902832,1], [116.337021,39.977165,1], [121.303574,31.429585,1], [108.952560,34.204798,2], [119.539719,39.904507,1], [116.415770,39.912757,1], [116.414775,39.910965,2], [109.472878,29.151451,1], [106.508988,29.533308,1], [87.624429,43.766321,1], [116.414841,39.911060,1], [125.326035,43.841141,1], [116.342802,39.952291,1], [116.556587,39.912792,1], [114.400065,30.528835,2], [119.980309,31.818939,1], [112.863096,27.882942,2], [116.348923,39.991346,2], [102.714674,25.079329,1], [101.749439,36.728139,1], [91.147145,29.643496,1], [121.525115,31.312298,1], [106.571034,29.488869,1], [118.738270,32.063940,2], [102.702151,25.054071,1], [121.500808,31.306607,1], [106.419098,29.820271,1], [118.840445,32.030033,1], [117.255736,31.844926,1], [113.518066,23.354553,1]];
    return {
        title: {
            // text: '部分长江学者籍贯分布图',
            subtext: 'Data from Team 10（Github Link）',
            sublink: 'https://github.com/iamweixiaohang/CJSDatafromTeam10',
            left: 'center',
        },
        tooltip : {
            trigger: 'item',
            formatter: function (params) {

                var a = params.value.toString().split(",");

                return ('经纬度：(' + a[0] +'，' + a[1] +')\n 人数：'+ a[2])
            }
        },
        backgroundColor: '#ffffff',
        visualMap: [{
            min: 0,
            max: 10,
            inRange: {
                color: ['#000000', '#0000FF', '#00ffff', '#00ff00', '#ffff00', '#ff0000']
            },
            text: ['>10', '1'],
            textStyle: {
                color: '#000',
                fontSize:20
            },
            bottom: 50,
            left:50
        }],
        bmap: {
            center: [103.914129, 33.250339],
            zoom: 5.0,//5.5,
            roam: true,
            mapStyle: {
                styleJson: [{
                    'featureType': 'water',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'land',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#f3f3f3'
                    }
                }, {
                    'featureType': 'railway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#fdfdfd'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry.fill',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'poi',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'green',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'subway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'manmade',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'local',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'boundary',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'building',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'label',
                    'elementType': 'labels.text.fill',
                    'stylers': {
                        'color': '#999999'
                    }
                }]
            }
        },
        series: [{
            name: 'AI',
            type: 'heatmap',
            coordinateSystem: 'bmap',
            data: UnitGeo
        },
            {
                name: '人数',
                type: 'scatter',
                coordinateSystem: 'bmap',
                data: UnitGeo,
                symbolSize: function (a,b) {
                    var c = a[2];
                    if(c<4)
                        c/=0.2;
                    else if(c<20)
                        c=20;

                    if(c>25)
                        c=25;
                    return c;
                },
                itemStyle: {
                    normal: {
                        color: '#00ff00'
                    }
                }
            }]
    };
}
