package com.acadgild.assignment3_3_1;

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		try
		{
			
			Job job = new Job(conf, "Assignment 3.3 Task 1");
			job.setJarByClass(Task.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			job.setMapperClass(TaskMapper.class);
			job.setReducerClass(TaskReducer.class);
			 
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			FileInputFormat.addInputPath(job, new Path(args[0])); 
			FileOutputFormat.setOutputPath(job,new Path(args[1]));
			
			/*
			Path out=new Path(args[1]);
			out.getFileSystem(conf).delete(out);
			*/
			
			job.waitForCompletion(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
