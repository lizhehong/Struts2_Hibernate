package cn.ITHong.struts.action;

import java.util.List;

import cn.ITHong.dao.HQLDao;
import cn.ITHong.struts2_hibernate.domain.Classes;
import cn.ITHong.struts2_hibernate.domain1.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HQLAction extends ActionSupport {
	public String getDataFromClasses() {
		HQLDao hqlDao = HQLDao.getInstance();
		List<Classes> cList =  hqlDao.queryAllClasses();
		ActionContext.getContext().put("cList", cList);
		return "allClasses";
	}
	public String getDataFrom_S_Cl_C(){
		HQLDao hqlDao = HQLDao.getInstance();
		List<Student> sList = hqlDao.queryClasses_Student_Course();
		ActionContext.getContext().put("sList", sList);
		return "onetomanytomany";
	}
}
