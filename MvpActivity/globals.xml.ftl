<?xml version="1.0"?>
<globals>
	<#assign Collection=extractLetters(ActivityClass)?cap_first>//从输入的title中获取输入字符
    <#assign collection_name=Collection?lower_case>//获取到的字符转成小写
    <#assign Model=extractLetters(ActivityModel)>//从输入的model中获取输入字符
    <#assign Model_name=Model?lower_case>//获取到的字符转成小写
    <#assign DATE= .now>

	<!-- 这里声明全局变量-->
	<global id="activity_layout" value="${Collection?lower_case}" />//作为activity的layout的命名
    <global id="ActivityName" value="${Collection}Activity" />//作为activity类名
    <global id="PresenterName" value="${Collection}Impl" />//作为presenter类名
    <global id="ModelName" value="${Collection}Model" />//作为model类名
    <global id="ContractName" value="${Collection}Contract" />//作为contract类名
    <global id="BeanName" value="${Collection}Bean" />//作为bean包名
	<global id="Model" value="${Model_name}" />//作为model类名
	<global id="packageName" value="com.j1ang.temp" />//项目包名
	<global id="DATE" value="${DATE}" />//时间
</globals>
