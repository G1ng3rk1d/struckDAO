package ca.gkwb.struck.incident.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class StruckTOIncidentDAOTest {

	IncidentDAO stiDAO;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("context-DAO.xml");
		System.setProperty("spring.profiles.active", "test1");
		stiDAO = (IncidentDAO)context.getBean("struckTOIncidentDAO");
	}	
	
	@Test
	public void testQueryById() {
		try {
			IncidentVO stiVO = stiDAO.queryById(1);
			Assert.isTrue(stiVO.getIncidentId() == 1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.notNull(null);
		}
	}
	
	@Test
	@Transactional
	public void testInsert() {
		try {
			//TODO
			stiDAO.insert(null);
			
			IncidentVO stiVO = stiDAO.queryById(1);
			Assert.isTrue(stiVO.getIncidentId() == 1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.notNull(null);
		}
	}
	
	@Test
	@Transactional
	public void testQueryByLocationId() {
		try {
			List<IncidentVO> stiVOs = stiDAO.queryByLocationId(5);
			Assert.isTrue(stiVOs.size() == 1);
			Assert.isTrue(stiVOs.get(0).getIncidentId() == 1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.notNull(null);
		}
	}		
}
