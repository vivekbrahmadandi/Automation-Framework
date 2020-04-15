package com.desktopWeb.scripts.tools;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_37_Add_Visioner_Input extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Test Data - Tools");
	
	@Test(dataProvider = "testData")
	public void TC37_Add_Visioner_Input(String emailid, String passwd, String project, String question, 
			String questiondesc, String testdescription) throws Throwable {
		try{	
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			handleAuthPopup();
			login(emailid, passwd, "Menu");
			Thread.sleep(5000);
			navigateConsultation(project);
			saveEditPage();
			addVisionerInput(question, questiondesc);
			Reporter.SuccessReport("TC37_Add_Visioner_Input", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC37_Add_Visioner_Input", "Failed");
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
	    			xls.getCellValue("Question", "Value 1"),
	    			xls.getCellValue("Question Desc", "Value 1"),
	    			"Verify Add input Visioner to page"
	    		}};
	}

}
