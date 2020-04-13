<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신고 글 작성 페이지</title>

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
        table {
            background : white;
        }
        #reportPageBtn {
   	 	background-color: #ff666f;
    	border-color: #ff666f;
    	color: black; }
    	
    	#reportPageBtndiv {
    		align:center;
    	}
    	
    	.reportPagedivClass {
    		background : #ff666f;
            border:#ff666f;
            color : black;
            padding : 10px;
    	}
    	#dateDivForm {
    		background : white;
    		padding : 5px;
    		color : black;
    		padding-left : 15px;
    	}
    	textarea {
    		resize : none;
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
 
<br />
<section>
 
    <h2 class="text-center" style="color: white">신고 글 작성</h2>
    <hr>
    <fmt:requestEncoding value="UTF-8"/>
    <c:set var="current" value="<%= new java.util.Date() %>"/>
    <li>오늘 날짜 : <fmt:formatDate value="${current}"/></li>
    

	<div class="container">
        <br style="clear:both">
            <div class="form-group col-md-12 ">                                
                <form action="${pageContext.request.contextPath }/insertReport.do">
                <div class="reportPagedivClass">글 번호</div>
				<input type="hidden" name="bno" value="${ talk.bno }" />
				<div id="dateDivForm">${ talk.bno }</div>
				<br />
                <div class="reportPagedivClass">날짜</div>
				<div id="dateDivForm"><fmt:formatDate value="${current}"/>
				</div>
				<br />
                <div class="reportPagedivClass">신고 내용</div>
                <textarea class="form-control input-sm " type="textarea" name="repcon" placeholder="내용을 입력하세요" maxlength="3000" rows="7"></textarea>
   			<button type="submit" class="btn btn-primary" id="reportPageBtn" style='background-color: #ff666f
    		border-color: #ff666f
    		color: #FFF '>제출하기</button>
    	</form>
    	</div>
</div>

    <script>
        
    </script>
<br />
<br />
<br />
<br />
<br />
   <%@ include file="../common/footer.jsp" %>
   <%@ include file="../common/footerUtil.jsp" %>
</body>
</html>