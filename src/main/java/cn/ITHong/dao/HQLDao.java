package cn.ITHong.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ITHong.hibernate.base.util.HibernateUtils;
import cn.ITHong.struts2_hibernate.domain.Classes;
import cn.ITHong.struts2_hibernate.domain1.Student;

public class HQLDao extends HibernateUtils {
	static {
		//url = "cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
		url="cn/ITHong/struts2_hibernate/domain1/hibernate.cfg.xml";
		HibernateUtils hibernateUtils = new HibernateUtils();
		hibernateUtils.init();
	}
	/**
	 * url = "cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
	 * */
	public List<Classes> queryAllClasses() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> cList = session.createQuery("from Classes").list();
		transaction.commit();
		return cList;
	}
	/**
	 * url = "cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
	 * */
	public void quertyClassesByProperties(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> cList = session.createQuery("select Cid,CNAME from Classes").list();
		transaction.commit();
		
	}
	private HQLDao() {

	}
	/**
	 * url = "cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
	 * */
	public static HQLDao getInstance() {
		return new HQLDao();
	}
	public List<Student> queryClasses_Student_Course(){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String HQL = "";
		HQL = "from Student s  inner join fetch s.classes cs inner join fetch s.courses c";//1,2,1,1个数=4 不加去重
		//HQL = "from Student s left outer join fetch s.classes cs left outer join fetch s.courses c";//1,1,1,2,3,个数=5 不加去重
		List<Student> cList = session.createQuery(HQL).list();
		//去重开始
		Set<Student> sSet = new HashSet<Student>(cList);
		cList = new ArrayList<Student>(sSet);
		//去重结束	第一个HQL	1,2,个数=2 第二个HQL 1,3,2,个数=3
		for(Student student:cList){
			System.out.println(student.getSid());
		}
		System.out.println("个数="+cList.size());
		transaction.commit();
		return cList;
	}
}
