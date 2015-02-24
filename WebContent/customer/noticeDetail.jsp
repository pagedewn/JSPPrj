<%@page import="com.newlecture.jssprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String _code = request.getParameter("c");

Notice n=new JdbcNoticeDao().getNotice(_code);

pageContext.setAttribute("n", n);

%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <link href="css/noticeDetail.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="modernizr.js"></script>
</head>
<body>
       <!--  =============  헤더부분=========  -->
<jsp:include page="../inc/header.jsp"></jsp:include>

      <!--  =============비쥬얼부분=========  -->
<jsp:include page="inc/visual.jsp"></jsp:include>

    <div id="body">
        <div class="content-wrapper clearfix">
        
                <!--  =============aside부분=========  -->
<jsp:include page="inc/aside.jsp"></jsp:include>
   
            <main id="main">
                <h2 id="main-title">공지사항</h2>

                <div id="breadcrumb">
                    <h3 class="hidden">현재경로</h3>
                    <ol>
                        <li class="breadcrumb-item">home</li>
                        <li class="breadcrumb-item">고객센터</li>
                        <li class="breadcrumb-item">공지사항</li>
                    </ol>
                </div>

                <!-------------<페이지 컨텐트 영역>-------------------------------------------------------------------->
    	
                <article id="notice-detail" class="space-top-l">
                    <h1 class="hidden">공지사항 내용</h1>
                    <dl>
                                 <dt class="detail-cell title newrow">제목</dt>
                        <dd class="detail-cell text-highlight">${n.title}</dd>
                        <dt class="detail-cell title newrow">작성일</dt>
                        <dd class="detail-cell">${n.regdate}</dd>
                        <dt class="detail-cell title newrow">작성자</dt>
                        <dd class="detail-cell half-cell">${n.writer}</dd>
                        <dt class="detail-cell title">조회수</dt>
                        <dd class="detail-cell half-cell">${n.hit}</dd>
                        <dt class="detail-cell title newrow">첨부파일</dt>
                        <dd class="detail-cell"></dd>
                        <dt class="hidden">내용</dt>
                        <dd class="content newrow">
                        ${n.content}
   <!--                          안녕하세요. 뉴렉처입니다.<br />
                            <br />
                            "HTML5 웹 표준 가이드"가 보름안에 완강될 예정입니다.<br />
                            <br />
                            완강되면 강의료가 소폭(10%~20%) 올라갈 예정입니다.<br />
                            완강되기 전에 수강 신청하실 수 있도록 가격 인상에 대해서 미리 공지합니다.<br />
                            <br />
                            감사합나다.<br />
                            <br /> -->
                        </dd>
                    </dl>
                    <p id="button-container" class="space-top text-center">
                        <a id="btn-list" href="notice.jsp">목록</a>
                        <a href="noticeEdit.jsp?c=${param.c}">수정</a>
                        <a href="noticeDelProc.jsp?c=${n.code}">삭제</a>
                    </p>
                </article>
                

                <!-------------</페이지 컨텐트 영역>-------------------------------------------------------------------->

            </main>
        </div>
    </div>

    <footer id="footer">
        <div class="content-wrapper clearfix">
            <div id="logo-footer-container">
                <h2 id="logo-footer"><img src="../images/logo-footer.png" alt="회사정보" /></h2>
            </div>
            <div id="company-info-container">
                <div id="company-info">
                    <h3 class="hidden">소유자정보</h3>
                    <dl class="clearfix">
                        <dt class="company-info-item item-title item-newline">주소</dt>
                        <dd class="company-info-item item-data">서울특별시 동대문구</dd>
                        <dt class="company-info-item item-title item-newline">관리자메일</dt>
                        <dd class="company-info-item item-data">admin@newlecture.com</dd>
                        <dt class="company-info-item item-title">전화번호</dt>
                        <dd class="company-info-item item-data">02-111-0000</dd>
                        <dt class="company-info-item item-title item-newline">상호</dt>
                        <dd class="company-info-item item-data">뉴렉처</dd>
                    </dl>
                </div>

                <div id="copyright">
                    <h3 class="hidden">저작권정보</h3>
                    <p>Copyright@newlecture.com 2013-2015 ....</p>
                </div>
            </div>
        </div>
    </footer>

    <!--<aside id="quick-menu">
        <h1>QUICK MENU</h1>
        <nav>
            <h1>자주가는 메뉴</h1>
            <ul>
                <li>강의실</li>
                <li>채팅방</li>
                <li>스케줄</li>
            </ul>
        </nav>

        <nav>
            <h1>관리자 메뉴</h1>
            <p>QUICK MENU 관리하기</p>
        </nav>

        <nav>
            <h1>스크롤 메뉴</h1>
            <p>top</p>
        </nav>
    </aside>-->

</body>
</html>

