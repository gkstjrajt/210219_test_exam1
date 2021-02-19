<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ncs_java_yhs2.dto.Member"%>
<%@page import="ncs_java_yhs2.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	int custNo = Integer.parseInt(request.getParameter("custNo"));
	String custName = request.getParameter("custName");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	Date joinDate = sdf.parse(request.getParameter("joinDate"));
	
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");

	Member member = new Member(custNo, custName, phone, address, joinDate, grade, city);
	MemberDao dao = MemberDao.getInstance();
	
	int result = -1;
	if(request.getParameter("update").equals("n")){
		dao.insertMember(member);
		result = 0;
	} else {
		dao.updateMember(member);
		result = 1;
	}
%>

<script type="text/javascript">
	location.href = "/ncs_java_yhs2/index.jsp?pp=list";
</script>