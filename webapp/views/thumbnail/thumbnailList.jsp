<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<meta charset="UTF-8">
<title>StyleTip Share</title>
<%@ include file="../common/headerUtil.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<style>
   /* Base Styles */

:root {
    font-size: 10px;
}

*,
*::before,
*::after {
    box-sizing: border-box;
}

body {
    font-family: "Open Sans", Arial, sans-serif;
    min-height: 100vh;
    background-color: #fafafa;
    color: #262626;
   
}

img {
    display: block;
    z-index:1;
}

.ccontainer {
    max-width: 93.5rem;
    margin: 0 auto;
    padding: 0 2rem;
}

.btn {
    display: inline-block;
    font: inherit;
    background: none;
    border: none;
    color: inherit;
    padding: 0;
    cursor: pointer;
}

.btn:focus {
    outline: 0.5rem auto #4d90fe;
}

.visually-hidden {
    position: absolute !important;
    height: 1px;
    width: 1px;
    overflow: hidden;
    clip: rect(1px, 1px, 1px, 1px);
}
   .thumbnailArea {
      width:760px;
      height:auto;
      margin-left:auto;
      margin-right:auto;
   }
   .searchArea {
      width:420px;
      margin-left:auto;
      margin-right:auto;
   }
   .thumb-list {
      width:220px;
      border:1px solid white;
      display:inline-block;
      margin:10px;
      align:center;
   }
   .thumb-list:hover {
      opacity:0.8;
      cursor:pointer;
   }
   

   .gallery-image {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
   .gallery-item {
    position: relative;
    flex: 1 0 22rem;
    margin: 1rem;
    color: #fff;
    cursor: pointer;
   }
   

   .gallery-item-likes {
    margin-right: 2.2rem;
   }
   .gallery-item:hover .gallery-item-info,
   .gallery-item:focus .gallery-item-info {
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.3);
   }

   .gallery-item-info {
    display: none;
   }

   .gallery-item-info li {
    display: inline-block;
    font-size: 1.7rem;
    font-weight: 600;
   }
   @supports (display: grid) {
    

    .gallery {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(22rem, 1fr));
        grid-gap: 2rem;
    }
    }
/* Loader */

.loader {
    width: 5rem;
    height: 5rem;
    border: 0.6rem solid #999;
    border-bottom-color: transparent;
    border-radius: 50%;
    margin: 0 auto;
    animation: loader 500ms linear infinite;
}


/* Spinner Animation */

@keyframes loader {
    to {
        transform: rotate(360deg);
    }
}

@supports (display: grid) {
   

    .gallery {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(22rem, 1fr));
        grid-gap: 2rem;
    }
   
    .gallery-item{
        width: auto;
        height: 300px;
        margin: 0;
    }

    
}


   .button {
   border-collapse: collapse;
   border:0;
   border-radius: 20px;
   padding:20px;
   margin:40px;
   margin-bottom:45px;
   display: inline-block;
   border:1px solid #CCC;
   background-color: transparent;
   cursor: pointer;

}


.btn-circle.btn-lg {
     width: 50px;
     height: 50px;
     padding: 12px 14px;
     font-size: 18px;
     line-height: 1.33;
     border-radius: 25px;
     background-color: #ff666f;
     border-color: #ff666f;
     cursor: pointer;
   }
  
   .btn-circle.btn-lg:active {
     background-color: #ff666f;
     border-color: #ff666f;
   }
   .plusBtn {
      position: absolute;
      position: fixed;
      right: 50px; 
      bottom: 50px;
   }
   .navbar-brand {
    height: inherit !important;
    }
</style>
<meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<script src ="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<%@ include file="../common/header.jsp"%>
</head>

<body style="background: #ffd2d2;">
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<div class="ccontainer">
       <div class="row" align="center">
                 <div class="col-lg-6 col-lg-offset-3 text-center">  
                    <h2># Style Share</h2>
                 </div> 
            </div>  

      
<div class="searchArea">
         
          <div class="plusBtn">
         <c:if test="${ !empty member }">
         <button type="button" class="button btn btn-primary btn-circle btn-lg" onclick="location.href='${pageContext.request.contextPath }/views/thumbnail/thumbnailInsertForm.jsp'">
            <i class="glyphicon glyphicon-plus" ></i>
         </button> 
         </c:if>
      </div>
     
      
         
      </div>
      <br><br>
      

      
   <br />
    <br>
     
      
      <div class="gallery">
      
      
         <c:forEach var="thumb" items="${list}">
            <div class="gallery-item" tabindex="0">
               <input type="hidden" value="${thumb.bno}">
                  <img src="/facehair/resources/thumbnailFiles/${thumb.bfile}" class="gallery-image" >
             <div class="gallery-item-info">
                   <ul>
                       <li class="gallery-item-likes"><span class="visually-hidden">Likes:</span><i class="fas fa-heart" aria-hidden="true"></i> 0</li>
                        <li class="gallery-item-comments"><span class="visually-hidden">Comments:</span><i class="fas fa-comment" aria-hidden="true"></i> 0</li>
                    </ul>
             </div>
               
            
            </div>
      </c:forEach>
      </div>
      <script>
         $(function(){
            $('.gallery-item').click(function(){
               var bno = $(this).children().eq(0).val();
               
               location.href="/facehair/selectOne.tn?bno="+ bno + "&userNo=" + ${member.userNo};
            });
         });
         
     
      </script>
	

      
   </div>
   <!-- End of container -->


<br />
<br />
<br />
<br />
<br />



</body>
<%@ include file="../common/footer.jsp"%>
<%@ include file="../common/footerUtil.jsp"%>
</html>

