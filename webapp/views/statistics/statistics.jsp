<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통계 게시판</title>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>

<style>

.Xcontent {
    min-height: calc(150vh - 20px);
}

body {
	margin: 0;
	width: 100%;
	height: 100vh;
	background: linear-gradient(-45deg, #B4455B, #D8BAEA, #F5ABBB, #80002F) center fixed;
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@keyframes gradientBG {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

#container {
	margin: 50px;
	font-family: 'Quicksand', sans-serif;
	font-size: 19px;
}

.cards {
	margin-left: 14%; 
}

.card {
	width: 300px;
	display: inline-block;
	background: white;
	padding: 30px;
	border-radius: 10px;
	margin: 10px;
	box-shadow: 0px 5px 0px 0px lightblue;
}

.badges {
	margin-top: 20px;
	text-align: center;
}

.timestamp {
	background: aliceblue;
	padding: 5px 15px;
	border-radius: 100px;
	font-size: 90%;
}

.content {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 18; /* 라인수 */
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	max-height: 21.6em;
	/* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
}

</style>
<link href="https://fonts.googleapis.com/css?family=Quicksand:500"
	rel="stylesheet">
<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<!-- 차트 전용 JS -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/stat.css">
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/headerUtil.jsp"%>


<div class="Xcontent">
	<div id="container">
		
		<div align="center">
			<h1 style="font-family: 궁서; font-size: 26px;"> 유정훈(Daniel Yu)선생님 작품 </h1>
		</div>

		<br />
		<br />
		<div id="chart1" style="width:100%; height:400px;"></div>
		<br>
		<div id="chart2" style="width:100%; height:400px;"></div>
		<br>
		<div id="chart3" style="width:100%; height:400px;"></div>
		<br><br><br>
		
	</div>
	
	<script>
	$(function(){
		
		$.ajax({
			url : '${pageContext.request.contextPath}/selectList.stat', 
			type: 'get',
			success : function(data){
				console.log(data);
				
				Highcharts.chart('chart1', {
				    chart: {
				        plotBackgroundColor: null,
				        plotBorderWidth: 0,
				        plotShadow: false
				    },
				    title: {
				        text: '사이트<br>이용자 성비<br>total',
				        align: 'center',
				        verticalAlign: 'middle',
				        y: 60
				    },
				    tooltip: {
				        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				    },
				    accessibility: {
				        point: {
				            valueSuffix: '%'
				        }
				    },
				    plotOptions: {
				        pie: {
				            dataLabels: {
				                enabled: true,
				                distance: -50,
				                style: {
				                    fontWeight: 'bold',
				                    color: 'white'
				                }
				            },
				            startAngle: -90,
				            endAngle: 90,
				            center: ['50%', '75%'],
				            size: '110%'
				        }
				    },
				    series: [{
				        type: 'pie',
				        name: 'user stat',
				        innerSize: '50%',
				        data: [
				            ['남성', parseFloat(data.gender[0][1])],
				            ['여성', parseFloat(data.gender[1][1])],
				        ]
				    }]
				});
				
				Highcharts.chart('chart2', {
				    chart: {
				        type: 'column'
				    },
				    title: {
				        text: '매 년 월 별 사이트 이용 통계'
				    },
				    subtitle: {
				        text: 'Source: FaceHair.com'
				    },
				    xAxis: {
				        categories: [
				            'Jan',
				            'Feb',
				            'Mar',
				            'Apr',
				            'May',
				            'Jun',
				            'Jul',
				            'Aug',
				            'Sep',
				            'Oct',
				            'Nov',
				            'Dec'
				        ],
				        crosshair: true
				    },
				    yAxis: {
				        min: 0,
				        title: {
				            text: '등록 게시글 (수)'
				        }
				    },
				    tooltip: {
				        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
				            '<td style="padding:0"><b>{point.y:.0f} 개</b></td></tr>',
				        footerFormat: '</table>',
				        shared: true,
				        useHTML: true
				    },
				    plotOptions: {
				        column: {
				            pointPadding: 0.2,
				            borderWidth: 0
				        }
				    },
				    series: [{
				        name: '스타일 공유',
				        data: data.board.slice(0,12)
			
				    }, {
				        name: '스타일 팁',
				        data: data.board.slice(13,24)
			
				    }, {
				        name: '수다방',
				        data: data.board.slice(25,36)
			
				    }]
				});

				Highcharts.chart('chart3', {
				    chart: {
				        type: 'spline'
				    },
				    title: {
				        text: '매년 평균 전체 게시글 등록 수'
				    },
				    subtitle: {
				        text: 'Source: facehair.com'
				    },
				    xAxis: {
				        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
				            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				    },
				    yAxis: {
				        title: {
				            text: '게시글 등록 수'
				        },
				        labels: {
				            formatter: function () {
				                return this.value;
				            }
				        }
				    },
				    tooltip: {
				        crosshairs: true,
				        shared: true
				    },
				    plotOptions: {
				        spline: {
				            marker: {
				                radius: 4,
				                lineColor: '#666666',
				                lineWidth: 1
				            }
				        }
				    },
				    series: [{
				        name: '게시글 평균 등록 수',
				        marker: {
				            symbol: 'square'
				        },
				        data: data.avg
				    }]
				});
			}, error : function(){
				
			}			
		});
	});
	</script>
	
	<br />
</div>
	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>

</body>
</html>