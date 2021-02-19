package ncs_java_yhs2.test;

import java.sql.Connection;

import org.junit.Test;

import ncs_java_yhs2.ds.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		Connection con = JdbcUtil.getConnection();
		System.out.println(con);
	}

}
