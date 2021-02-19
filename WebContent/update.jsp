<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ncs_java_yhs2.dto.Member"%>
<%@page import="ncs_java_yhs2.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = MemberDao.getInstance();
	
	int custNo = Integer.parseInt(request.getParameter("custNo"));
	Member member = dao.selectMemberByNo(custNo);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String joinDate = sdf.format(member.getJoinDate());
%>    

<h2>홈쇼핑 회원 정보 수정</h2>
<form action="/ncs_java_yhs2/write.jsp?update=y" method="post" id="join">
	<table border="1px solid black">
		<tr>
			<td>회원번호</td>
			<td><input type="text" id="custNo" name = "custNo" readonly value="<%=member.getCustNo() %>"></td>
		</tr>
		<tr>
			<td>회원성명</td>
			<td><input type="text" id="custName" name="custName" value="<%=member.getCustName() %>"></td>
		</tr>
		<tr>
			<td>회원전화</td>
			<td><input type="text" id="phone" name="phone" value="<%=member.getPhone() %>"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" id="address" name="address" value="<%=member.getAddress() %>"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><input type="text" id="joinDate" name="joinDate" value="<%=joinDate %>" readonly></td>
		</tr>
		<tr>
			<td>고객등급[A:VIP,B:일반,C:직원]</td>
			<td><input type="text" id="grade" name="grade" value="<%=member.getGrade() %>"></td>
		</tr>
		<tr>
			<td>도시코드</td>
			<td><input type="text" id="city" name="city" value="<%=member.getCity() %>"></td>
		</tr>
	</table>
</form>
<div>
	<button type="submit" onclick="update();return false">수정</button>
	<button type="button" onclick="toList();">목록</button>
</div>