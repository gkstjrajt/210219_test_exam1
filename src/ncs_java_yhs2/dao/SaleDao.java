package ncs_java_yhs2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ncs_java_yhs2.ds.JdbcUtil;
import ncs_java_yhs2.dto.Sale;

public class SaleDao {
	private static final SaleDao instance = new SaleDao();

	public SaleDao() {
	}

	public static SaleDao getInstance() {
		return instance;
	}
	
	public List<Sale> selectSaleByAll() {
		String sql = "SELECT t.CUSTNO AS CUSTNO, CUSTNAME, GRADE, SUM(PRICE) AS PRICE FROM MEMBER_TBL_03 t JOIN MONEY_TBL_03 m ON t.CUSTNO = m.CUSTNO GROUP BY t.CUSTNO, CUSTNAME, GRADE ORDER BY PRICE DESC";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Sale> list = new ArrayList<Sale>();
				do {
					list.add(getSale(rs));
				} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		int custNo = rs.getInt("CUSTNO");
		String custName = rs.getString("CUSTNAME");
		String grade = rs.getString("GRADE");
		int sale = rs.getInt("PRICE");
		return new Sale(custNo, custName, grade, sale);
	}
}
