
public class PlainVisitor extends MDVisitor {

	PlainVisitor()
	{
		
	}
		
	public void visit(Node node)
	{
		System.out.println(node.toHTML);
		System.out.println("\n");
		
	}
}
