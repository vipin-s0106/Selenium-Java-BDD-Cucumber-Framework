package framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Setting {
	private Properties properties;
	private final String propertyFilePath= "D:\\Programs\\Cucumber.PhP.Automation\\Setting.properties";
	public Setting() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}
 
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 10;		
	}
 
	public String getApplicationUrl(String PHPTravel_URL) {
		String url = properties.getProperty(PHPTravel_URL);
		if(url != null) return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:PHPTravel_URL");
	}
 
	public String getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName != null) return browserName;
		else throw new RuntimeException("Browser name is not present in Setting.properies file with Key:browser");
	}
 
	public String getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName != null) return environmentName;
		else throw new RuntimeException("Environment Type Key value in Setting.properies is not matched : environment");
	}
	
	public String getMaximizestatus(){
		String Maximizestatus = properties.getProperty("windowMaximize");
		if(Maximizestatus!= null) return Maximizestatus;
		else throw new RuntimeException("Driver Path not specified in the Setting.properies file for the Key:windowMaximize");		
	}
	public String getOutputFolderPath() {
		String path = properties.getProperty("OutputFolderPath");
		if(path != null) return path;
		else throw new RuntimeException("Driver Path not specified in the Setting.properies file for the Key:OutputFolderPath");
	}
	
	public String getExtentReportConfigPath() {
		String path = properties.getProperty("extent_config_xml_path");
		if(path != null) return path;
		else throw new RuntimeException("Driver Path not specified in the Setting.properies file for the Key:extent_config_xml_path");
	}

}
