<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>공지사항</title>
    <script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css">
    <style>
        table.type10 {
            border-collapse: collapse;
            text-align: left;
            line-height: 1.5;
            border-top: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
            margin: 20px 10px;
        }

        table.type10 thead th {
            width: 150px;
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            color: #fff;
            background: #ff666f;
            margin: 20px 10px;
        }

        table.type10 tbody th {
            width: 150px;
            padding: 10px;
        }

        table.type10 td {
            width: 350px;
            padding: 10px;
            vertical-align: top;
        }

        table.type10 .even {
            background: #fdf3f5;
        }
        .table-striped>tbody>tr:nth-of-type(even){
        background-color:white !important;
        }
        .table-striped>tbody>tr:nth-of-type(odd){
        background-color:white !important;
        }
        .table-striped>tbody>tr:hover{
        background-color:#7a7777 !important;
        }
    </style>
</head>

            
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>


<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/headerUtil.jsp" %>
<br /><br /><br /><br /><br />


    <h1 class="text-center" style="color: white;">공지사항</h1>
    <hr>
    <p>&nbsp;</p>
<div class="container">
    <table class="table table-striped type10 table-hover" id="listArea">
        <thead>
            <tr>
                <th>작성일</th>
                <th>제목</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="notice" items="${list}">
         <tr>
         
            <input type="hidden" value="${notice.bno}">
             
            
            
            <td>${notice.nDate}</td>
            <td>${notice.nTitle}</td>
            <td>${notice.nCount}</td>
        </tr>
         </c:forEach>
        </tbody>
    </table>
    <hr>
    <a class="btn btn-default pull-right" style="background: #ff666f; border: #ff666f; color: snow;" href="${pageContext.request.contextPath}/views/notice/noticeInsertForm.jsp">글쓰기</a>

    <div class="pagingArea" align="center">
      		<c:url var="selectList" value="selectList.no"/>
      		
      		<!-- 처음 페이지 버튼 -->	
      		<button onclick="location.href='${selectList}?currentPage=1'">
      			&lt;&lt;
      		</button>
      		
      		<!-- 이전 페이지 버튼 -->
      		<c:if test="${ pi.currentPage le 1 }">
      			<button disabled>&lt;</button>
      		</c:if><c:if test="${ pi.currentPage gt 1 }">
      			<button onclick="location.href='${selectList}?currentPage=${pi.currentPage - 1}'">
      				&lt;
      			</button>
      		</c:if>
      		
      		<!-- 상세 페이지 구현을 위한 반복문 -->
      		<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
      			<c:if test="${ p eq pi.currentPage }">
      				<button disabled>
      				<b>${p}</b>
      				</button>
      			</c:if>
      			<c:if test="${ p ne pi.currentPage }">
      				<button onclick="location.href='${selectList}?currentPage=${p}'"> 
      					${p}
      				</button>
      			</c:if>
      		
      		</c:forEach>
      		
      		
      		
      		<!-- 다음 페이지 버튼 -->
      		<c:if test="${ pi.currentPage ge pi.maxPage }">
      			<button disabled>&gt;</button>
      		</c:if><c:if test="${ pi.currentPage lt pi.maxPage }">
      			<button onclick="location.href='${selectList}?currentPage=${pi.currentPage + 1}'">
      				&gt;
      			</button>
      		</c:if>
      		
      		<!-- 마지막 페이지 버튼 -->	
      		<button onclick="location.href='${selectList}?currentPage=${pi.maxPage}'">
      			&gt;&gt;
      		</button>
      		
      		
      </div>
</div>
<script>
	$(function(){
        $("#listArea td").click(function(){
           var bno = $(this).parent().find("input").val();
           location.href="${pageContext.request.contextPath}/selectOne.no?bno=" + bno;
        });
     });
	</script>
<br /><br /><br /><br /><br />
<br />


<%@ include file="../common/footer.jsp" %>
<%@ include file="../common/footerUtil.jsp" %>
</body>

</html>