<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/hotelRegister.css">
<script type="text/javascript" src="script/hotel.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 회원가입 페이지 -->

<body>
	
   <div class="container">
            <div class="Register_form">
                <div class="Logo">
                    <p>Member Registers</p>
                </div>
                <form action="HotelServlet" name="frm" method="post">
         		<input type="hidden" name="command" value="hotel_register">
                <input type="hidden" name="lev" value="B">
                
                <input type="text" name="name" id="name" placeholder="이름을 꼭 입력해주세요.">
                
                <input type="text" name="id" id="id" placeholder="아이디 꼭 입력해주세요.">
                <input type="hidden" name="reid">
                <input type="button" value="중복확인" onclick="idCheck()">
                
                <input type="password" name="pass" id="pass" placeholder="비밀번호 꼭 입력해주세요.">
                <input type="password" name="pass_check" id="pass_check" placeholder="비밀번호 확인 꼭 입력해주세요.">
                <input type="text" name="phone" placeholder="핸드폰번호">
                <input type="text" name="email" placeholder="이메일 꼭 입력해주세요.">
                <input type="submit" value="회원가입"
                 onClick="return registerCheck()">
                <input type="reset" value="가입취소">
                <input type="button" value="이전페이지" onclick="location.href='HotelServlet?command=login_page'">
                 
                </form>


            </div>

        </div>
       
    
</body>
</html>