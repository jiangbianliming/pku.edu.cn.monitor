package com.pku.exception;

//自定义异常MyException，定义自定义异常在struts.xml中才好配置，才好处理
//Action中成功据return "success"; 失败不再return "error"什么的，而是throw new DangException();
//抛出给框架处理，框架在struts.xml找到global-exception-mappings找到有MyException
//再找到对应的result="error",在global-results中找到错误跳转页面error.jsp

public class MyException extends Exception{

}
