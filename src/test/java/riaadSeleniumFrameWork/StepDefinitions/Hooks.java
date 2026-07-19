package riaadSeleniumFrameWork.StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import riaadSeleniumFrameWork.TestComponents.BaseTest;
import riaadSeleniumFrameWork.pageObject.LandingPage;

public class Hooks extends BaseTest {

	@Before
	public void setUp() throws IOException {
		driver = initializerDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
