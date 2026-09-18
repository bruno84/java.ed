package java_basico;

public class MyExceptionUnchecked extends RuntimeException
{
	private static final long serialVersionUID = 4652958143051993454L;

	private String description = "";
	
	public MyExceptionUnchecked(String description)
	{
        super(description);
        
        this.description = description;
    }
	
	public String getDescription() {
		return description;
	}

}