package ncs_java_yhs2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ncs_java_yhs2.dao.SaleDao;
import ncs_java_yhs2.dto.Sale;

public class SaleDaoTest {
	SaleDao dao = SaleDao.getInstance();
	
	@Test
	public void testSelectSaleByAll() {
		System.out.println("testSelectSaleByAll");
		List<Sale> list = dao.selectSaleByAll();
		list.stream().forEach(System.out::println);
	}

}
