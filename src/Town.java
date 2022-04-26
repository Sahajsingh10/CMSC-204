import java.util.*;

public class Town implements Comparable<Town> {
	String name;
	Town templateTown;
	
    
  
    
	public Town(String name) {
		this.name = name;
		   
		
	}

	 public Town(Town template )
	   {
	    this.templateTown = templateTown.templateTown;
	   }
	 
	

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Town [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return name.hashCode();
		}
	
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		return Objects.equals(name, other.name);
	}
	

	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.name);
	}



}
