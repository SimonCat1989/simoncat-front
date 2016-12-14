var stategrid = stategrid || {};
stategrid.cabletopoloy = stategrid.cabletopoloy || {};
stategrid.cabletopoloy.map = {
	cachedChart: undefined,
		
	init : function() {
		stategrid.cabletopoloy.map.cachedChart = stategrid.cabletopoloy.map.cachedChart || require('echarts').init(document.getElementById('cable_toplogy_container'));
		stategrid.cabletopoloy.map.cachedChart.setOption(stategrid.cabletopoloy.map.option);
	},

	option : {
		backgroundColor: '#1b1b1b',
		color: ['gold','aqua','lime'],
		title : {
			text : '国家电网上海市光纤拓扑图',
			x : 'center',
			textStyle : {
	            color: '#fff'
	        }
		},
		tooltip : {
			show: true,
			position: function(pos) {
				return [pos[0] - 50, pos[1] - 30];
			},
			formatter: '{b}',
			textStyle: {
            	fontSize: 18,
            	fontWeight: 'bolder'
            }
		},
		legend : {
			show : false,
			orient : 'vertical',
			x : 'left',
			data : [ 'route' ]
		},
		dataRange : {
			show : false,
			min : 0,
			max : 1,
			color: ['red','orange'],
	        textStyle:{
	            color:'#fff'
	        }
		},
		toolbox : {
			show : false,
			orient : 'vertical',
			itemSize : 22,
			padding : 10,
			x : 'left',
			y : 'top',
			feature : {
				mark : {
					show : false
				},
				dataView : {
					show : false,
					readOnly : false,
					optionToConten : function() {

					},
					optionToConten : function() {

					}
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		roamController : {
			show : true,
			x : 'right',
			width : 80,
			height : 120,
			mapTypeControl : {
				'上海' : true
			}
		},
		series : [ {
			name : 'route',
			type : 'map',
			mapType : '上海',
			roam : true,
			clickable : false,
			tooltip : {
				show : true
			},
			hoverable : false,
			 itemStyle:{
	                normal:{
	                    borderColor:'rgba(100,149,237,1)',
	                    borderWidth:0.5,
	                    areaStyle:{
	                        color: '#1b1b1b'
	                    }
	                }
	            },
			data : [],
			markPoint : {
                symbolSize: 7,
                itemStyle: {
                    normal: {
                        borderColor: '#87cefa',
                        borderWidth: 1,
                        label: {
                        	show: false
                        }
                    },
                    emphasis: {
                        borderColor: '#1e90ff',
                        borderWidth: 3,
                        label: {
                            show: false
                        },
                    }
                },
                data : []
			},
			geoCoord: {},
			markLine : {
				smooth:true,
				symbol: ['none', 'circle'],  
                symbolSize : 1,
                itemStyle : {
                    normal: {
                        color:'#fff',
                        borderWidth:3,
                        borderColor:'rgba(30,144,255,0.5)'
                    }
                },
                data : []
			}
		}, {
            name: 'seleted',
            type: 'map',
            mapType: '上海',
            data:[],
            markPoint : {
                symbol:'emptyCircle',
                symbolSize : function (v){
                    return 10 + v/100
                },
                effect : {
                    show: true,
                    shadowBlur : 0,
                    color: 'red',
                    shadowColor: 'red',
                },
                itemStyle:{
                	color: 'red',
                    normal:{
                        label:{
                        	show: false,
                        	formatter: '{b}',
                        	textStyle: {
                        		color: '#fff',
                        		fontSize: 18,
                            	fontWeight: 'bolder'
                        	}
                        }
                    }
                },
                data : []
            },
            markLine : {
                smooth:true,
                smoothness: 0,
                effect : {
                    show: true,
                    scaleSize: 1,
                    period: 30,
                    color: '#fff',
                    shadowBlur: 10
                },
                itemStyle : {
                    normal: {
                    	color: 'red',
                        borderWidth:1,
                        lineStyle: {
                            type: 'solid',
                            shadowBlur: 10
                        },
                        label: {
                        	show: false,
                        	formatter: function(params){
                        		return params.name.replace(':','→');
                        	},
                        	textStyle: {
                        		color: '#fff',
                        		fontSize: 18,
                            	fontWeight: 'bolder'
                        	}
                        },
                        borderWidth:3
                    }
                },
                data : []
            }
        } ]
	},
	
	selectRoute: function(routeArray) {
		var markPointData = stategrid.cabletopoloy.map.option.series[1].markPoint.data = [];
		var markLineData = stategrid.cabletopoloy.map.option.series[1].markLine.data = [];
		for (var i = 0; i< routeArray.length; i++) {
			var startName = routeArray[i].start.name;
			var endName = routeArray[i].next.name;
			markPointData.push({name:startName, value:1});
			markLineData.push([{name:startName},{name:endName}]);
		}
		markPointData.push({name:routeArray[routeArray.length - 1].next.name, value:1});
		stategrid.cabletopoloy.map.init();
	}
};

$(document).ready(
		function() {
			require.config({
				paths : {
					echarts : 'lib/echarts'
				}
			});
			require([ 'echarts', 'echarts/chart/map' ], function(ec) {
				stategrid.cabletopoloy.map.init();
			});
			
			$.get("./index/loadGeo.do", {}, function(data) {
				if (data && data.geo && data.geo.length > 0 && data.route && data.route.length > 0) {
					var geoArray = data.geo;
					var routeArray = data.route;
					for (var i = 0; i < geoArray.length; i++) {
						stategrid.cabletopoloy.map.option.series[0].markPoint.data.push({name: geoArray[i].stationName, value: 0});
						stategrid.cabletopoloy.map.option.series[0].geoCoord[geoArray[i].stationName] = [geoArray[i].longitude, geoArray[i].latitude];
					}
					stategrid.cabletopoloy.map.init();
				}
			});
		});

function checkRoute(name, geoArray) {
	var found = false;
	for(var i = 0; i < geoArray.length; i++) {
		if(geoArray[i].name === name) {
			found = true;
			break;
		}
	}
	return found;
}
