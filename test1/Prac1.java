package fuckthistest;
import java.util.*;
/**
 * The application class for the first 241 practical test.
 * @author Iain Hewson
 */
public class Prac1 {
  /** A list of people to be operated on. */
  private List<Person> people = new ArrayList<>();
  /**
   * Creates an instance of Prac1 and sends lines of input read from
   * stdin to its processLine() method. Each line of input is
   * separated into the first word and the remainder of the line.
   * @param args command line arguments are not used.
   */
  public static void main(String[] args) {
    Prac1 app = new Prac1();
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      String[] line = input.nextLine().trim().split(" ", 2);
      String command = line[0];
      String remainder = line.length > 1 ? line[1] : "";
      app.processLine(command, remainder);
    } 
  }
  
  public void processLine(String command, String line) {
    // If the command is "add" then create a new person p and update their
// details using updatePerson(p, line). Add the person to the people
// list and print "Added: " + p
    if(command.equals("add")){
      Person p = new Person();
      updatePerson(p, line);
      
      people.add(p);
      System.out.println("Added" + p); 
    }
       
       
       
       
// If the command is "find" followed by an integer that matches the id
// of a person in the list of people, print "Found: " + person
       
       if(command.equals("find") && !line.isEmpty()){
         for ( Person p : people ){
           if(Integer.parseInt(line) == p.getId()){
             System.out.println("Found " + p.toString());
           }
         }
       }
       
       
       
       
       
       
       
       
       
       
// If the command is "remove" followed by an integer that matches the id
// of a person in the list of people, print "Removed: " + person and
// remove that person from the list of people        
       if(command.equals("remove") && !line.isEmpty()){
         for(Person p : people){
           if(Integer.parseInt(line) == p.getId()){
             people.remove(p);
             System.out.println("Removed: " + p.toString());
           }
         }
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
         
// If the command is "children" followed by a string, take the string
// to be the name of a sport and print out the id and name of every
// person in the list who has children and has the given sport in
// their list of sports
       if(command.equals("children") && !line.isEmpty()){
         for(Person p : people) {
           if(p.getChildren() && p.toString().contains(line)){
             System.out.println(p.getId() + ": " + p.getName());
           }
         }
       }
       
       
// If the command is "older" followed by an integer, print out the name and
// age of every person with an age greater than the given integer 
       if(command.equals("older" && !line.isEmpty())){
         for(Person p : people) {
           if(p.getAge() > Integer.parseInt(line)){
             System.out.println(p.getName() + " Age: " + p.getAge());
           }
         }
         
       }
       
//print command stuff   
    if (command.equals("print")) {
      System.out.println("Printing all");
      for (Person p : people) {
        System.out.println(p);
      }
    } 
  }
  
  private void updatePerson(Person p, String details) {
    String[] attributes = details.trim().split(",");
    for (String item : attributes) {
      Scanner s = new Scanner(item);
      if (s.hasNext()) {
        String selector = s.next().toLowerCase();
        
        switch(selector){
          case "name":
            p.setName(s.next());
            break;
            
          case "age":
            p.setAge(s.nextInt());
            break;
            
          case: "children":
            p.setChildren(s.nextBoolean());
            break;
            
          case: "sports":
            while(s.hasNext()){
            p.addSports(s.next());
          }
            break;
            
            
          default:
            "Unknown attribute: " + selector;         
          
        }
// switch based on selector as follows:
// if selector is "name" and if the scanner has another item, set // the name of person to that item
// if selector is "age" and the next item in the scanner is an
// integer, set the age of person to that integer
// if selector is "children" and the next item in the scanner is a // boolean, set the children attribute of person to that boolean 
// if selector is "sports" add all following items to the person’s // list of sports
// Otherwise print out "Unknown attribute: " + selector
      } 
    } 
  } 
}