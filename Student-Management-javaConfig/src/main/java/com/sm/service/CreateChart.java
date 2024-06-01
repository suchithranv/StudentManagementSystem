package com.sm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sm.api.ChatData;

import fusioncharts.FusionCharts;

@Component
public class CreateChart {
	private static final Logger log = LogManager.getLogger(CreateChart.class.getName());
	
	public  FusionCharts prepareChart1( List<ChatData> chartDataList1) {
	
	Map<String, Integer> chartDataMap = new HashMap<>();
    for (ChatData c : chartDataList1) {
    	chartDataMap.put(c.getCourse(), c.getCount());
    }
    
    log.info("chartDataMap1 :" +chartDataMap);
    
    Map<String, String> chartConfig = new HashMap<String, String>();
    chartConfig.put("caption", "Student Data by Course");
    chartConfig.put("xAxisName", "Course");
    chartConfig.put("yAxisName", "Number of students");
    chartConfig.put("theme", "fusion");
    
    StringBuilder jsonData = new StringBuilder();
    StringBuilder data = new StringBuilder();
          
    // json data to use as chart data source
    jsonData.append("{'chart':{");
    for(Map.Entry conf:chartConfig.entrySet())
    {
        jsonData.append("'" + conf.getKey()+"':'"+conf.getValue() + "',");
    }
    jsonData.replace(jsonData.length() - 1, jsonData.length() ,"},");
    
    
    // build  data object from label-value pair
    data.append("'data':[");
    for(Map.Entry pair:chartDataMap.entrySet())
    {
        data.append("{'label':'" + pair.getKey() + "','value':'" + pair.getValue() +"'},");
    }
    data.replace(data.length() - 1, data.length(),"]");
    jsonData.append(data.toString());
    jsonData.append("}");
    
    log.info("jsonData :" +jsonData);
    
    log.info("data :" +data);
    
    // Create chart instance
    // charttype, chartID, width, height,containerid, data format, data
    FusionCharts firstChart = new FusionCharts(
        "column2d",
        "first_chart",  //id
        "450", //width
        "300",  //len
        "chart",
        "json",
        jsonData.toString()
    );
	return firstChart;  
}

	public FusionCharts prepareChart2(List<ChatData> chartDataList2) {
		
		Map<String, Integer> chartDataMap = new HashMap<>();
	    for (ChatData c : chartDataList2) {
	    	chartDataMap.put(c.getCourse(), c.getCount());
	    }
	    
	    log.info("chartDataMap2 :" +chartDataMap);
	    
	    Map<String, String> chartConfig = new HashMap<String, String>();
	    chartConfig.put("caption", "Student Data by Country");
	    chartConfig.put("xAxisName", "Country");
	    chartConfig.put("yAxisName", "Number of students");
	    chartConfig.put("theme", "palette");
	    
	    StringBuilder jsonData = new StringBuilder();
	    StringBuilder data = new StringBuilder();
	          
	    // json data to use as chart data source
	    jsonData.append("{'chart':{");
	    for(Map.Entry conf:chartConfig.entrySet())
	    {
	        jsonData.append("'" + conf.getKey()+"':'"+conf.getValue() + "',");
	    }
	    jsonData.replace(jsonData.length() - 1, jsonData.length() ,"},");
	    
	    
	    // build  data object from label-value pair
	    data.append("'data':[");
	    for(Map.Entry pair:chartDataMap.entrySet())
	    {
	        data.append("{'label':'" + pair.getKey() + "','value':'" + pair.getValue() +"'},");
	    }
	    data.replace(data.length() - 1, data.length(),"]");
	    jsonData.append(data.toString());
	    jsonData.append("}");
	    
	    log.info("jsonData :" +jsonData);
	    
	    log.info("data :" +data);
	    
	    // Create chart instance
	    // charttype, chartID, width, height,containerid, data format, data
	    FusionCharts secondChart = new FusionCharts(
	        "column2d",
	        "second_chart",  //id
	        "450", //width
	        "300",  //len
	        "chart1",
	        "json",
	        jsonData.toString()
	    );
		return secondChart;  
		
	}
	
	
	
	public FusionCharts prepareChart3(List<ChatData> chartDataList2) {
		
		Map<String, Integer> chartDataMap = new HashMap<>();
	    for (ChatData c : chartDataList2) {
	    	chartDataMap.put(c.getCourse(), c.getCount());
	    }
	    
	    log.info("chartDataMap2 :" +chartDataMap);
	    
	    Map<String, String> chartConfig = new HashMap<String, String>();
	    chartConfig.put("caption", "Student Data by Country");
	    chartConfig.put("yaxisname", "Number of students");
	    chartConfig.put("rotatelabels", "1");  //rotate x-axis label at 90 degree
	    chartConfig.put("setadaptiveymin", "1");   // if y axis value ranges from 27 to 49. min value will be 20
	    chartConfig.put("theme", "umber");
	    
	    StringBuilder jsonData = new StringBuilder();
	    StringBuilder data = new StringBuilder();
	          
	    // json data to use as chart data source
	    jsonData.append("{'chart':{");
	    for(Map.Entry conf:chartConfig.entrySet())
	    {
	        jsonData.append("'" + conf.getKey()+"':'"+conf.getValue() + "',");
	    }
	    jsonData.replace(jsonData.length() - 1, jsonData.length() ,"},");
	    
	    
	    // build  data object from label-value pair
	    data.append("'data':[");
	    for(Map.Entry pair:chartDataMap.entrySet())
	    {
	        data.append("{'label':'" + pair.getKey() + "','value':'" + pair.getValue() +"'},");
	    }
	    data.replace(data.length() - 1, data.length(),"]");
	    jsonData.append(data.toString());
	    jsonData.append("}");
	    
	    log.info("jsonData :" +jsonData);
	    
	    log.info("data :" +data);
	    
	    // Create chart instance
	    // charttype, chartID, width, height,containerid, data format, data
	    FusionCharts thirdChart = new FusionCharts(
	        "line",
	        "third_chart",  //id
	        "450", //width
	        "300",  //len
	        "chart2",
	        "json",
	        jsonData.toString()
	    );
		return thirdChart;  
		
	}

	public FusionCharts prepareChart4(List<ChatData> chartDataList1) {
		
		Map<String, Integer> chartDataMap = new HashMap<>();
	    for (ChatData c : chartDataList1) {
	    	chartDataMap.put(c.getCourse(), c.getCount());
	    }
	    
	    log.info("chartDataMap1 :" +chartDataMap);
	    
	    Map<String, String> chartConfig = new HashMap<String, String>();
	    chartConfig.put("caption", "Student Data by Course");
	    chartConfig.put("showlegend", "1");   //1: show legend , 0: off legend
	    chartConfig.put("showpercentvalues", "0");   // 1: values are displayed as percentages, 0: absolute values
	    chartConfig.put("legendposition", "bottom");  //bottom, left, right, top
	    chartConfig.put("usedataplotcolorforlabels", "1"); //0: default color to labels, 1:  labels are colored to match the data plot color
	    chartConfig.put("theme", "candy");
	    
	    StringBuilder jsonData = new StringBuilder();
	    StringBuilder data = new StringBuilder();
	          
	    // json data to use as chart data source
	    jsonData.append("{'chart':{");
	    for(Map.Entry conf:chartConfig.entrySet())
	    {
	        jsonData.append("'" + conf.getKey()+"':'"+conf.getValue() + "',");
	    }
	    jsonData.replace(jsonData.length() - 1, jsonData.length() ,"},");
	    
	    
	    // build  data object from label-value pair
	    data.append("'data':[");
	    for(Map.Entry pair:chartDataMap.entrySet())
	    {
	        data.append("{'label':'" + pair.getKey() + "','value':'" + pair.getValue() +"'},");
	    }
	    data.replace(data.length() - 1, data.length(),"]");
	    jsonData.append(data.toString());
	    jsonData.append("}");
	    
	    log.info("jsonData :" +jsonData);
	    
	    log.info("data :" +data);
	    
	    // Create chart instance
	    // charttype, chartID, width, height,containerid, data format, data
	    FusionCharts fourthChart = new FusionCharts(
	        "pie2d",
	        "fourth_chart",  //id
	        "450", //width
	        "300",  //len
	        "chart3",
	        "json",
	        jsonData.toString()
	    );
		return fourthChart; 
	}
	
	
	
}
