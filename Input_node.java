
public class Input_node 
{
	private String activity;
	private String dependency;
	private int duration;
	private int index;
	private Input_node next;
	
	Input_node()
	{
		activity = "";
		dependency = "";
		duration = 0;
		index = 0;
		next = null;
		
	}
	
	Input_node(String a, String b, int c, int d)
	{
		activity = a;
		dependency = b;
		duration = c;
		index = d;
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
	
	public int get_index()
	{
		return index;
	}
	
	public Input_node get_next()
	{
		return next;
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
	
	public void set_index(int num)
	{
		index = num;
	}
	
	public void set_next(Input_node node)
	{
		next = node;
	}
}
