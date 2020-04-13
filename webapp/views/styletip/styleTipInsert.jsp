<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../common/commonUtil.jsp"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<style>
	.body {
		background-color:#FEDDDF;
	     align: center;
	} 
	.outer {
		
	      width:1000px;
	      height:auto;
	      margin-left:auto;
	      margin-right:auto;
	      margin-top:50px;
	}
	#f1 {
		margin-left:30px;
	}
	#summernote {
		margin-left:100px;
	}
	#category  {
		border: 1px solid darkgrey;
		border-radius: 5px;
	}
	#title  {
		border: 1px solid darkgrey;
		border-radius: 5px;
	}
	#f1{
		color: #61676B;
	}
	.btn{
		    
		    border: 1px solid #ff666f;
		    border-radius: 5px;
		    text-align: center;
		    color: #ff666f;
		    margin-bottom: 30px;
		    margin-left: 30px;
		
	}
	.btn:hover{
	    
	    border: 1px solid #ff666f;
	    border-radius: 5px;
	    text-align: center;
	    color: #ffffff;
	    background-color: #ff666f;
	    cursor:pointer;
	}
	
	.fileArea {
		display : none;
	}
</style>
	<c:import url="../common/headerUtil.jsp"/>
</head>
<body>
	<c:import url="../common/header.jsp"/>
	
	<div class="body">
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<section class="outer"">
		<br />
		<h1 align="center">Style Tip 글작성</h1>
		<br />
		<br />
		<br />
		<form id="insertform" action="${ pageContext.request.contextPath }/insert.st" method="post">
			<br />
			<input type="hidden" name="userId" value="${member.userId}" />
			
			<div id="f1">
				카테고리 : <select name="category" id="category">
							<option value="A">전체</option>
		         			<option value="F">여</option>
		         			<option value="M">남</option>
		            	</select>
	        </div> <br />
	        <div id="f1">
				제목 : <input type="text" size="105" id="title" name="title" placeholder="제목을 입력하세요"/>
			</div> <br /><br />
			
			<textarea id="summernote" name="editordata"></textarea>
			
			<br />
			<div class="btnArea">
	         	<button type="submit" class="btn" onclick="insertbtn();">작성완료</button>&nbsp;
	         	<button type="reset" class="btn" onclick="cancelbtn();">작성취소</button>
	         </div>
	         <div class="fileArea">
	         	
	         </div>
		</form>
		
	    <script>
	      $('#summernote').summernote({
				placeholder: '내용을 입력하세요',
				tabsize: 2,
				height: 500,
				width: 900,
				focus: true,
				callbacks: {
					onImageUpload: function(files, editor, welEditable) {
			            for (var i = files.length - 1; i >= 0; i--) {
			            	sendFile(files[i], this);
			            }
			        }
				}
	      });
	     
	      $('.dropdown-toggle').dropdown()
	      
	      function sendFile(file, el) {
	    	  
			var form_data = new FormData();
	    	form_data.append('file', file);
	    	// console.log(form_data.file);
	    	
	    	$.ajax({
		      	data: form_data,
		      	type: "post",
		      	url: '/facehair/insert.stsn',
				cache : false,
				contentType : false,
		      	enctype: 'multipart/form-data',
				processData : false,
		      	success: function(url) {
		      		console.log('----------------------------');
		      		console.log(url);
		      		console.log('----------------------------');
		      		url.replace("\/","/");
		        	$(el).summernote('editor.insertImage', url);
		      	}, error: function(){
		      		console.log("실패실패");
		      	}
    		});
		  }
	      
	      function insertbtn(){
	    	  if($('#title').val() == ""){
	    		  alert("제목을 입력하세요.");
	    		  $('#title').focus();
	    	  } else if($('#summernote').val() == ""){
	    		  alert("내용을 입력해 주세요.");
	    		  $('#summernote').focus();
	    	  } else {
	    		  $('#insertform').submit();
	    	  }
	    	  event.preventDefault();	
	    	  
	      }
	      
	      function cancelbtn(){
	    	  var answer = confirm("게시글 작성을 취소하시겠습니까?");
	    	  
	    	  if(answer == true){
	    		  location.href="/facehair/selectList.st";
              } 
	      }
	      
	    </script>
	</section>
	</div>
	<c:import url="../common/footer.jsp"/>
	<c:import url="../common/footerUtil.jsp"/>
</body>
</html>