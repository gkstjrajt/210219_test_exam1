<%@page import="ncs_java_yhs2.dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="ncs_java_yhs2.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDao dao = MemberDao.getInstance();
	List<Member> list = dao.selectMemberByAll();
%>

<h2>회원목록조회/수정</h2>
<table border="1px solid black">
	<thead>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>
	</thead>
	<tbody>
		<% for(Member member : list) { %>
			<tr>
				<td><a href="/ncs_java_yhs2/index.jsp?pp=update&custNo=<%=member.getCustNo()%>"><%=member.getCustNo() %></a></td>
				<td><%=member.getCustName() %></td>
				<td><%=member.getPhone() %></td>
				<td><%=member.getAddress() %></td>
				<td><%=member.getJoinDate() %></td>
					
				<% if(member.getGrade().equals("A")) { %>
					<td>VIP</td>
				<% } else if (member.getGrade().equals("B")) {%>
					<td>일반</td>
				<% } else {%>
					<td>직원</td>
				<% } %>
					
				<td><%=member.getCity() %></td>
			</tr>
		<% } %>
	</tbody>
</table>