import java.io.*;
import java.util.*;
import java.net.*;

public class URLresource {

	public static void main (String[] args) throws IOException {
		
		URL google = new URL("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
		
		//System.out.println(google.getHost());
		//System.out.println(google.getProtocol());
		//System.out.println(google.getFile());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));

		String inputLine;
		String webpage = "";

		while ((inputLine = in.readLine()) != null){
	        //System.out.println(inputLine);
			
			webpage = webpage+inputLine;
			
		}
		
		//in.close();
		//System.out.println(allText);
		
		//Scanner sc = new Scanner(allText);

		//System.out.println(webpage.substring(webpage.indexOf("www."),webpage.indexOf(".com")+4));
		
		
		
		
		/*
		File file = new File("NYtimesWk2.txt");
		Scanner sc = new Scanner(file);
		
		String webpage = "";
		
		while(sc.hasNextLine()){
			webpage=webpage +sc.nextLine();
		}
		*/
		
		//webpage.toUpperCase();
		
		//System.out.println(webpage);
		
		//System.out.println(webpage.length());
		
		//System.out.println(webpage.substring(0,100));
		
		//System.out.println(webpage.indexOf("</html>"));
		
		
		ArrayList<String> links = new ArrayList<String>();
		
		int start=0;
		int firstquote =0;
		int endquote = 0;
		String link = "";
		
		
		//create all links in array
		while(true){
			if(webpage.indexOf("href=", start)==-1){
				break;
			}
			firstquote = webpage.indexOf("href",start)+6;
			endquote = webpage.indexOf("\"",firstquote);
			link= webpage.substring(firstquote, endquote);
			
			//System.out.println(link);
			
			String linkstart=link.substring(0,4);
			String http="http";
						
			if(linkstart.equalsIgnoreCase(http)){
				System.out.println(link);
				links.add(link);
				start = endquote+1;
			} else{
				start = endquote+1;			
			}
		}
		
		System.out.println("Number of links is: "+links.size());
		
		
		//check links for https
		String https="https";
		int httpscount=0;
		
		for(String object:links){
			String linkstarts = object.substring(0,5);
			if(linkstarts.equalsIgnoreCase(https)){
				httpscount++;
			}
		}
		System.out.println("Https count is: "+httpscount);
		
		//check links for with ".com"
		String dotcom = ".com";
		int dotcomCount=0;
		
		for(String object2:links){
			if(object2.indexOf(dotcom)!=-1){
				dotcomCount++;
			}
		}
		System.out.println("Contains "+dotcom+" count is: "+dotcomCount);
		
		//.com and .com/ count
		String dotcomslash=".com/";
		int bothCount=0;
		
		for(String object3:links){
			if(object3.substring(object3.length()-4,object3.length()).equalsIgnoreCase(dotcom)||object3.substring(object3.length()-5,object3.length()).equalsIgnoreCase(dotcomslash)){
				bothCount++;
			}
		}
		System.out.println("Ends with "+dotcomslash+" or "+dotcom+" count is: "+bothCount);
		
		
		//how many "." is there in all links
		int countdots = 0;
		String comboLinks="";
		
		for(String object3:links){
			comboLinks=comboLinks+object3;
		}
		
		int startdots=0;
		while(comboLinks.indexOf(".",startdots)!=-1){
			countdots++;
			startdots=comboLinks.indexOf(".",startdots)+1;
		}
		
		System.out.println("Number of dots is: "+countdots);
	}
	
	
}
