package cn.ITHong.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.ITHong.dao.HQLDao;
import cn.ITHong.struts2_hibernate.domain.Classes;

public class HQLDaoTest {

	@Test
	public void testQueryAllClasses() {
		List<Classes> cList = HQLDao.getInstance().queryAllClasses();
		System.out.println(cList.size());
	}
	public void testQuertyClassesByProperties(){
		HQLDao.getInstance().quertyClassesByProperties();
	}
}
