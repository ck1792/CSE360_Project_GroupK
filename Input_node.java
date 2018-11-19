/*
Input_node.java by Kai Chen
version 1.2
*/


public class Input_node 
{
	private String activity;
	private String dependency;
	private int duration;
	/*
	 * version 1.1
	 */
//	private int index;
//	private Input_node next;
	/*
	 * version 1.2
	 */
	private boolean mark;
	
	Input_node()
	{
		activity = "";
		dependency = "";
		duration = 0;
//		index = 0;
//		next = null;
		mark = false;
	}
	
	Input_node(String a, String b, int c)
	{
		activity = a;
		dependency = b;
		duration = c;
	}
	
	public String get_activity()
	{
		return activity;
	}
	
	public String get_dependency()
	{
		return dependency;
	}
	
	public int get_duration()
	{
		return duration;
	}
	
//	public int get_index()
//	{
//		return index;
//	}
	
//	public Input_node get_next()
//	{
//		return next;
//	}
	
	public boolean get_mark()
	{
		return mark;
	}
	
	public void set_activity(String str)
	{
		activity = str;
	}
	
	public void set_denpendency(String str)
	{
		dependency = str;
	}
	
	public void set_duration(int num)
	{
		duration = num;
	}
	
//	public void set_index(int num)
//	{
//		index = num;
//	}
	
//	public void set_next(Input_node node)
//	{
//		next = node;
//	}
	
	public void set_mark(boolean m)
	{
		mark = m;
	}
}
