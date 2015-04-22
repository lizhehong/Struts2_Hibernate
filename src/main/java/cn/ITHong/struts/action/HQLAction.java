package cn.ITHong.struts.action;

import java.util.List;

import cn.ITHong.dao.HQLDao;
import cn.ITHong.struts2_hibernate.domain.Classes;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HQLAction extends ActionSupport {
	public String getDataFromClasses() {
		HQLDao hqlDao = HQLDao.getInstance();
		List<Classes> cList =  hqlDao.queryAllClasses();
		ActionContext.getContext().put("cList", cList);
		return "allClasses";
	}
}
