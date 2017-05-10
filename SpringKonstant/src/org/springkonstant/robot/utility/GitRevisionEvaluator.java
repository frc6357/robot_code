package org.springkonstant.robot.utility;

import java.util.Properties;

public class GitRevisionEvaluator 
{
	public static String GetGitRevision()
	{
		Properties myProps = new Properties();
		return myProps.getProperty("git.revision");
	}
}
