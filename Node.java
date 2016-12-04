import java.util.LinkedList;

public class Node {
	protected LinkedList<Token>tokens;

	public Node()
	{
		
	}
	
	public static Node instance(Line line)
	{
		

		
		switch(line.getmode()){
		case "Header":
			Header header=new Header(line);
			
		    return header;
		default: 
			return null;
			
			
		}
	}
	
	

	
	
}
