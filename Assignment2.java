import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * This class reads the information of 60 Students, their firstname,lastname,
studentid,assignment1number,assignment2number,assignment3number
and then calculates their total mark for each student from the assessment marks and prints the result.

 *Print the list of students with the total marks less than a certain threshold.
 *Print the top 10 students with the highest total marks and top 10 students with the lowest total marks.
 *
 * @author (Babar Jawad)
 * @version (1/04/2022)
 */
public class Assignment2
{
    // instance variables - replace the example below with your own
    String line;   
    int lineNumber;
    Double result;
    String[] tokens;
    String unitName;
    private ArrayList<String> firstNames;
    private ArrayList<String> lastNames;
    private ArrayList<Integer> studentIds;
    private ArrayList<Double> assignment1Numbers;
    private ArrayList<Double> assignment2Numbers;
    private ArrayList<Double> assignment3Numbers;
    private ArrayList<Double> totalMarksAssignments;
    private ArrayList<String> titles;

    /**
     * Constructor for objects of class assignment2
     */
    public Assignment2()
    {
        // initialise instance variables
        lineNumber=0;
        firstNames=new ArrayList<String>();
        lastNames=new ArrayList<String>();
        studentIds=new ArrayList<Integer>();
        assignment1Numbers=new ArrayList<Double>();
        assignment2Numbers=new ArrayList<Double>();
        assignment3Numbers=new ArrayList<Double>();
        totalMarksAssignments=new ArrayList<Double>();
        titles=new ArrayList<String>();

        try{
            File myFile=new File("prog5001_students_grade_2022.csv");
            Scanner myScanner=new Scanner(myFile);
            while(myScanner.hasNextLine()){
                line=myScanner.nextLine();
               
                if(lineNumber==0||lineNumber>1){     
                    tokens = line.split(",");
                    readCsv();
                }
                lineNumber++;

            }
            myScanner.close();
        }catch(FileNotFoundException e){
            System.out.println("The file cannot be found");
            e.printStackTrace();
        }

    }

    /**
     * Method readCsv
     * This method read the length of file data on one row and choose the case according to length then read the data.
     * Adding data in arrays 
     * @param 
     * @return
     */
    public void readCsv(){

        switch (tokens.length) {

            case 1:        // if token length is 1
                try{
                    unitName=tokens[0];
                }catch(Exception e){
                    unitName= " ";
                }
                break;   // end of case 1

            case 6:                      // if tokens length is 6
    
                try{
                    lastNames.add(tokens[0]);
                }catch(Exception e){
                    lastNames.add(" "); 
                }
                try{
                    firstNames.add(tokens[1]);
                }catch(Exception e){
                    firstNames.add(" ");
                }
                try{
                    studentIds.add(Integer.valueOf(tokens[2]));
                }catch(Exception e){
                    studentIds.add(0);
                }
                try{
                    assignment1Numbers.add( Double.valueOf(tokens[3]));
                }catch(NumberFormatException e){
                    assignment1Numbers.add( 0.0); 
                }
                try{
                    assignment2Numbers.add( Double.valueOf(tokens[4]));
                }catch(NumberFormatException e){
                    assignment2Numbers.add( 0.0); 
                }
                 try{
                    assignment3Numbers.add( Double.valueOf(tokens[5]));
                }catch(NumberFormatException e){
                    assignment3Numbers.add( 0.0); 
                }
               

                break;   // end of case 6

            case 3:                            // if tokens length is 3
                try{
                    lastNames.add(tokens[0]);
                }catch(Exception e){
                    lastNames.add(" "); 
                }
                try{
                    firstNames.add(tokens[1]);
                }catch(Exception e){
                    firstNames.add(" ");
                }
                try{
                    studentIds.add(Integer.valueOf(tokens[2]));
                }catch(Exception e){
                    studentIds.add(0);
                }
                assignment1Numbers.add( 0.0);
                assignment2Numbers.add( 0.0);
                assignment3Numbers.add( 0.0);

                break;   // end of case 3

            case 4:                            // if tokens length is 4
                                               
                try{
                    lastNames.add(tokens[0]);
                }catch(Exception e){
                    lastNames.add(" "); 
                }
                try{
                    firstNames.add(tokens[1]);
                }catch(Exception e){
                    firstNames.add(" ");
                }
                try{
                    studentIds.add(Integer.valueOf(tokens[2]));
                }catch(Exception e){
                    studentIds.add(0);
                }
                try{
                    assignment1Numbers.add( Double.valueOf(tokens[3]));
                }catch(NumberFormatException e){
                    assignment1Numbers.add( 0.0); 
                }
                assignment2Numbers.add( 0.0);
                assignment3Numbers.add( 0.0);

                break;    // end of case 4
            case 5:                                        // if tokens length is 5
                try{
                    lastNames.add(tokens[0]);
                }catch(Exception e){
                    lastNames.add(" "); 
                }
                try{
                    firstNames.add(tokens[1]);
                }catch(Exception e){
                    firstNames.add(" ");
                }
                try{
                    studentIds.add(Integer.valueOf(tokens[2]));
                }catch(Exception e){
                    studentIds.add(0);
                }
                try{
                    assignment1Numbers.add( Double.valueOf(tokens[3]));
                }catch(NumberFormatException e){
                    assignment1Numbers.add( 0.0); 
                }
                try{
                    assignment2Numbers.add( Double.valueOf(tokens[4]));
                }catch(NumberFormatException e){
                    assignment2Numbers.add( 0.0); 
                }
                assignment3Numbers.add( 0.0);
                break;  // end of case 5

        }
    }

    /**
     * Method calculateAssignmentsTotalMarks
     * Adding all 3 assignment marks and storing into new array
     * @param 
     * @return
     */
    public void calculateAssignmentsTotalMarks(){
        for(int i=0;i<studentIds.size();i++){
            totalMarksAssignments.add(assignment1Numbers.get(i)+assignment2Numbers.get(i)+assignment3Numbers.get(i));
        }
    }

    /**
     * Method showFileData
     * Showing file data before adding assignments marks 
     * @param
     * @return
     */
    public void showFileData(){
        System.out.println("serial #"+"   "+" Student Full Name"+"                             "+" Student Id"+"  "
            +"Assignment1"+"  "+"Assignment2"+"  "+"Assignment3");
        for(int i=0;i<studentIds.size();i++){

            System.out.printf("|%8d| |%-14.14S   %-27S| |%10d| |%10.2f| |%10.2f| |%10.2f|%n",i+1,firstNames.get(i)
            ,lastNames.get(i),studentIds.get(i),assignment1Numbers.get(i),assignment2Numbers.get(i),assignment3Numbers.get(i));
        }

    }

    /**
     * Method showStudentsResult
     * Show all detail of students with total mark of assignmets 
     * @param
     * @return
     */
    public void showStudentsResult(){
        System.out.println("serial #"+"   "+" Student Full Name"+"                             "+" Student Id"+"  "
            +"Assignment1"+"  "+"Assignment2"+"  "+"Assignment3"+"  "+"Total Assignemt Marks");
        for(int i=0;i<studentIds.size();i++){

            System.out.printf("|%8d| |%-14.14S   %-27S| |%10d| |%10.2f| |%10.2f| |%10.2f| |%10.2f|%n",i+1,firstNames.get(i)
            ,lastNames.get(i),studentIds.get(i),assignment1Numbers.get(i),assignment2Numbers.get(i),assignment3Numbers.get(i),
                totalMarksAssignments.get(i));
        }

    }

    /**
     * Method showStudentsResultThreshold
     * This method take number from as parameter and show result of students less then or equal to number given to method
     *
     * @param threshold A parameter
     * @return 
     */
    public void showStudentsResultThreshold(Double threshold){
       

        System.out.println("serial #"+"   "+" Student Full Name"+"                             "+" Student Id"+"  "
            +"Assignment1"+"  "+"Assignment2"+"  "+"Assignment3"+"  "+"Total Assignemt Marks");
        for(int i=0;i<studentIds.size();i++){
            if (totalMarksAssignments.get(i)<=threshold){

                System.out.printf("|%8d| |%-14.14S   %-27S| |%10d| |%10.2f| |%10.2f| |%10.2f| |%10.2f|%n",i+1,firstNames.get(i)
                ,lastNames.get(i),studentIds.get(i),assignment1Numbers.get(i),assignment2Numbers.get(i),assignment3Numbers.get(i)
                ,totalMarksAssignments.get(i));
            }
        }

    }

    /**
     * Method showTop10HighestAndLowestStudentsMark
     * This method apply selection sort on total marks of assignment in ascending order and swap all the array according to 
        totalMarksAssignments array
     * show top 10 highest and lowest marks according to total assignment marks 
     * @param
     * @return
     */
    public void showTop10HighestAndLowestStudentsMark(){
        int position=0;
        Double temp=0.0;
        int intTemp=0;
        String stringTemp=null;

        for (int i = 0; i < studentIds.size(); i++) 
        { 
            position = i; 
            for (int j = i+1; j < studentIds.size(); j++) 
            {
                if (totalMarksAssignments.get(j) < totalMarksAssignments.get(position))                  //find the index of the minimum element
                {
                    position = j;
                }
            }

            temp = totalMarksAssignments.get(position);            //swap the current element with the minimum element
            totalMarksAssignments.set(position,totalMarksAssignments.get(i)); 
            totalMarksAssignments.set(i,temp); 

            temp = assignment1Numbers.get(position);            //swap the current element with the minimum element
            assignment1Numbers.set(position,assignment1Numbers.get(i)); 
            assignment1Numbers.set(i,temp); 

            temp = assignment2Numbers.get(position);            //swap the current element with the minimum element
            assignment2Numbers.set(position,assignment2Numbers.get(i)); 
            assignment2Numbers.set(i,temp); 

            temp = assignment3Numbers.get(position);            //swap the current element with the minimum element
            assignment3Numbers.set(position,assignment3Numbers.get(i)); 
            assignment3Numbers.set(i,temp); 

            intTemp = studentIds.get(position);            //swap the current element with the minimum element
            studentIds.set(position,studentIds.get(i)); 
            studentIds.set(i,intTemp); 

            stringTemp = firstNames.get(position);            //swap the current element with the minimum element
            firstNames.set(position,firstNames.get(i)); 
            firstNames.set(i,stringTemp); 

            stringTemp = lastNames.get(position);            //swap the current element with the minimum element
            lastNames.set(position,lastNames.get(i)); 
            lastNames.set(i,stringTemp); 

        } 
        
        System.out.println("serial #"+"   "+" Student Full Name"+"                             "+" Student Id"+"    "+"Total Assignemt Marks");
        for(int i=0;i<10;i++){

            System.out.printf("|%8d| |%-14.14S   %-27S| |%10d|  |%10.2f|%n",i+1,firstNames.get(i)
            ,lastNames.get(i),studentIds.get(i),totalMarksAssignments.get(i));
        }
        System.out.println("Top 10 Students with Highest Mark");
        System.out.println("serial #"+"   "+" Student Full Name"+"                             "+" Student Id"+"    "+"Total Assignemt Marks");
        int index=1;
        for(int i=studentIds.size()-1;i>=studentIds.size()-10;--i){

            System.out.printf("|%8d| |%-14.14S   %-27S| |%10d|  |%10.2f|%n",index,firstNames.get(i),lastNames.get(i),studentIds.get(i),assignment1Numbers.get(i),assignment2Numbers.get(i),assignment3Numbers.get(i),totalMarksAssignments.get(i));
            index++;
        }

    }
       
    
    /**
     * Method run
     * This method will show menu and provide some selected options to user so user can run the program
     *
     * @param myObj A parameter
     * @return 
     */
    public void run(Assignment2 myObj){
         boolean check =true;
        

        System.out.println("***************************************************Welcome to Student Data***************************************************");
        while(check){
            System.out.println("Enter [1]  Read file: ");
            System.out.println("Enter [2] Calculate the total mark for each student from the assessment marks and print out the list of students ");
            System.out.println("Enter [3] Enter the threshold and Print the list of students with the total marks ");
            System.out.println("Enter [4] Print the top 10 students with the highest total marks and top 10 students with the lowest total marks");
            System.out.println("Enter [5] to Quit program");

            try{
                int menu = new Scanner(System.in).nextInt();
                switch(menu){
                    case 1:
                        myObj.showFileData();
                        break;
                    case 2:
                        myObj.calculateAssignmentsTotalMarks();
                        myObj.showStudentsResult();
                        break;
                    case 3:
                         System.out.println("Please enter certain threshold");
                         try{
                         Double threshold =new Scanner(System.in).nextDouble(); 
                        myObj.showStudentsResultThreshold(threshold);
                    }catch(Exception e){
                        System.out.println("please enter valid threshold");
                    }
                        break;
                    case 4:
                        myObj.showTop10HighestAndLowestStudentsMark();
                        break;
                    case 5:
                        check=false;
                        System.out.println("Bye Bye");
                        break;

                }
            }catch(Exception e){
                System.out.println("Please enter number between 1 to 5");
            }

        }// end of while
        
    }
    public static void main(String[] args){
       
               Assignment2 myObj=new Assignment2();  
               myObj.run(myObj);
    }    

}

