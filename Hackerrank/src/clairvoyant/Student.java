package clairvoyant;

public class Student{
	
	   private String firstName;
	    
	    private String lastName;
	    
	    public Student(String firstname,String lastname){
	    	this.firstName=firstname;
	    	this.lastName=lastname;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName( String firstName ) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName( String lastName ) {
	        this.lastName = lastName;
	    }
	    
	    @Override
	    public boolean equals(Object o)
	    {
	    	if (!(o instanceof Student))
	    		return false;
	    	if (o==this)
	    		return true;
	    	
			return (this.lastName.equalsIgnoreCase(((Student)o).getLastName()));
				    	
	    }

	    @Override
	    public int hashCode()
	    {
	    	return lastName.hashCode();
	    }
}
