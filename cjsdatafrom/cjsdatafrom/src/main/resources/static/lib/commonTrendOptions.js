function commonTrendOptions (xAxisData,data) {
    return {
        xAxis: {
            type: 'category',
            data: xAxisData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: data,
            type: 'line'
        }]
    }
}
