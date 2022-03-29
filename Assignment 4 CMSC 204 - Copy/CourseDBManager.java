import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

    private final CourseDBStructure data;

    public CourseDBManager(){
        data = new CourseDBStructure(20);
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        data.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }

    @Override
    public CourseDBElement get(int crn) {
        try{
            return data.get(crn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextLine()){
            String[] lines = scanner.nextLine().split(" ");

            String course = lines[0];
            int crn = Integer.parseInt(lines[1]);
            int credits = Integer.parseInt(lines[2]);
            StringBuilder instructor_build = new StringBuilder();

            for(int i=4;i<lines.length;i++){
                instructor_build.append(lines[i]).append(" ");
            }
            String instructor = instructor_build.toString().trim();

            String room = lines[3];

            data.add(new CourseDBElement(course, crn, credits, room, instructor));
        }
        scanner.close();
    }

    @Override
    public ArrayList<String> showAll() {
        return data.showAll();
    }
}
