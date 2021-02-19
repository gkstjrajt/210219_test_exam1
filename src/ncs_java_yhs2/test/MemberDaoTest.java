package ncs_java_yhs2.test;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ncs_java_yhs2.dao.MemberDao;
import ncs_java_yhs2.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {

	MemberDao dao = MemberDao.getInstance();
	
	int custNo = dao.getCustNo();
	String custName = "윤한석";
	String phone = "010-5230-7564";
	String address = "대구시 대구";
	Date joinDate = new Date();
	String grade = "A";
	String city = "22";
	Member member = new Member(custNo, custName, phone, address, joinDate, grade, city);

	@Test
	public void test2SelectMemberByAll() {
		System.out.println("testSelectMemberByAll");
		List<Member> list = dao.selectMemberByAll();
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test1GetCustNo() {
		System.out.println("testGetCustNo");
		int res = dao.getCustNo();
		System.out.println(res);
	}
	
	@Test
	public void test3InsertMember() {
		System.out.println("testInsertMember");
		int res = dao.insertMember(member);
		System.out.println(res);
	}
	
	@Test
	public void test4UpdateMember() {
		System.out.println("testUpdateMember");
		member.setCustNo(dao.getCustNo()-1);
		member.setPhone("010-3333-3333");
		member.setGrade("B");
		int res = dao.updateMember(member);
		System.out.println(res);
	}
	
	@Test
	public void test5SelectMemberByNo() {
		System.out.println("testSelectMemberByNo");
		Member newMem = dao.selectMemberByNo(member.getCustNo()-1);
		System.out.println(member.getCustNo()-1);
		System.out.println(newMem);
	}
	
	@Test
	public void test6DeleteMember() {
		System.out.println("testDeleteMember");
		int res = dao.deleteMember(member.getCustNo() -1);
		System.out.println(res);
	}

}








