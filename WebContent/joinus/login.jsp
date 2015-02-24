﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/bind.css" rel="stylesheet" type="text/css" />
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="modernizr.js"></script>
</head>
<body>
      <!--  =============  헤더부분=========  -->
<jsp:include page="../inc/header.jsp"></jsp:include>

    <div id="visual">
        <div class="content-wrapper">

        </div>
    </div>

    <div id="body">
        <div class="content-wrapper clearfix">
            <aside class="aside-menu-group">
                <h1 class="aside-menu-group-title">회원가입</h1>

                <nav class="aside-main-menu">
                    <h1 class="hidden">회원가입 메뉴</h1>
                    <ul>
                        <li class="aside-menu-item"><a href="">로그인</a></li>
                        <li class="aside-menu-item"><a href="">회원가입</a></li>
                        <li class="aside-menu-item"><a href="">아이디찾기</a></li>
                        <li class="aside-menu-item"><a href="">비밀번호 재발급</a></li>
                    </ul>
                </nav>

                <nav class="aside-menu">
                    <h1>추천사이트</h1>
                    <ul class="aside-menu-list">
                        <li><img src="../images/answeris.png" alt="앤서이즈" /></li>
                        <li><img src="../images/w3c.png" alt="W3C" /></li>
                        <li><img src="../images/microsoft.png" alt="마이크로소프트" /></li>
                    </ul>
                </nav>

            </aside>

            <main id="main">
                <h2 id="main-title">로그인</h2>

                <div id="breadcrumb">
                    <h3 class="hidden">현재경로</h3>
                    <ol>
                        <li class="breadcrumb-item">home</li>
                        <li class="breadcrumb-item">회원가입</li>
                        <li class="breadcrumb-item">로그인</li>
                    </ol>
                </div>


 <div>
 <span style="color:red;">${msg} </span>
 </div>

			<form action="loginProc.jsp" method="post">
				<fieldset>
					<legend>로그인 정보</legend>
					<dl>
						<dt>
							<label>아이디</label>
						</dt>
						<dd>
							<input type="text" name="uid" />						
						</dd>
						<dt>
							<label>비밀번호</label>
						</dt>
						<dd>
							<input type="password" name="pwd" />
						</dd>
					</dl>

					<p>
						<input type="submit" value="로그인" />
					</p>
					<ul>
						<li>아이디 또는 비밀번호를 분실하셨나요?<a>ID/PWD찾기</a></li>
						<li>아이디가 없으신 분은 회원가입을 해주세요!<a>회원가입</a></li>
					</ul>

				</fieldset>

			</form>

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

