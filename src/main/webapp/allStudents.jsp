<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有学生</title>
</head>
<body>
	<s:debug></s:debug>
	<s:iterator value="sList" var="students">
		<s:property value="sname"/>
		<s:property value="description"/>
		<s:iterator value="#students.courses" var="course">
			<s:property value="#course.cname"/>
			<s:property value="#course.desciprtion"/>
		</s:iterator>
		<s:iterator value="#students.classes" var="class">
			<s:property value="#class.cname"/>
			<s:property value="#class.desciprtion"/>
		</s:iterator><br/><hr/>
	</s:iterator>
</body>
</html>