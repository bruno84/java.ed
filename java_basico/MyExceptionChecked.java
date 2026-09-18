package java_basico;

public class MyExceptionChecked extends Exception
{
	private static final long serialVersionUID = 4652958143051993454L;

	private String description = "";

	public MyExceptionChecked(String description)
	{
        super(description);
        
        this.description = description;
    }
	
	public String getDescription() {
		return description;
	}

}