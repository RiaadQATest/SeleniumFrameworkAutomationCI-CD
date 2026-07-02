package riaadSeleniumFrameWork.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count=0;
	int maxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<maxTry)
		{
			count++;
			//System.out.println(">>> Retrying test: "+result.getName() +" | Attempt " +(count+1));
			return true;
		}
		
		return false;
	}

}
