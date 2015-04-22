package cn.ITHong.hibernate.base.secondcache;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;




import cn.ITHong.hibernate.base.util.HibernateUtils;
import cn.ITHong.hibernate.itest.ICacheTest;
import cn.ITHong.struts2_hibernate.domain.Classes;
/**
 * 是对cn.ITHong.struts2_hibernate.domain的测试
 * */
public class SecondCacheTest extends HibernateUtils implements ICacheTest{
	static{
		url="cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
	}
	/**
	 * 需要加入
	 * 在Classes.hbm.xml
	 * <cache usage="read-write"/>
	 * 则在第二个classes = (Classes) session.get(Classes.class, 1L);执行后不会发出SQL
	 * 没有配<cache usage="read-write"/>
	 * 则第二个classes = (Classes) session.get(Classes.class, 1L);执行后会发出SQL
	 * session.get	把数据存在一级缓存和二级缓存	优先查找一级 然后二级 最后才数据库
	 * */
	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Classes classes = (Classes) session.get(Classes.class, 1L);
		//清除一级缓存
		session.close();
		session = sessionFactory.openSession();
		classes = (Classes) session.get(Classes.class, 1L);
		session.close();
	}
	/**
	 * 需要加入
	 * 在Classes.hbm.xml
	 * <cache usage="read-write"/>
	 * 则在第二个classes = (Classes) session.load(Classes.class, 1L);执行后不会发出SQL
	 * 没有配<cache usage="read-write"/>
	 * 则第二个classes = (Classes) session.load(Classes.class, 1L);执行后会发出SQL
	 * session.get	把数据存在一级缓存和二级缓存	优先查找一级 然后二级 最后才数据库
	 * */
	@Test
	public void testLoad() {
		Session session = sessionFactory.openSession();
		Classes classes = (Classes) session.load(Classes.class, 1L);
		classes.getCname();
		//清除一级缓存
		session.close();
		session = sessionFactory.openSession();
		classes = (Classes) session.load(Classes.class, 1L);
		classes.getCname();
		session.close();
		
	}
	@Test
	public void testSave() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * session.update(classes);只把对象放进了一级缓存，二级缓存没有存放
	 * session.get(Classes.class, classes.getCid());
	 * 因为最后这一句 直接发出SQL语句了
	 * */
	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();
		Classes classes = new Classes();
		classes.setCid(3L);
		classes.setCname("测试二级缓存名字");
		classes.setDescription("测试二级缓存描述");
		//放进一级缓存
		session.update(classes);
		session.close();
		session = sessionFactory.openSession();
		//因为一级缓存只是线程私有，所以关了就没了，如果这里能获取，
		//则说明是二级缓存，条件是不发出SQL语句
		session.get(Classes.class, classes.getCid());
		session.close();
		
	}
	@Test
	public void testClear() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testClearTest() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testClearTest_2() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testRefresh() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testFlush() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testSaveBatch() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testSaveBatch_2() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testFlush_3() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
