<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<footer class="footer footer-black  footer-white ">
	<div class="container">
		<div class="row">
			<nav class="footer-nav">
				<ul>
					<li><a href="${ pageContext.request.contextPath }/views/common/facehair.html">4조member</a>
					</li>
					<li><a href="${ pageContext.request.contextPath }/selectList.no">공지사항</a>
					</li>
					<li><a href="${ pageContext.request.contextPath }/selectList.qn">QNA</a>
					</li>
					<c:if test="${ !empty member && member.mlevel == 2  }">
					<li><a
						href="${ pageContext.request.contextPath }/adminSelectQnaList.do"
						>
							<p class="nc-icon nc-satisfied">관리자페이지</p>
					</a></li>
					<li><a
						href="${ pageContext.request.contextPath }/views/statistics/statistics.jsp"
						>
							<p class="nc-icon nc-satisfied">통계</p>
					</a></li>
				</c:if>
			
				</ul>
			</nav>
			<div class="credits ml-auto">
				<span class="copyright"> © <script>
                document.write(new Date().getFullYear())
              </script>, made with <i class="fa fa-heart heart"></i> by Sangho
					Pack
				</span>
			</div>
		</div>
	</div>
</footer>
<!--   Core JS Files   -->