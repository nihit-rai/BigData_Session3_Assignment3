package com.acadgild.assignment3_3_1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class TaskMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	Text key;
	IntWritable value;
	
	@Override
	public void setup(Context context) {
		key = new Text();
		value = new IntWritable();
	}
	
	@Override
	public void map(LongWritable mkey, Text mvalue, Context context) 
			throws IOException, InterruptedException {
		/*String[] lineArray = mvalue.toString().split("|");
		StringTokenizer st = new StringTokenizer(mvalue.toString(),"|");*/
		TvBean tv = convertLineToBean(mvalue);
		String compName = tv.getCompanyName().toString();
		String prodCd = tv.getProduct().toString();
				
		if(!"NA".equals(compName))
		{
			if(!"NA".equals(prodCd))
			{
			key.set(tv.getCompanyName());
			value.set(1);
			
			context.write(key, value);
			
			}
		}
		else
		{
			System.out.println("contains NA -"+mvalue);
		}
	}
	
	public TvBean convertLineToBean(Text line)
	{
		StringTokenizer st = new StringTokenizer(line.toString(),"|");
		
		TvBean tvBean = new TvBean(st.nextToken().toString(), st.nextToken().toString(), st.nextToken().toString(), st.nextToken().toString(), st.nextToken().toString(), st.nextToken().toString());
		return tvBean;
	}
}
