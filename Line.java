import java.util.LinkedList;

public class Line {

	private int sentence_num;
	private LinkedList<String>sentence;
	private String mode;
	private int index;
	
	
	public Line(String mode)
	{
		this.sentence_num=0;
		this.mode=mode;
		this.index=0;
		sentence=new LinkedList<>();
	}
	
	public void concat(String line)
	{
		this.sentence_num++;
		sentence.add(line+"\n");
	}
	public String getmode()
	{
		return mode;
	}
	
	public String getSentence(int index)
	{
		return this.sentence.get(index);
	}

	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	
}
