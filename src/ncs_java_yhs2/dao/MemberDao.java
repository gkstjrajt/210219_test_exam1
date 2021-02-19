package ncs_java_yhs2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ncs_java_yhs2.ds.JdbcUtil;
import ncs_java_yhs2.dto.Member;

public class MemberDao {
	private static final MemberDao instance = new MemberDao();

	public MemberDao() {
	}

	public static MemberDao getInstance() {
		return instance;
	}

	public List<Member> selectMemberByAll(){
		String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY FROM MEMBER_TBL_03";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Member> list = new ArrayList<Member>();
				do {
					list.add(getMember(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		int custNo = rs.getInt("CUSTNO");
		String custName = rs.getString("CUSTNAME");
		String phone = rs.getString("PHONE");
		String address = rs.getString("ADDRESS");
		Date joinDate = new Timestamp(rs.getTimestamp("JOINDATE").getTime());
		String grade = rs.getString("GRADE");
		String city = rs.getString("CITY");
		return new Member(custNo, custName, phone, address, joinDate, grade, city);
	}
	
	public int getCustNo() {
		String sql = "SELECT MAX(CUSTNO)+1 FROM MEMBER_TBL_03";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Member selectMemberByNo(int custNo) {
		String sql = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY FROM MEMBER_TBL_03 WHERE CUSTNO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, custNo);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getMember(rs);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER_TBL_03 VALUES(?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, member.getCustNo());
				pstmt.setString(2, member.getCustName());
				pstmt.setString(3, member.getPhone());
				pstmt.setString(4, member.getAddress());
				pstmt.setTimestamp(5, new Timestamp(member.getJoinDate().getTime()));
				pstmt.setString(6, member.getGrade());
				pstmt.setString(7, member.getCity());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateMember(Member member) {
		String sql = "UPDATE MEMBER_TBL_03 SET CUSTNAME = ?, PHONE = ?, ADDRESS = ?, JOINDATE = ?, GRADE = ?, CITY = ? WHERE CUSTNO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, member.getCustName());
				pstmt.setString(2, member.getPhone());
				pstmt.setString(3, member.getAddress());
				pstmt.setTimestamp(4, new Timestamp(member.getJoinDate().getTime()));
				pstmt.setString(5, member.getGrade());
				pstmt.setString(6, member.getCity());
				pstmt.setInt(7, member.getCustNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMember(int custNo) {
		String sql = "DELETE FROM MEMBER_TBL_03 WHERE CUSTNO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, custNo);
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}











