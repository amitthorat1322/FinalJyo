package testCasePages;

import org.testng.annotations.AfterClass;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TBase;
import pages.PracticePage;

public class PracticePageTest extends TBase{
	
	
	PracticePage practicePage;

	public void Setup()
	{
		initalization();
	
		practicePage = new PracticePage();
	}
	
	@Test
	public void testTextBox()
	{
		practicePage.TextBox();
		String expected = "Amit Jain";
		String actual = practicePage.getUserNameValue();
		Assert.assertEquals(actual,expected);
	}
	
	


}
