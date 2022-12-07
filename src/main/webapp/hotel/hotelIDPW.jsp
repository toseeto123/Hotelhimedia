<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/hotelIDPW.css">
<script type="text/javascript" src="script/hotel.js"></script>
</head>

<!-- 아이디 비밀번호 찾기 페이지 -->

<body>
<div class="contents">
        <div class="container">
            <div class="IDFind_form">
            <form name="frm" method="post">
                <input type="text" name="name" placeholder="이름">
                <input type="text" name="email" placeholder="이메일">
                <input type="button" value="아이디 찾기" onClick="idCheck()">
            </form>
            </div>


              
            <div class="PWFind_form">
            <form name="frm1" method="post">
                <input type="text" name="id" placeholder="아이디">
                <input type="text" name="name" placeholder="이름">
                <input type="text" name="email" placeholder="이메일">
                <input type="button" value="비밀번호 찾기" onClick="passCheck()">
            </form>
            </div>
           

        </div>

    </div>

</body>
</html>