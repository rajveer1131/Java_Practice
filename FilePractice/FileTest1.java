import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;


class FileTest1{

    static String filePath ="SampleFolder1/samplefile1.txt";

    public static void main(String[] args) {
        try{
            File newFile = new File(filePath);
            

            if(newFile.createNewFile()){
                System.out.println("New File created"+ newFile.getName());
            }else{
                System.out.println("File already exists");
            }

            System.out.println(newFile.getCanonicalPath());

            String txt = "Hi some sample test to write out in new File.";

            String txt2 = "Second Text to test the file flow";

            FileWriter fwt= new FileWriter(filePath,true);
            fwt.write(txt);

            fwt.write(txt2);
            fwt.close();
            System.out.println("Successfully wrote to a file");

            Scanner sc = new Scanner(newFile);

            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            System.out.println(newFile.length());


        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }
    }
}