package com.desktopWeb.scripts.page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_77_SEO_Site_Sub_Page_Name extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Setting");
	
	@Test(dataProvider = "testData")
	public void TC77_SEO_Site_Sub_Page_Name(String emailid, String passwd, String project, String newname,
			String choice, String testdescription) throws Throwable {
		try{
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateToSiteSubPage();
			seoName(newname);
			savePage();
			workflow(choice, "Testing SEO");
			Reporter.SuccessReport("TC77_SEO_Site_Sub_Page_Name", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC77_SEO_Site_Sub_Page_Name", "Failed");
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
	    			xls.getCellValue("SEO Meta Desc", "Value 1"),
	    			xls.getCellValue("WorkFlow", "Value 1"),
	    			"Verify Authoring/Page/Site_Sub_Page/SEO Funtionality"
	    		}};
	}
}
