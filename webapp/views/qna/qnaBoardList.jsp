<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>관리자 페이지</title>
   
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
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            color: #fff;
            background: #ff666f;
            margin: 20px 10px;
        }

		.creportnum1 {
			width: 100px;
		}

        table.type10 tbody th {
            width: 150px;
            padding : 10px;
        }

   
        
        table {
        	background : white;
        }
        
    </style>
</head>

<body style="background: pink;">
 <%@ include file="../common/header.jsp" %>
 <%@ include file="../common/headerUtil.jsp" %>
 <br /><br /><br /><br /><br />
 
    <h1 class="text-center" style="color: white;">QnA 목록</h1>
    <hr>
    <p>&nbsp;</p>
<div class="container">
    <table class="table table-striped type10 table-hover" id="listArea">
        <thead>
            <tr>
           		<th style="text-align:center" class="creportnum1">번호</th>
                <th style="text-align:center" class="creportnum1">작성자</th>
                <th style="text-align:center">제목</th>
                <th style="text-align:center" class="creportnum1">조회수</th>
                <th style="text-align:center">날짜</th>
                
            </tr>
        </thead>
         
        <c:forEach var="qna" items="${list}">
			<tr>
				<td style="text-align:center">
			<input type="hidden" value="${qna.qno}">
			${qna.qno}
			</td>
				<td style="text-align:center">${qna.writer}</td>
				<td style="text-align:center">${qna.qtitle}</td>
				<td style="text-align:center">${qna.qcount}</td>
				<td style="text-align:center">${qna.qdate}</td>
			</tr>
		</c:forEach>
    </table>
    <hr>
    <a class="btn btn-default pull-right" style="background: #ff666f; border: #ff666f; color: snow;" href="${pageContext.request.contextPath}/views/qna/qnaInsertForm.jsp">글쓰기</a>
    </div>
		
		<%-- 페이지 처리 구현하기 --%>
		<div class="pagingArea" align="center">
			<c:url var="selectlist" value="selectList.qn"/>
			
			<!-- 처음 페이지 버튼 -->
			<button onclick="location.href='${selectlist}?currentPage=1'">
				&lt;&lt;
			</button>
			
			<!-- 이전 페이지 버튼 -->
			<c:if test="${ pi.currentPage le 1 }">
				<button disabled>&lt;</button>
			</c:if>
			<c:if test="${ pi.currentPage gt 1 }">
				<button onclick="location.href='${selectlist}?currentPage=${pi.currentPage - 1}'">
					&lt;
				</button>
			</c:if>
			
			<!-- 상세 페이지 구현을 위한 반복문 -->
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage}">
				<c:if test="${p eq pi.currentPage }">
					<button disabled>
						<b>${p}</b>
					</button>
				</c:if>
				<c:if test="${ p ne pi.currentPage}">
					<button onclick="location.href='${selectlist}?currentPage=${p}'">
						${p}
					</button>
				</c:if>
			</c:forEach>
			
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${ pi.currentPage ge pi.maxPage }">
				<button disabled>&gt;</button>
			</c:if>
			<c:if test="${ pi.currentPage lt pi.maxPage }">
				<button onclick="location.href='${selectlist}?currentPage=${pi.currentPage + 1}'">
					&gt;
				</button>
			</c:if>
			
			<!-- 마지막 페이지 버튼 -->
			<button onclick="location.href='${selectlist}?currentPage=${pi.maxPage}'">
				&gt;&gt;
			</button>
		</div>
    

<script>
	$(function(){
		$("#listArea td").click(function(){
			var qno = $(this).parent().find("input").val();
			location.href="${pageContext.request.contextPath}/selectOne.qn?qno=" + qno;
		});
	});
</script>

<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />
<br /><br />

 <%@ include file="../common/footer.jsp" %>
 <%@ include file="../common/footerUtil.jsp" %>
   
</body>
</html>