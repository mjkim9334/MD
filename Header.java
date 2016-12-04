
public class Header extends Node {

	String[] lines=null;
	int lineNum=0;
	String size=null;
	String htmlCode=null;
	String content=null;
	int tokenNum=0;
	public Header(Line line)
	{
		lineNum=line.getIndex();
		for(int i=0; i<lineNum; i++)
		{
			lines[i]=line.getSentence(i);
			
			
		}

		
	}
	
	public String toHTML()
	{
		int i=0;
		while(i<lineNum)
		{
		 
			if(lines[i].contains("###### ")){
				size="h6";
				content=lines[i].substring(7, lines[i].length());
			}
			else if(lines[i].contains("##### "))
			{
				size="h5";
				content=lines[i].substring(6, lines[i].length());
			}
			else if(lines[i].contains("#### "))
			{
				size="h4";
				content=lines[i].substring(5, lines[i].length());
			}
			else if(lines[i].contains("### "))
			{
				size="h3";
				content=lines[i].substring(4, lines[i].length());
			}
			else if(lines[i].contains("## "))
			{
				size="h2";
				content=lines[i].substring(3, lines[i].length());
			}
			else if(lines[i].contains("# "))
			{
				size="h1";
				content=lines[i].substring(2, lines[i].length());
			}
				
		}
		
		
		tokens.add(createToken());
		tokenNum++;
		
		htmlCode="<"+size+">"+tokens.get(0).getHtml()+"</"+size+">";
		
		return htmlCode; // 이걸 불러들이는 아이는 visitor 패턴
		
	}
	
	public Token createToken()
	{
		
		int i=0;
		int start=0;
		int end=0;
		String Token_text=null;
		String htmlCode=null;
		String PlainText=null;
		while(i<content.length())
		{
			
		
		   if(content.charAt(i)=='*')// header 안에 list가 있을 경우는 없으니까
		     	{
			
			      if(start==0) // 처음 임
			      {
			      start=i;	
			      }
			      else 
			      {
				   end=i;
			       Token_text=content.substring(start+1, end);
				   htmlCode="<e>"+Token_text+"</e>";
				   htmlCode=PlainText+htmlCode;
				   return new Emphasis(Token_text);
			      }
		  
			   }
		  else 
		    {
			   PlainText+=content.charAt(i);
			
		    }
		}

	}
	
	
}
