/* Write a program that interact with weather dataset. Find the day and station with maximum snowfall in year 2013.
Lab: Laboratory Practice - I
Program by: Tushar B. Kute
tushar@tusharkute.com
http://tusharkute.com */
 
import java.io.IOException;
import java.util.*;        
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
        
public class Snow {        
 public static class Map extends Mapper<LongWritable, Text, Text, FloatWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       		String line = value.toString();
			String dateStation = null;
			float snow = 0.0f;
			StringTokenizer s = new StringTokenizer(line,",");
			String date = s.nextToken();
			if(date.startsWith("2013")) {
				String station = s.nextToken();
				String temp = s.nextToken();
				temp = s.nextToken();
				temp = s.nextToken();
				temp = s.nextToken();	
				snow = Float.parseFloat(temp);	
				dateStation = "Date: " + date + ", Station: " + station;
				if(snow!=0.0f)
					context.write(new Text(dateStation), new FloatWritable(snow));
			}
    	}
 } 
        
 public static class Reduce extends Reducer<Text, FloatWritable, Text, FloatWritable> {
	float max = 0.0f;
	Text date = new Text();
    public void reduce(Text key, Iterable<FloatWritable> values, Context context) 
      throws IOException, InterruptedException {	
			for (FloatWritable val : values) {
					float num = val.get();
					if(num > max) {
						max = num;				
						date = key;	
					}
			}
    }
 public void cleanup(Context context) throws IOException, InterruptedException {
			context.write(new Text("Max snowfall in 2013:"),new FloatWritable(0.0f));
			context.write(date, new FloatWritable(max));
		}
 }
        
 public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = new Job(conf, "Snowfall");
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(FloatWritable.class);
        
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
        
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
        
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
    job.waitForCompletion(true);
 }     
}
