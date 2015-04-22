package cn.ITHong.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ITHong.hibernate.base.util.HibernateUtils;
import cn.ITHong.struts2_hibernate.domain.Classes;

public class HQLDao extends HibernateUtils {
	static {
		url = "cn/ITHong/struts2_hibernate/domain/hibernate.cfg.xml";
		HibernateUtils hibernateUtils = new HibernateUtils();
		hibernateUtils.init();
	}

	public List<Classes> queryAllClasses() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> cList = session.createQuery("from Classes").list();
		transaction.commit();
		return cList;
	}

	private HQLDao() {

	}

	public static HQLDao getInstance() {
		return new HQLDao();
	}
}
