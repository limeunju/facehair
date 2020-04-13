<%@page import="com.kh.jsp.notice.model.vo.NoticeBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

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
</head>


<body style="background: pink;">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/headerUtil.jsp" %>
<br /><br /><br /><br /><br />

 		<c:url var="boardUpdate" value="qUpView.qn"> 
            <c:param name="qna" value="${qna.qno}" /> 
 		</c:url>
    <div class="row">
        <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
            <h2 class="text-center" style="color: snow;">QnA 게시글 보기</h2>
            <hr>
            <p>&nbsp;</p>
            <div class="replyArea table table-responsive" style="overflow-x:hidden;">
                <table class="table">
                    <tr>
                        <th class="success" style="background: #ff666f;" >글번호</th>
                        <td>${qna.qno}</td>
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
                        <td colspan="3">${qna.qtitle}</td>
                    </tr>

                    <tr>
                        <th class="success" style="background: #ff666f;">글 내용</th>
                        <td colspan="3">${qna.qcontent}</td>
                    </tr>
                
                    <tr align="center">
                        <td colspan="5" class="text-center">
                        <c:url var="boardUpdate" value="qUpView.qn">
               				<c:param name="qno" value="${qna.qno }" />
            			</c:url>
                            <input type="button" id="btnup" class="btn btn-warning" value="수정"
                                onclick="location.href='${boardUpdate}'">
                           
                        <c:url var="boardDelete" value="delete.qn">
               				<c:param name="qno" value="${qna.qno }" />
            			</c:url>
                            <input type="button" id="btnde" class="btn btn-danger" value="삭제"
                                onclick="deleteBtn();">
                            
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/selectList.qn'">
                        </td>
                    </tr>

				</table>
            </div>
            
            <div class="replyArea table table-responsive" style="background: white; padding: 10px; padding-bottom: 20px;">

				<div id="replySelectArea">
					<c:if test="${ !empty clist }">
						<c:forEach var="qno" items="${ clist }">
							
							
								<textarea class="reply-content form-control" readonly="readonly"
									style="resize: none;">${qno.qccontent}</textarea>
							

							<c:if test="${member.userNo eq qno.qcwriter }">

								<div
									style="float: right; margin: 5px; margin-top: 10px; margin-bottom: 10px;">

									<input type="hidden" name="qcno" value="${qno.qcno}" />

									<button type="button" class="btn" class="updateBtn"
										onclick="updateReply(this);" style="background: #ff666f;">수정</button>

									<button type="button" id="updateConfirm" class="btn"
										onclick="updateConfirm(this);"
										style="background: #ff666f; display: none;">수정완료</button>

									<button type="button" class="btn" onclick="deleteReply(this);"
										style="background: #ff666f;">삭제</button>

								</div>
							</c:if>

						</c:forEach>
					</c:if>
				</div>

				<div class="replyWriteArea" style="margin-top: 100px;">
                    <form action="${pageContext.request.contextPath }/insert.qco" method="post">
                        <input type="hidden" name="qwriter" value="${ member.userNo }" />
                        <input type="hidden" name="qccontent" value="${ qno.qccontent }" />
                        <input type="hidden" name="qno" value="${qna.qno }" />
                        <textArea class="form-control" id="replyContent" name="qcontent" style="resize: none;"></textArea>
                        <button class="btn" type="submit" id="addReply"  style="background: #ff666f; float: right; margin-top: 10px;">댓글 등록</button>
                    </form>
                </div>

            </div>

        </div>
    </div>
     
    <script>
    
    
    var qno = ${qna.qno};
    
    
    function updateReply(obj) {
    	$(obj).parent().prev().removeAttr('readonly');
    	$(obj).siblings('#updateConfirm').css('display', 'inline');
    	$(obj).css('display', 'none');
    }
    
    function updateConfirm(obj) {
    	var content = $(obj).parent().prev().val();
		var cno = $(obj).siblings('input').val();
		
		console.log(qno);
		console.log(content);
		console.log(cno);
    	
    	location.href="${pageContext.request.contextPath }/update.qco?qcno="+cno+"&qno="+qno
    				 +"&qccontent=" + content;
    }
    
    function deleteReply(obj){
  	  
  	  var cno = $(obj).siblings('input').val();
  	  
  	  
  	  console.log(cno);
  	  console.log(qno);
  	  
 	  location.href="${pageContext.request.contextPath }/delete.qco?qcno="+cno+"&qno="+qno;
 	  }
    
    
    function deleteBtn() {
		var result = window.confirm("정말 삭제하시겠습니까?");
		
		if(result == true) {
			location.href='${boardDelete}';	
		}
	}
    
    </script>
<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />
<br /><br /><br /><br /><br />

<%@ include file="../common/footer.jsp" %>
<%@ include file="../common/footerUtil.jsp" %>   
</body>

</html>