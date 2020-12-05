package lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class lockedApp{
	String[] fileNames;
	String addFileName,searchFileName,delFileName;
	
    //Retrieving files/folders in the directory
    void printFileNames(File dirPath) throws IOException {
	    
		fileNames=dirPath.list();
		ArrayList<String> ar=new ArrayList<String>();
		for(int i=0;i<fileNames.length;i++) {
			
			ar.add(fileNames[i]);
		  }
		
		Collections.sort(ar);
		
		for(String printFNames:ar) {
			System.out.println(printFNames);
		  }
	
	}
    
    //Add a file to the Directory
    void addFileToDirectory(String fileName,String path){
		 
        try { 
    	addFileName = path + "\\" + fileName;
	      File file = new File(addFileName); 
	           
	        if (file.createNewFile()) {  
	           System.out.println("New File is created!");  
	           } else {                   
	                if(file.exists())
	                {
	                    System.out.println("File already exists.");	    
	                }
	                else
	                {
	                	System.out.println("File does not exists.");
	                }
	              
	           }  
        }catch(IOException e) {
        	System.err.println("IO Error" + e);
        }
	             	  
	}
    
    //Search File in the Directory
    void searchFile(String fileName,String path) throws IOException{
   	   
   		searchFileName = path + "\\" + fileName;
        File serFile = new File(searchFileName); 
   		if(serFile.exists()) {
   			System.out.println("File exist in the directory");
   			System.out.println("File path" + serFile.getCanonicalPath());
   		}        
         	  
     }
    
     //  Delete a file from the directory
     void deleteFile(String fileName,String path) throws IOException{
	 
		 delFileName = path + "\\" + fileName;
         File delFile = new File(delFileName); 
           boolean d = delFile.delete();
           if (d == true) {  
               System.out.println("File is successfully deleted!!");  
           } else {    
        	   System.out.println("File is not deleted!!");  
           }  
           	  
    }
}

public class lockedMeApp {

	public static void main(String[] args) {
		
		String fileName1;
		lockedApp ap=new lockedApp();
		Scanner sc = new Scanner(System.in);
	    try {
		char choice;
		// LockedMe.com application
		System.out.println("*****************************************************************************");
		System.out.println("******************* LockedMe.com ********************************************");
		System.out.println("************************************************ Developed by Sreya Sasindran");
		System.out.println("*****************************************************************************");
		System.out.println("                            ");
		System.out.println("Please provide the File directory for the file operations");
		System.out.println("Please provide the Full path eg:- C:\\Users\\sreya\\OneDrive\\Documents\\Locked.Me");
		String path = sc.next();
		File dirPath = new File(path);
		
		
		do {
			
	    System.out.println("Current Files/Folders in the directory are : ");
	    ap.printFileNames(dirPath);
		System.out.println("               ");
		System.out.println("Enter the File Operation to be performed : ");
		System.out.println("1. Add a File to the directory");
		System.out.println("2. Delete a File from the directory");
		System.out.println("3. Search a File in the directory ");
		System.out.println("4. Close the application");
		
		
		int ch = sc.nextInt();
		sc.nextLine();
		switch(ch) {
		case 1:  System.out.println("Please Enter filename to be created with extension(.txt)");
		        
		         fileName1=sc.nextLine();
		         
		         Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		         
		         Matcher hasSpecial = special.matcher(fileName1);
                 if(hasSpecial.find() || fileName1.contains(" ")){
		        	System.out.println("Please enter the file name without special characters");
		        	fileName1=sc.next();
		         }
		         ap.addFileToDirectory(fileName1,path);
		         break;
		case 2:  System.out.println("Please Enter filename to be deleted");
                 fileName1=sc.next();
                 ap.deleteFile(fileName1,path);
                 break;
		case 3 : System.out.println("Please enter the file name to search in the directory");
		         fileName1=sc.next();
		         ap.searchFile(fileName1,path);
		         break;
		case 4 : System.out.println("Closing Application!!!!");
		         System.out.println("Thank you!!");
		         System.exit(0);
		         break;
		default: System.out.println("Wrong Entry \n ");
                 break;
		}
		
		System.out.println("Do you want to continue Y/N?");
		choice = sc.next().charAt(0);
		
		}while(choice == 'Y' || choice == 'y');
		
	    }catch(IOException e)
	    {
	    	 System.err.println("File IO Error "+e) ;
	    }
	    
	}
}

