package com.desktopWeb.scripts.sprint1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_162_Verify_Page_News_Page_Version_Duplicate_Pa extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Sprint");
	
	@Test(dataProvider = "testData")
	public void TC162_Verify_Page_News_Page_Version_Duplicate_Pa(String emailid, String passwd, String project, 
			String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToNewsPage();
			type(DetailsPjName, "Testing Version Duplicate", "Project Name");
			pageLocation(project);
			Thread.sleep(5000);
			duplicateVersion();
			Reporter.SuccessReport("TC162_Verify_Page_News_Page_Version_Duplicate_Pa", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC162_Verify_Page_News_Page_Version_Duplicate_Pa", "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("Email Id", "Value 3"),
	    			xls.getCellValue("Password", "Value 3"),
	    			xls.getCellValue("Project", "Value 3"),
	    			"Verify Authoring/Page/News_Page/Version Duplicate functionality by Project Author"
	    		}};
	}
}
