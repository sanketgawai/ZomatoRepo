package qa.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
			ExtentReports extentReport = new ExtentReports();
		//*****2)https://extentreports.com/->DOCS->Version5->Java->gettingStarted->Reporters(these are diff type of report we use sparkrepoter)->copy code of ExtentSparkReporter->to add theam,Report name,doc name,date
			File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");//ye path likha hi folder banjayega wahape
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setReportName("TutorialNinja Test Automation Result");
			sparkReporter.config().setDocumentTitle("TN Automation Report");
			sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			
			extentReport.attachReporter(sparkReporter);
			
			extentReport.setSystemInfo("Application URL", "https://www.zomato.com/");
			extentReport.setSystemInfo("BrowserName", "Chrome");
			extentReport.setSystemInfo("Email", "kaido@gmail.com");
			extentReport.setSystemInfo("Pass", "kaido@123");
			
			extentReport.setSystemInfo("Operting System", System.getProperty("os.name"));
			extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
			extentReport.setSystemInfo("UserName", System.getProperty("user.name"));
			extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
			
			return extentReport;
	}
			
}
