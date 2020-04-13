<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>로그인 및 회원가입 Page</title>
    <link rel="shortcut icon" href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png" type="image/x-icon" />
<link rel="icon" href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png" type="image/x-icon" />
    <style>
        @import url(https://fonts.googleapis.com/css?family=Roboto:300);

        .login-page {
            width: 360px;
            padding: 8% 0 0;
            margin: auto;
        }

        .form {
            position: relative;
            z-index: 1;
            background: #FFFFFF;
            max-width: 360px;
            margin: 0 auto 10px;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }

        .form input {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .form select {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #ff667093;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
        }

        .form button:hover,
        .form button:active,
        .form button:focus {
            background: #ff666f;
        }
        

        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }

        .form .message a {
            color: #ff666f;
            text-decoration: none;
        }

        .form .register-form {
            display: none;
        }

        .container {
            position: relative;
            z-index: 1;
            max-width: 300px;
            margin: 0 auto;
        }

        .container:before,
        .container:after {
            content: "";
            display: block;
            clear: both;
        }

        .container .info {
            margin: 50px auto;
            text-align: center;
        }

        .container .info h1 {
            margin: 0 0 15px;
            padding: 0;
            font-size: 36px;
            font-weight: 300;
            color: #1a1a1a;
        }

        .container .info span {
            color: #4d4d4d;
            font-size: 12px;
        }

        .container .info span a {
            color: #000000;
            text-decoration: none;
        }

        .container .info span .fa {
            color: #EF3B3A;
        }

        body {
            background: #ff666f;
            /* fallback for old browsers */
            background: -webkit-linear-gradient(right, #000000, #000000);
            background: -moz-linear-gradient(right, #000000, #000000);
            background: -o-linear-gradient(right, #000000, #000000);
            background: linear-gradient(to left, #000000, #000000);
            font-family: "Roboto", sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .home_btn {
            display: inline-block;
            font: inherit;
            background: none;
            border: none;
            color: inherit;
            padding: 0;
            cursor: pointer;
            color: snow;
        }

        .home-settings-btn {
            font-size: 1.5rem;
            /* margin-left: 1rem; */
        }
        
        select:invalid { 
        	color: gray; 
        }
        
        /*  */
        
        <style type="text/css">
    * { box-sizing: border-box; }
    .video-film{
    	box-shadow : rgba(0,7,15,0.7) 0 0 0 9999px;
		z-index : 100;
	}
    .video-background {
        background: #000;
        position: fixed;
        top: 0; right: 0; bottom: 0; left: 0;
        z-index: -99;
    }
    .video-foreground,
    .video-background iframe {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        pointer-events: none;
    }
    @media (min-aspect-ratio: 16/9) {
    .video-foreground { height: 300%; top: -100%; }
    }
    @media (max-aspect-ratio: 16/9) {
    .video-foreground { width: 300%; left: -100%; }
    }
    h1{ color:white;}
    #visual-btn {
      margin:auto;
      z-index: 50;
	  color: #fff;
	  font-size: 20px;
	  border: 2px solid #fff;
	  padding: 12px 24px;
	  border-radius: 5px;
	  cursor: pointer;
	  background-color: rgba(0,0,0,0);
	}
	#visual-btn:hover {
	  color: #ff6868;
	  font-size: 20px;
	  border: 2px solid #ff6868;
	  padding: 12px 24px;
	  border-radius: 5px;
	  cursor: pointer;
	}
	#indexBtn {
    position: fixed;
    text-align: center
}
.center {   
  justify-content: center;
  position:absolute;
  top:80%;
  left:47%;
  margin:-50px 0 0 -50px;
}  


/*  */

    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
</head>

<body>
    <div class="login-page">
        <div class="form">
            <form class="register-form" action="${pageContext.request.contextPath }/insert.me" method="post">
                <input type="text" id="joinId" name="joinId" placeholder="아이디(영문소문자+숫자 6~20자리)" pattern="^[a-z]+[a-z0-9]{5,19}$" oninput="checkId();" />
                <input type="password" id="JoinPwd" name="JoinPwd" placeholder="비밀번호(7~30자리)" pattern="^[A-Za-z0-9_-]{6,29}$" oninput="checkPwd()" />
                <input type="password" id="pwd_confirm" name="pwd_confirm" placeholder="비밀번호 확인" oninput="checkConPwd()" />
                <input type="text" id="name" name="name" placeholder="닉네임(3~11자리)" oninput="checkName()" pattern="^[0-9가-힣a-zA-Z]{2,10}$" />
                <input type="email" id="email" name="email" placeholder="이메일" oninput="checkEmail()" pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$" />
                <input type="date" id="dateOfBirth" name="dateOfBirth" placeholder="생년월일(만 7살 이상)" oninput="checkBirth();" />
                
                <select required name="gender" id="gender" oninput="checkGender();">
                    <option value="" disabled selected hidden>성별</option>
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select>
                <input type="tel" id="phone" name="phone" placeholder="00*-000*-0000" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}" oninput="checkPhone();" />
                <button id="signupbtn" type="submit">가입하기</button>
                <p class="message">이미 가입하셨나요? <a href="#">로그인</a></p>


				<script>
                
				//아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정
             
               
                //아이디 체크하여 가입버튼 비활성화, 중복확인.
                function checkId() {
                    var inputed = $('#joinId').val();
                    var reg = /^[a-z]+[a-z0-9]{5,19}$/;
                    $.ajax({
                        data : { userId : inputed },
                        url : "${pageContext.request.contextPath}/idDup.me",
                        type: "post",
                        success : function(data) {
                            if(!reg.test(inputed) || inputed=="" && data=='0') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#joinId").css("background-color", "#FFCECE");
                                
                            } else if (reg.test(inputed) && data == '0') {
                                $("#joinId").css("background-color", "#B0F6AC");
                                signupCheck();                               	
                                
                             
                            } else if (data == '1') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#joinId").css("background-color", "#FFCECE");
                                
                            } 
                        }, error : function(request, status, error){
    						console.log(request);
    						console.log(status);
    						console.log(error);
    						
    						console.log("에러 발생!!!!");
    					}
                    });
                }
                
                //닉네임 체크하여 가입버튼 비활성화, 중복확인.
                function checkName() {
                    var inputed = $('#name').val();
                    var reg = /^[1-9가-힣a-zA-Z]{2,10}$/; 
                    $.ajax({
                        data : { name : inputed },
                        url : "${pageContext.request.contextPath}/nameDup.me",
                        type: "post",
                        success : function(data) {
                            if(!reg.test(inputed) || inputed=="" && data=='0') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#name").css("background-color", "#FFCECE");
                                
                            } else if (reg.test(inputed) && data == '0') {
                                $("#name").css("background-color", "#B0F6AC");
                                signupCheck();
                                
                                
                            } else if (data == '1') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#name").css("background-color", "#FFCECE");
                                
                            } 
                        }, error : function(request, status, error){
    						console.log(request);
    						console.log(status);
    						console.log(error);
    						
    						console.log("에러 발생!!!!");
    					}
                    });
                }
                
                //이메일 체크하여 가입버튼 비활성화, 중복확인.
                function checkEmail() {
                    var inputed = $('#email').val();
                    var reg = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
                    $.ajax({
                        data : { email : inputed },
                        url : "${pageContext.request.contextPath}/emailDup.me",
                        type: "post",
                        success : function(data) {
                            if(!reg.test(inputed) || inputed=="" && data=='0') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#email").css("background-color", "#FFCECE");
                                
                            } else if (reg.test(inputed) && data == '0') {
                                $("#email").css("background-color", "#B0F6AC");
                                signupCheck();
                                
                                
                            } else if (data == '1') {
                                $("#signupbtn").prop("disabled", true);
                                $("#signupbtn").css("background-color", "#aaaaaa");
                                $("#email").css("background-color", "#FFCECE");
                                
                            } 
                        }, error : function(request, status, error){
    						console.log(request);
    						console.log(status);
    						console.log(error);
    						
    						console.log("에러 발생!!!!");
    					}
                    });
                }
                
                function checkPwd() {
                	var inputed = $('#JoinPwd').val();
                	var reg = /^[A-Za-z0-9_-]{6,18}$/;
					
                	if(!reg.test(inputed)){
                		$("#JoinPwd").css("background-color", "#FFCECE");
                	} else {
                		$("#JoinPwd").css("background-color", "#B0F6AC");
                		signupCheck();
                	}
				}
                
                
                
              //재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
                function checkConPwd() {
                    var inputed = $('#JoinPwd').val();
                    var reinputed = $('#pwd_confirm').val();
                    if(reinputed=="" && (inputed != reinputed || inputed == reinputed)){
                        $("#signupbtn").prop("disabled", true);
                        $("#signupbtn").css("background-color", "#aaaaaa");
                        $("#pwd_confirm").css("background-color", "#FFCECE");
                    }
                    else if (inputed == reinputed) {
                        $("#pwd_confirm").css("background-color", "#B0F6AC");
                        signupCheck();
                        
                    } else if (inputed != reinputed) {
                        
                        $("#signupbtn").prop("disabled", true);
                        $("#signupbtn").css("background-color", "#aaaaaa");
                        $("#pwd_confirm").css("background-color", "#FFCECE");
                        
                    }
                }
              
              // 생년월일 확인
              	function checkBirth() {
					var inputed = $('#dateOfBirth').val();

					var date = new Date(inputed);
					var dateYear = date.getFullYear();
					console.log(dateYear);
					
 					var today = new Date();
 					var todayYear = today.getFullYear();
 					console.log(todayYear);
					
 					console.log(todayYear - dateYear);
 					
 					
					if(todayYear - dateYear > 110){
						$("#dateOfBirth").css("background-color", "#FFCECE");
						$("#signupbtn").prop("disabled", true);
						$("#signupbtn").css("background-color", "#aaaaaa");
						alert("정말이세요?");
						
					} else if( 0 <= todayYear - dateYear && todayYear - dateYear < 7) {
						$("#dateOfBirth").css("background-color", "#FFCECE");
						$("#signupbtn").prop("disabled", true);
						$("#signupbtn").css("background-color", "#aaaaaa");
						alert("나이가 너무 어립니다.");
						
					} else if( todayYear - dateYear <0) {
						$("#dateOfBirth").css("background-color", "#FFCECE");
						$("#signupbtn").prop("disabled", true);
						$("#signupbtn").css("background-color", "#aaaaaa");
						alert("미래에서 오셨군요. ^^");
						
					} else if(isNaN(todayYear - dateYear)) {
						$("#dateOfBirth").css("background-color", "#FFCECE");
						$("#signupbtn").prop("disabled", true);
						$("#signupbtn").css("background-color", "#aaaaaa");
						
					} else {
						$("#dateOfBirth").css("background-color", "#b0f6ac");
						signupCheck();
					}
					
				}
              
              //성별 확인
              function checkGender() {
				var gender = $("#gender option:selected").val();
				
				//console.log(gender);
				
				if(gender == ""){
					$("#gender").css("background-color", "#FFCECE");
					$("#signupbtn").prop("disabled", true);
					$("#signupbtn").css("background-color", "#aaaaaa");
				} 
					$("#gender").css("background-color", "#b0f6ac");
					signupCheck();
			}
              
              //전화번호 확인
              function checkPhone() {
            	  var inputed = $('#phone').val();
            	  var reg = /[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
            	  
            	  if(inputed == '' || !reg.test(inputed)){
            		  $("#phone").css("background-color", "#FFCECE");
            		  $("#signupbtn").prop("disabled", true);
            		  $("#signupbtn").css("background-color", "#aaaaaa");
            	  } else {
            		  $("#phone").css("background-color", "#b0f6ac");
            		  signupCheck();
            	  }
			}

              //닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
                function signupCheck() {
                	var id = $("#joinId").val();
              	  	var pwd = $("#JoinPwd").val();
              	  	var pwdConfirm = $("#pwd_confirm").val();
                    var nickname = $("#name").val();
                    var email = $("#email").val();
              	  	var birth = $("#dateOfBirth").val();
              	  	var gender =$("select[name=gender]").val();
              	  	var phone = $("#phone").val();
                    
              	  	//console.log(gender);
              	  	
              	  	if(id == "" || pwd== "" || pwdConfirm == "" || nickname == "" || email == "" || birth == "" || gender == "" || phone =="") {
                        $("#signupbtn").prop("disabled", true);
                        $("#signupbtn").css("background-color", "#aaaaaa");
                    } else {
                    	$("#signupbtn").prop("disabled", false);
                    	
                        $("#signupbtn").css("background-color", "#ff667093");
                        
                    	$('#signupbtn').hover(function() {
                    		  $(this).css("background-color", "#ff666f");
                    		}, function(){
                    		  $(this).css("background-color", "#ff667093");
                    		});
                       
                    }
                }
              
              
              
                
                </script>

            </form>

            <form class="login-form" action="${ pageContext.request.contextPath }/login.me" method="post" >
                <input type="text" id="loginId" name="loginId" placeholder="아이디" />
                <input type="password" id="loginPwd" name="loginPwd" placeholder="비밀번호" />
                <button type="submit">로그인</button>

                <p class="message"> 회원이 아니신가요? <a href="#">회원가입</a>
                </p>

                <!-- 아이디, 닉네임, 이메일 중복체크 -->
                <!-- 아이디 / 비밀번호 찾기 -->
                <!-- 그 외 정규식, 보완 필요 -->
            </form>
        </div>
        <button class="home_btn home-settings-btn" aria-label="home settings">
            <i class="fas fa-home" aria-hidden="true"></i>
        </button>
    </div>
    
    <div class="video-background">
    <div class="video-foreground">
    <div id="muteYouTubeVideoPlayer"></div>
    </div>
  </div>
  <div class="video-film"></div>
  <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="resources/js/typeit.min.js"></script>
  <script async src="https://www.youtube.com/iframe_api"></script>
  <script type="text/javascript">
  var player;
  function onYouTubePlayerAPIReady() {
    player = new YT.Player('muteYouTubeVideoPlayer', {
    	videoId: '1GfTokIWlms',
    	playerVars: {
    	      autoplay: 1,        // Auto-play the video on load
    	      controls: 0,        // Show pause/play buttons in player
    	      rel : 0,
    	      start: 105,
    	      end: 301,
    	      showinfo : 0,
    	      showinfo: 0,        // Hide the video title
    	      modestbranding: 1,  // Hide the Youtube Logo
    	      loop: 1,            // Run the video in a loop
    	      playlist : '1GfTokIWlms',
    	      fs: 0,              // Hide the full screen button
    	      cc_load_policy: 0, // Hide closed captions
    	      iv_load_policy: 3,  // Hide the Video Annotations
    	      autohide: 1         // Hide video controls when playing
    	    },
    	events: {
    	      onReady: function(e) {
    	        e.target.mute();
    	      }
    		}
    });
  }
  </script>

    <script>
        $('.message a').click(function () {
            $('form').animate({
                height: "toggle",
                opacity: "toggle"
            }, "slow");
        });
        
        $('.home_btn').click(function () {
        	location.href="${ pageContext.request.contextPath }/index.jsp";
		});
        
        $(".register-form").submit(function(event) {
			if ($("#JoinId").val() == "" || $("#JoinPwd").val() == "" || $("#name").val() == "" || $("#email").val() == "" || $("#dateOfBirth").val() == "")
				alert("양식을 모두 작성하지 않았습니다.");
			else if ($('#JoinPwd').val() != $('#pwd_confirm').val())
				alert("비밀번호 확인 값이 일치하지 않습니다.");
			else
				return;
			event.preventDefault();
		});
        
        $('input[type="date"], input[type="datetime"], input[type="datetime-local"], input[type="month"], input[type="time"], input[type="week"]').each(function() {
            var el = this, type = $(el).attr('type');
            if ($(el).val() == '') $(el).attr('type', 'text');
            $(el).focus(function() {
                $(el).attr('type', type);
                el.click();
            });
            $(el).blur(function() {
                if ($(el).val() == '') $(el).attr('type', 'text');
            });
        });
        


        
        
    </script>
</body>

</html>