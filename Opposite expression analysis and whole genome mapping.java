import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.regex.*;


public class CyoIn2 {

public static void main(String[] args)
{
    
BufferedReader br,br2;    
File folder = new File("E://MSRNA//OEAnalysis_Final//ALG//");
File[] listOfFiles = folder.listFiles();
String line,line2;


    try {    
		    for (File file : listOfFiles) 
			{
	
        br = new BufferedReader(new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();
		List<String> Cyto = new ArrayList<String>();
		Set<String> hs = new HashSet<>();
			String srn=file.getName();
				srn = srn.replaceFirst("[.][^.]+$", "");
		List<List<String>> compare = new ArrayList<List<String>>();
		//List<List<String>> comparefinal = new ArrayList<List<String>>();
		File folder2 = new File("E://MSRNA//OEAnalysis_Final//COND//");
		File[] listOfFiles2 = folder2.listFiles();
		//FileOutputStream f = new FileOutputStream("E://MSRNA//OUT//"+srn+".txt");
		//PrintStream ps = new PrintStream(f);

    try {       
	        while((line = br.readLine()) != null)       
			{    
				String [] result =line.split(";");
				//System.out.println(result[2].trim());
				list.add(result[2].trim());
			}	
		
		
			
             			for (File file2 : listOfFiles2) 
						{
						
							ArrayList<String> list2 = new ArrayList<String>();
							ArrayList<String> list3 = new ArrayList<String>();
							
							int count=0;
							
							String srn2=file2.getName();
							//System.out.println(srn2);
							br2 = new BufferedReader(new FileReader(file2));
							int flag=0;
							   while((line2 = br2.readLine()) != null)   
							    {  
								
								
								if(line2.contains("SAA6008"))
								{
								//System.out.println(line2);
								String [] result2 =line2.split(" ");
								list2.add(result2[0].trim());
								list3.add(result2[1].trim());
								}
								else
								{
								list2.add(line2.trim());
								}
								}
							
								
							 for(String foo : list2)
							 {
								
								if(foo.equals(srn))
								{

					//System.out.println(srn+"Found at Position:"+list2.indexOf(foo)+"in file"+file2.getName());
					
				//	ps.println(srn+"Found at Position:"+list2.indexOf(foo)+"in file"+file2.getName());
				//	ps.println();
								flag=1;
								count++;
								
								
							    }
							}      
							 if(flag==1)
							 {
							 List<String> common = new ArrayList<String>(list3);
							 common.retainAll(list);
							compare.add(common);
									for(String foo : common)
									{
									//System.out.println(foo);
								//	ps.println(foo);
									
									}
								//	ps.println();
							 }
							    
								 br2.close();
					    
				
						
			     			
																		
												
					 br.close();
					 
  
		             }	
			
//ps.println("*********List Comparison**********\n\n\n");			
int count=0;

for ( List<String> obj : compare)
{
int count1=0;
count++;
		

  for (List<String> Obx : compare )
  {
     count1++;
	List<String> obnew=new ArrayList<String>(obj);
	
	
	 if(count<count1)
	 {
	  obnew.retainAll(Obx);
	 if(! obnew.isEmpty())
	 {
	//ps.println();
	//ps.println("Common in list "+ count +" and list "+count1);
	
	 for(String foo : obnew)
									{
									
									//ps.println(foo);
									Cyto.add(foo+"\t"+srn);
									
									}
									
	 }
									
	}
	}
	
}
hs.addAll(Cyto);
Cyto.clear();
Cyto.addAll(hs);
 for(String fooy : Cyto)
									{
									
									System.out.println(fooy);
									
									
									}

//ps.close();


			}					 
		
		catch (IOException e) {       // TODO Auto-generated catch block       e.printStackTrace();
							  }
								
		    }
			}
		
        
    
     catch (FileNotFoundException e) {   // TODO Auto-generated catch block   e.printStackTrace();
									  }


}
}