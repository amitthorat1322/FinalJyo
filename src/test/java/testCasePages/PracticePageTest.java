package testCasePages;
import org.testng.annotations.Test;
import org.testng.Assert;
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
