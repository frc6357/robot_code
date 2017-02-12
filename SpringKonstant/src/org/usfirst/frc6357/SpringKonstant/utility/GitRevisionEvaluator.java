package org.usfirst.frc6357.SpringKonstant.utility;

import java.util.Properties;

public class GitRevisionEvaluator {
	static String GetGitRevision(){
		Properties myProps = new Properties();
		return myProps.getProperty("git.revision");
	}
}
