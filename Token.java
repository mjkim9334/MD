

public class Token {

	String text=null;
	
	public Token()
	{
		
	}
	
	public Token(String text)
	{
		this.text=text;
	}
	
	public String getHtml()
	{
		System.out.println(text);
		return this.text;
	}
	
}
