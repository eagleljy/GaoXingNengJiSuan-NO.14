function commonPirOptions (title) {
    return {
        backgroundColor: '#F5F7F9',

        title: {
            text: title,
            left: 'center',
            top: 20,
            textStyle: {
                color: '#000'
            }
        },

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series: [
            {
                name: title,
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [],
                roseType:
                    'radius',
                label:
                    {
                        normal: {
                            textStyle: {
                                color: 'rgba(0, 0, 0, 0.3)'
                            }
                        }
                    }
                ,
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(0, 0, 0, 0.3)'
                        }
                        ,
                        smooth: 0.2,
                        length:
                            10,
                        length2:
                            20
                    }
                }
                ,
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur:
                            200,
                        shadowColor:
                            'rgba(0, 0, 0, 0.3)'
                    }
                }
                ,

                animationType: 'scale',
                animationEasing:
                    'elasticOut',
                animationDelay:

                    function (idx) {
                        return Math.random() * 200
                    }
            }
        ]
    }
}
