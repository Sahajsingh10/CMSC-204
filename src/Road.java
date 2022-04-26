public class Road implements Comparable<Road> {

	Town source;
	Town destination;
	String name;
	int weight;

	public Road(Town source, Town destination, int weight, String name) {
		this.name = name;
		this.destination = destination;
		this.weight = weight;
		this.source = source;
	}

	public Road(Town source, Town destination, String name) {
		this(source, destination, 0, name);
		weight = 1;
	}
	public int getWeight() {
		return this.weight;
	}

	
	public boolean equals(Object r) {
		
		Road road = (Road) r;
        return (road.destination.equals(this.destination) 
                && road.source.equals(this.source)) || 
                (road.destination.equals(this.source) 
                && road.source.equals(this.destination));
	}

	public boolean graphEquals(Object r){
		assert r instanceof Road;
		Road road = (Road) r;
		boolean isEqual = true;

		if (!(road.source == this.source && road.destination == this.destination)){
			if (!(road.source == this.destination && road.destination == this.source)){
				isEqual = false;
			}
		}

		if (road.name != null){
			if (!road.name.equals(this.name)){
				isEqual = false;
			}
		}

		if (road.weight >= 1){
			if (!(road.weight == this.weight)){
				isEqual = false;
			}
		}

		return isEqual;

	}
	public Town getDestination() {
		return destination;
		
	}
	public Town getSource() {
		return source;
	}

	public boolean contains(Town town) {
		return source.name.equals(town.name) ||
                destination.name.equals(town.name);
	}
	@Override
    public String toString() {
        return name + "," + weight + ";" + source + ";" + destination;
    }
	public String getName() {
		return this.name;
	}
	
	public int compareTo(Road o) {
		if (name.compareTo(o.name) == 0) {
			return 0 ;
		}
		else {
			return -1;
		}
	}
}