package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_152_Verify_Page_News_Page_Version_Approve_En extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC152_Verify_Page_News_Page_Version_Approve_En(String emailid, String passwd, String project, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToNewsPage();
			pageLocation(project);
			detailName("Testing Version Approve");
			savePage();
			workflow("submittoworkflow", "Testing");
			navigateToSetting();
			approveVersion();
			Reporter.SuccessReport("TC152_Verify_Page_News_Page_Version_Approve_En", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC152_Verify_Page_News_Page_Version_Approve_En", "Failed");
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
	    			"Verify Authoring/Page/News_Page_Version Approve funtionality by Engagement Manager"
	    		}};
	}
}
