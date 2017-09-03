package com.acadgild.assignment3_3_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TaskReducer  extends Reducer<Text, IntWritable, Text, IntWritable>
{
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int maxVal = 0;
		for (IntWritable value : values) {
			
				maxVal = maxVal+value.get();
			
		}

		context.write(key, new IntWritable(maxVal));
	}
}
