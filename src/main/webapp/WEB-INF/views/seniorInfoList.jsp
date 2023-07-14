<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시니어 회원 정보 리스트</title>
</head>
<style>
.sList {
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 1.8rem;
	margin: 10px;
}

.pd {
	align-items: center;
	padding: 110px 50px 110px 50px;
}

#dtBtn,
#snrIdBtn,
#parIdBtn{
	font-weight: bold;
	color: green;
	
}

@charset "UTF-8";

@font-face {
	font-family: 'omyu_pretty';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

* {
	text-align: center;
	font-family: 'omyu_pretty';
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background: #D8E0A5;
}

#table {
	border-collapse: separate;
	border-spacing: 0;
	text-align: center;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	margin: 0 auto;
	background: #FAF3E6;
}

th {
	background: #198754;
	color: #fff;
	text-align: center;
	height: 50px;
	width: 15px;
	font-size: 20px;
}

th:nth-child(1),
th:nth-child(12){
	padding-left: 30px;
	padding-right: 35px;
}

th:nth-child(2),
th:nth-child(3),
th:nth-child(4),
th:nth-child(5),
th:nth-child(9){
	padding-left: 10px;
	padding-right: 15px;
}


th:nth-child(6),
th:nth-child(7){
	padding-left: 50px;
	padding-right: 50px;
}

th:nth-child(8){
	padding-left: 10px;
	padding-right: 10px;
}

tr:first-child th:first-child {
	border-top-left-radius: 6px;
}

tr:first-child th:last-child {
	border-top-right-radius: 6px;
}

td {
	border-right: 1px solid #c6c9cc;
	border-bottom: 1px solid #c6c9cc;
	height: 50px;
}

td:first-child {
	border-left: 1px solid #c6c9cc;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 6px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 6px;
}
</style>


<%@ include file="header.jsp"%>

<%
if ( !(userId.equals("admin")) || userId == null) {
response.sendRedirect("main");
}
%> 

<div class="pd">
<div class="sList">시니어 회원 정보 리스트</div>

<body>

	<table id="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>상세주소</th>
				<th>동</th>
				<th>성별</th>
				<th>이메일</th>
				<th>회원구분</th>
				<th>가입일자</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="sList" items="${snrInfoList}">
				<tr>
					<td><a id="dtBtn" href="snrInfoList?id=${sList.id}">${sList.id}</a></td>
					<td>${sList.name}</td>
					<td><c:out value="${fn:substring(sList.birthday, 0, 10)}"/></td>
					<td>${sList.phoneNumber}</td>
					<td>${sList.postCode}</td>
					<td>${sList.address}</td>
					<td>${sList.detailAddress}</td>
					<td>${sList.extraAddress}</td>
					<td>${sList.gender}</td>
					<td>${sList.email}</td>
					<td><c:choose>
							<c:when test="${sList.userCode eq 'SNR'}">시니어</c:when>
							<c:when test="${sList.userCode eq 'BLACK'}">블랙회원</c:when>
						</c:choose></td>
					<td><c:out value="${fn:substring(sList.regDate, 0, 10)}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</div>
</html>