
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;




public class MDParser {

	public static FileInputStream inputfileStream;
	public static FileInputStream outputfileStream;
	
	
	public MDParser(){
		
	}
	public void make_node_list(Document document){
		Document doc=new Document();
		try{
			BufferedReader in=new BufferedReader(new FileReader(doc.getInputFile()));
			String sentence=in.readLine();
			
			while(sentence!=null)
			{
				
			    String mode =getMode(sentence);
			    Line line=new Line(mode); // have to create line
			    
			    
			    
			    if(mode=="Header")
			    {
			    	while(mode=="Header")
			    	{
			    		line.concat(sentence); // 두 줄 이상 읽을 때를 대비
			    		sentence=in.readLine();
			    		mode=getMode(sentence);
			    		
			    		// if it's not header, check the mode from the very first (the first while stmt)
			    	}
			    }
			    
			    document.addNode(Node.instance(line));
			    
			}
			
		}catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
	
	
	public static String getMode(String line)
	{
		String mode = null;
		
		if(line==null)
		{
			mode="Empty";
			
		}
		else if(line.contains("# ")) // atx header
		{
			mode="Header";
			
		}
		return mode;
	}
}
