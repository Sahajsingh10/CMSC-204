import java.util.Objects;

public class CourseDBElement implements Comparable {

	private String ID;
	private int crn;
	private int numCredits;
	private String RoomNum;
	private String nameInstruct;

	public CourseDBElement(String ID, int crn, int numCredits, String RoomNum, String nameInstruct) {

		this.ID = ID;
		this.crn = crn;
		this.numCredits = numCredits;
		this.RoomNum = RoomNum;
		this.nameInstruct = nameInstruct;
	}

	public CourseDBElement() {
		this(null, 0, 0, null, null);
	}

	public String getID() {
		return ID;
	}

	public void setID(String courseId) {
		this.ID = courseId;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	public String getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(String numRoom) {
		this.RoomNum = numRoom;
	}

	public String getNameInstruct() {
		return nameInstruct;
	}

	public void setNameInstruct(String nameInstruct) {
		this.nameInstruct = nameInstruct;
	}

	public String toString() {
		return "Course:" + ID + " CRN:" + crn + " Credits:" + numCredits + " Instructor:" + nameInstruct + " Room:" + RoomNum;
	}

	public int hashCode() {
		String s = Integer.toString(crn);
		return s.hashCode();
	}

	@Override
	public int compareTo(CourseDBElement o) {
		if (o.crn < this.crn) {
			return 1;

		} else if (o.crn > this.crn) {
			return -1;

		}
		return 0;
	}

}