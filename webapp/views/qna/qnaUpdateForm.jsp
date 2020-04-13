<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <style>
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
    <script src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
</head>

<body style="background: pink;">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/headerUtil.jsp" %>
<br /><br /><br /><br /><br />
    <div class="row">
        <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
            <h2 class="text-center" style="color: snow;">게시글 보기</h2>
            <hr>
            <p>&nbsp;</p>
            <div class="table table-responsive" style="overflow-x:hidden;">
            <form method="post" id="updateForm" action="update.qn">
                <table class="table">
                    <tr>
                        <th class="success" style="background: #ff666f;">글번호</th>
                        <td>${qna.qno}
                        <input type="hidden" name="bno" value="${ qna.qno }"/>
                        </td>
                        <th class="success" style="background: #ff666f;">조회수</th>
                        <td>${qna.qcount}</td>
                    </tr>


                    <tr>
                        <th class="success" style="background: #ff666f;">작성자</th>
                        <td>${qna.writer}</td>
                        <th class="success" style="background: #ff666f;">작성일</th>
                        <td>${qna.qdate}</td>
                    </tr>

                    <tr>
                        <th class="success" style="background: #ff666f;">제목</th>
                        <td colspan="3"><input type="text" class="form-control" 
                  		 name="title" value="${ qna.qtitle }"></td>
                    </tr>

                    <tr>
                        <th class="success" style="background: #ff666f;">글 내용</th>
                        <td colspan="3">
                        <textarea name="content" class="form-control" cols="52" rows="15" style="resize:none;">${qna.qcontent}</textarea></td>
                    </tr>

                    <tr align="center">
                        <td colspan="5" class="text-center">
                            <input type="submit" id="btnup" class="btn btn-warning" value="수정완료"
                                onclick="location.href='${pageContext.request.contextPath}/update.qn'">
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/selectList.qn'">
                        </td>
                    </tr>



                </table>
                <script>
                function completeUpdate(){
                	console.log("작동확인!");
            		$('#updateForm').attr("action", "${pageContext.request.contextPath}/update.qn");
            	}
                function deleteBoard(){
            		$('#updateForm').attr("action", "${pageContext.request.contextPath}/delete.qn");
            	}
            
                </script>
                </form>
            </div>

        </div>
    </div>
   <br /><br /><br /><br />


<%@ include file="../common/footer.jsp" %>
<%@ include file="../common/footerUtil.jsp" %> 
</body>

</html>