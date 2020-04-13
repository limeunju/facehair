<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 신고 게시물 조회</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <style>
    @import url(https://fonts.googleapis.com/css?family=Roboto:300);


    .adminaPageNavul {
        list-style-type:none;
        height : 40px;
        padding : 0;
		position : relative;
		margin-left : 38%

    }
    .adminaPageNavul li {
        float: left;
        position: relative;
        padding : 0;
        line-height : 40px;
        background :  pink;
    }
    .adminaPageNavul li a:hover {
        color : white;
    
    }
    .adminaPageNavul li a:active {
        background : #ff666f;
    }
    .adminaPageNavul li a {
        display : block;
        font-weight : 600;
        font-size : 14px;
        padding : 10px 30px;
        color :  #ff666f;
        text-decoration: none;
    }

    .adminaPageNavul {
        transition: all 0.2s;
        -webkit-transition: all 0.2s;
        -moz-transition : all 0.2s;
        -o-transition : all 0.2s;
    }
        #btnup{
            background: #ff666f;
            border:#ff666f;
        }
        #btnde{
            background: #ff666f;
            border:#ff666f;
        }
        #btnli{
            background: #ff666f;
            border:#ff666f;
        }
        
    </style>
</head>
<body style="background: pink;">
 <%@ include file="../common/header.jsp" %>
 <%@ include file="../common/headerUtil.jsp" %>
 <br />
 <br />
 <br />
 <br />
 <br />
    <div class="adminpageNav">
    <ul class="adminaPageNavul">
    <li><a href="selectBoardReportList.do"># 게시글 신고 목록</a></li>
    <li><a href="selectCommentReportList.do"># 댓글 신고 목록</a></li>
    <li><a href="adminSelectQnaList.do"># QnA 목록</a></li>
    </ul>
</div>
<br />
    <div class="row">
        <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
            <h2 class="text-center" style="color: white">댓글신고 상세 조회</h2>
            <hr>
            <p>&nbsp;</p>
            <div class="table table-responsive" style="overflow-x:hidden;">
                <table class="table">
                    <tr>
                        <th width= "200px" class="success" style="text-align: center; background: #ff666f;">댓글 신고 번호</th>
                        <td style="text-align: center;">${creport.crepno}</td>
                    </tr>

                    <tr>
                        <th class="success" style="text-align: center; background: #ff666f;">댓글 번호</th>
                        <td style="text-align: center;">${creport.cno}</td>
                    </tr>
					<tr>
                        <th class="success" style="text-align: center; background: #ff666f;">작성자</th>
                        <td style="text-align: center;">${creport.writer}</td>
					</tr>
					<tr>
						<th class="success" style="text-align: center; background : #ff666f;">작성일</th>
						<td style="text-align: center;">${creport.crepdate}</td>
					</tr>
                    <tr>
                        <th height = "300px" class="success"
                         style=" text-align : center; background: #ff666f; padding-top:20px;">신고 내용</th>
                        <td colspan="3" style="text-align: center;">${creport.crepcon}</td>
                    </tr>
      
                </table>
            </div>
	<button id="listbtn" onclick="golist();">목록으로</button>
	<script>
		function golist(){
				location.href="${pageContext.request.contextPath}/selectCommentReportList.do"
		};
	</script>
   <%@ include file="../common/footer.jsp" %>
   <%@ include file="../common/footerUtil.jsp" %>
</body>
</html>