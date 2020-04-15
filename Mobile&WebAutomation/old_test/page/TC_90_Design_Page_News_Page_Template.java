package com.desktopWeb.scripts.page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_90_Design_Page_News_Page_Template extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC90_Design_Page_News_Page_Template(String emailid, String passwd, String project, String pagetemplate,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToNewsPage();
			type(DetailsPjName, "Testing Design", "Project Name");
			Thread.sleep(5000);
			designTemplate(pagetemplate);
			savePage();
			workflow(choice, "Testing Template");
			Reporter.SuccessReport("TC90_Design_Page_News_Page_Template", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC90_Design_Page_News_Page_Template", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 1"),
	    			xls.getCellValue("Password", "Value 1"),
	    			xls.getCellValue("Project", "Value 1"),
	    			xls.getCellValue("Page Template News Full", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Page/News_Page/Design Funtionality"
	    		}};
	}
}
