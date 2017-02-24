

package org.usfirst.frc6357.SpringKonstant.commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import org.usfirst.frc6357.SpringKonstant.Auto;
import org.usfirst.frc6357.SpringKonstant.Robot;
import org.usfirst.frc6357.SpringKonstant.subsystems.DriveBaseSystem;
import org.usfirst.frc6357.SpringKonstant.subsystems.PositionAndVelocityControlledDrivetrainSide;

/**
 *
 */
public class AutoPlanParser
{
	public String fileName;
	
	private List<Integer> stepNum = new ArrayList<Integer>();
	private List<String> actions = new ArrayList<String>();
	private List<Double> values = new ArrayList<Double>();
	
    public AutoPlanParser(int autoPlan) throws FileNotFoundException, IOException 
    {
    	if(autoPlan == 1)
    		fileName = "AutoPlan1.txt";
    	else if(autoPlan == 2)
    		fileName = "AutoPlan2.txt";
    	else if(autoPlan == 3)
    		fileName = "AutoPlan3.txt";
    	else if(autoPlan == 4)
    		fileName = "AutoPlan4.txt";
    	else if(autoPlan == 5)
    		fileName = "AutoPlan5.txt";
    	else if(autoPlan == 6)
    		fileName = "AutoPlan6.txt";
    	
    	getValuesFromJson(getInputStream());
    	sendValues();
    }
    
    public void getValuesFromJson(InputStream in) throws IOException
    {
    	JsonReader reader = new JsonReader(new InputStreamReader(in, fileName));
    	try
    	{
    		readJson(reader);
    	}
    	finally
    	{
    		reader.close();
    	}
    }
    
    public void readJson(JsonReader reader) throws IOException
    {
    	reader.beginObject();
    	int spot = 0;
    	while(reader.hasNext())
    	{
    		String name = reader.nextName();
    		if(name.equals("Step"))
    			stepNum.add(spot, reader.nextInt());
    		else if(name.equals("Action"))
    			actions.add(spot, reader.nextString());
    		else if(name.equals("Value"))
    			values.add(reader.nextDouble());
    		else
    			reader.skipValue();
    		spot++;
    	}
    }
     
    public InputStream getInputStream() throws FileNotFoundException
    { 	
    	InputStream is = new FileInputStream("robot_code/SpringKonstant/" + fileName);
    	return is;
    }
    
    public void sendValues()
    {
    	Auto auto = new Auto(stepNum, actions, values);
    }
}
