<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<hearder> <!-- Navbar -->
<nav class="navbar navbar-expand-lg fixed-top navbar-transparent "
	color-on-scroll="50">
	<div class="container">
		<div class="navbar-translate">

			<div style="display: inline-flex;">
				<div>
					<a class="navbar-brand" data-placement="bottom"
						href="${ pageContext.request.contextPath }/index.jsp"> <img
						src="${ pageContext.request.contextPath }/resources\images\logo\ms-icon-310x310.png"
						width="43" !impoort style="color: black;">
					</a>
				</div>

				<form method="post" id="searchForm" style="display: inline-flex;">

					<div style="margin: 5px 0px; padding: 20px 15px;">
						<div class="select-wrapper select--white">

							<select name="searchMenu" id="searchMenu">
								<option value="Talk">Talk</option>
								<option value="StyleTip">StyleTip</option>
								<option value="Event">Event</option>
								<option value="notice">Notice</option>
							</select>

						</div>
					</div>

					<div class="navbar-brand">

						<div class="searchbar">
							<input class="search_input" type="text" name="search"
								placeholder="검색어 입력" /> <a href="#" onclick="searchGo()" class="search_icon"> <i
								class="fas fa-search"></i>
							</a>
						</div>
					</div>
				</form>

			</div>


			<script>
			
			$('.search_input').keypress(function(event){
			     if ( event.which == 13 ) {
			         $('.search_icon').click();
			         return false;
			     }
			});
				
				function searchGo() {

					var searchMenu = document.getElementById("searchMenu");

					console.log(searchMenu);

					switch (searchMenu.value) {
					case 'Talk':
						$('#searchForm')
								.attr("action",
										"${pageContext.request.contextPath}/talkSearch.do");

						break;
					case 'StyleTip':
						$('#searchForm')
								.attr("action",
										"${pageContext.request.contextPath}/tipSearch.do");

						break;

					case 'Event':
						$('#searchForm')
								.attr("action",
										"${pageContext.request.contextPath}/eventSearch.do");

						break;

					case 'notice':
						$('#searchForm')
								.attr("action",
										"${pageContext.request.contextPath}/noticeSearch.do");
						break;
					}

					$('#searchForm').submit();
				}
			

			</script>



			<button class="navbar-toggler navbar-toggler" type="button"
				data-toggle="collapse" data-target="#navigation"
				aria-controls="navigation-index" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-bar bar1"></span> <span
					class="navbar-toggler-bar bar2"></span> <span
					class="navbar-toggler-bar bar3"></span>
			</button>
		</div>



		<div class="collapse navbar-collapse justify-content-end"
			id="navigation">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					data-placement="bottom"
					href="${ pageContext.request.contextPath }/index.jsp">
						<p>home</p>
						<p class="d-lg-none"></p>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Like us on Facebook" data-placement="bottom"
					href="${ pageContext.request.contextPath }/selectList.tn">
						<p class="nc-icon nc-camera-compact">스타일 공유</p>
						<p class="d-lg-none"></p>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Follow us on Instagram" data-placement="bottom"
					href="${ pageContext.request.contextPath }/selectList.st">
						<p class="nc-icon nc-favourite-28">스타일팁</p>

						<p class="d-lg-none"></p>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Star on GitHub" data-placement="bottom"
					href="${ pageContext.request.contextPath }/selectList.ta">
						<p class="nc-icon nc-chat-33">수다방</p>
						<p class="d-lg-none"></p>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Star on GitHub" data-placement="bottom"
					href="${ pageContext.request.contextPath }/ListEventboard.do">
						<p class="nc-icon nc-bulb-63">이벤트</p>
						<p class="d-lg-none"></p>
				</a></li>

				<%-- <li class="nav-item"><a
					href="${ pageContext.request.contextPath }/views/search/searchPage.jsp"
					class="nav-link"><p class="nc-icon nc-zoom-split">검색</p></a></li> --%>

				<c:if test="${ empty member }">
					<li class="nav-item"><a
						href="${ pageContext.request.contextPath }/views/member/memberJoinLoginForm.jsp"
						class="nav-link"><p class="nc-icon nc-circle-10">로그인/회원가입</p></a>
					</li>
				</c:if>
				
				
				<c:if test="${ !empty member && member.mlevel == 1 }">
					<li class="nav-item"><a
						href="${ pageContext.request.contextPath }/views/member/memberUpdateView.jsp"
						class="nav-link">
							<p class="nc-icon nc-satisfied">마이페이지</p>
					</a></li>
				</c:if>				
				
				<c:if test="${ !empty member }">
					<li class="nav-item"><a
						href="${ pageContext.request.contextPath }/logout.me"
						class="nav-link">
							<p class="nc-icon nc-simple-remove">로그아웃</p>
					</a></li>
				</c:if>


			</ul>

		</div>

	</div>




</nav>
<!-- End Navbar --> </hearder>
