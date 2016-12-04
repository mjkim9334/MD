import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.Reader;




public class Document {

	public static FileInputStream inputfileStream;
	public static FileInputStream outputfileStream;
	private String input_file_name;
	private String output_file_name;
	protected LinkedList<Node> nodes;
	private int nodeNum=0;
	
	
	public Document(String args) {
		this.input_file_name=args;
	}
	

	public Document() {
		
		nodes=new LinkedList<Node>();
	}


	public String getInputFile()
	{
		return input_file_name;
	}
	public void addNode(Node node)
	{
		this.nodes.add(node);
		nodeNum++;
	}
	
	public void accept(MDVisitor visitor)
	{
		for(int i=0; i<nodeNum; i++)
		{
			visitor.visit(nodes.get(i));
		}
	}


	
}
