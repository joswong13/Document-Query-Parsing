package cps842assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;



public class readfile 
{
		
	private static void writeDF(HashMap<String, Integer> map) throws IOException
	{
		BufferedWriter outputTitleCount = new BufferedWriter (new FileWriter("Dictionary.txt"));
		
		Map<String, Integer> titleMap = new TreeMap<>(map);
		
		Iterator<Entry<String, Integer>> it = titleMap.entrySet().iterator();
		int count = 0;
		// write document frequency
		while (it.hasNext() && count < titleMap.size()) 
		{

	        // the key/value pair is stored here in pairs
	        Map.Entry<String, Integer> pairs = it.next();
	        outputTitleCount.write(pairs.getKey() + " - " + pairs.getValue() + "\n");

	        // increment the record count once we have printed to the file
	        count++;
	    }
		outputTitleCount.close();
		saveDFMap(titleMap);
		//System.out.println("WriteDF good");
	}

	private static void writeSummary(HashMap<Integer, List<String>> map) throws IOException
	{
		BufferedWriter outputTitleCount = new BufferedWriter (new FileWriter("Summary.txt"));
		
		Map<Integer, List<String>> titleMap = new TreeMap<>(map);
		
		Iterator<Entry<Integer, List<String>>> it = titleMap.entrySet().iterator();
		int count = 0;
		// write document frequency
		while (it.hasNext() && count < titleMap.size()) 
		{

	        // the key/value pair is stored here in pairs
	        Entry<Integer, List<String>> pairs = it.next();
	        outputTitleCount.write(pairs.getKey() + " - " + pairs.getValue() + "\n");

	        // increment the record count once we have printed to the file
	        count++;
	    }
		outputTitleCount.close();
		saveSummMap(titleMap);
	}
	
	private static void writeIDF(HashMap<String, Integer> map, int totalDoc) throws IOException
	{
		BufferedWriter outputIDF = new BufferedWriter (new FileWriter("IDF.txt"));
		
		Map<String, Integer> titleMap = new TreeMap<>(map);
		
		Iterator<Entry<String, Integer>> it = titleMap.entrySet().iterator();
		int count = 0;
		// write document frequency
		while (it.hasNext() && count < titleMap.size()) 
		{

	        // the key/value pair is stored here in pairs
	        Map.Entry<String, Integer> pairs = it.next();
	        double fraction = ((double) totalDoc)/pairs.getValue();
	        double calcIDF = Math.log10(fraction);
	        
	        outputIDF.write(pairs.getKey() + " - " + calcIDF + "\n");

	        // increment the record count once we have printed to the file
	        count++;
	    }
		outputIDF.close();
		//System.out.println("WriteDF good");
	}
	
	private static void writeTitleMap(HashMap<Integer, String> titleOnly) throws IOException {
		
		BufferedWriter outputTitle = new BufferedWriter (new FileWriter("title.txt"));
		
		Map<Integer, String> titleMap = new TreeMap<>(titleOnly);
		
		Iterator<Entry<Integer, String>> it = titleMap.entrySet().iterator();
		int count = 0;
		// write document frequency
		while (it.hasNext() && count < titleMap.size()) 
		{

	        // the key/value pair is stored here in pairs
	        Map.Entry<Integer, String> pairs = it.next();
	        outputTitle.write(pairs.getKey() + " - " + pairs.getValue() + "\n");

	        // increment the record count once we have printed to the file
	        count++;
	    }
		outputTitle.close();
		saveTitleMap(titleMap);
		//System.out.println("WriteDF good");
	}
	
	public static void saveTreeMap(Map<String,List<List<List<Integer>>>> postingsHashMap)
	{
	    //write to file : "fileone"
	    try{
	    File fileOne=new File("postings1");
	    FileOutputStream fos=new FileOutputStream(fileOne);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(postingsHashMap);
	        oos.flush();
	        oos.close();
	        fos.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	   }
	
	public static void saveSummMap(Map<Integer, List<String>> summMap)
	{
	    //write to file : "fileone"
	    try{
	    File fileOne=new File("summ");
	    FileOutputStream fos=new FileOutputStream(fileOne);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(summMap);
	        oos.flush();
	        oos.close();
	        fos.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	   }

	public static void saveTitleMap(Map<Integer, String> titleMap)
	{
	    //write to file : "fileone"
	    try{
	    File fileOne=new File("titles");
	    FileOutputStream fos=new FileOutputStream(fileOne);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(titleMap);
	        oos.flush();
	        oos.close();
	        fos.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	   }
	
	public static void saveDFMap(Map<String, Integer> dfMap)
	{
	    //write to file : "fileone"
	    try{
	    File fileOne=new File("df");
	    FileOutputStream fos=new FileOutputStream(fileOne);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(dfMap);
	        oos.flush();
	        oos.close();
	        fos.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	   }
	
	private static void writePost(HashMap<String,List<List<List<Integer>>>> postingsHashMap) throws IOException
	{
		BufferedWriter outputTitleCount = new BufferedWriter (new FileWriter("Postings.txt"));
		
		Map<String,List<List<List<Integer>>>> titleMap = new TreeMap<>(postingsHashMap);
		
		Iterator<Entry<String,List<List<List<Integer>>>>> it = titleMap.entrySet().iterator();
		int count1 = 0;
		
		while (it.hasNext() && count1 < postingsHashMap.size()) 
		{

	        // the key/value pair is stored here in pairs
	        Entry<String, List<List<List<Integer>>>> pairs = it.next();
	        outputTitleCount.write(pairs.getKey() + " - " + pairs.getValue() + "\n");
	        // increment the record count once we have printed to the file
	        count1++;
	    }
		outputTitleCount.close();
		saveTreeMap(titleMap);
		//System.out.println("Writepost good");
		//Output looks like this
		//term - [[[doc ID],[term freq],[position]], [[doc ID],[term freq],[position]]]
		//term1 - [[[doc ID],[term freq],[position]], [[doc ID],[term freq],[position]]]
	}
		
	//stemming
	/*			
	 * Porter stem = new Porter();				
	for ( int j = 0; j < titleWordsA.length; j++)
		{
		stemWord = titleWordsA[j];
		titleWordsA[j] = stem.stripAffixes(stemWord);
		}
	*/ 
	
	private static void setDocumentFrequency(Map<String, Integer> dFMap, String line)
	{		
		String delimiter1 = " ";
		String delimiter2 = "\n";
		ArrayList<String> titleWordsOccur1 = new ArrayList<String>();
		String removeSpecial;
		String[] stringToArray;
		
		//replace new line with space
		removeSpecial = line.replaceAll(delimiter2, delimiter1);
		// take out special characters and digits
		removeSpecial = removeSpecial.replaceAll("[^a-zA-Z\\s]", delimiter1);
		// take out multiple spaces in front, end and middle
		removeSpecial = removeSpecial.replaceAll("^ +| +$|( )+", delimiter1);
		//remove uppercase
		removeSpecial = removeSpecial.toLowerCase();
		removeSpecial = removeSpecial.trim();
		//send to array
		stringToArray = removeSpecial.split(delimiter1);
		
		//iterate thru array
		for (int i = 0; i < stringToArray.length; i++)
		{

			String temp = stringToArray[i];

			
			// if titleWordsA[j] alrdy occurred, dont go into if loop
			if (titleWordsOccur1.contains(stringToArray[i]) == false)	
			{
				// if first occurrence in this title, add to titleWordsOccur[]
				titleWordsOccur1.add(stringToArray[i]);			
				// get word count from global dFMap
				Integer count = dFMap.get(stringToArray[i]);
				if (count == null)
				{
					// first time word shows up in dictionary
					dFMap.put(temp, 1);
					//System.out.println(temp);
				}
				else
				{
					// next occurence increment of dictionary
					dFMap.put(temp, count + 1);
				}
			}
		}	 
	}
	
	
	private static void setSummary(HashMap<Integer, List<String>> summary, String freq1, int docNumber) 
	{
		String delimiter1 = " ";
		String delimiter2 = "\n";			
		String removeSpecial;
		String[] stringToArray1;
		List<String> summ = new ArrayList<String>();
		
		removeSpecial = freq1.replaceAll(delimiter2, delimiter1);
		removeSpecial = removeSpecial.replaceAll("[^a-zA-Z\\s]", delimiter1);
		removeSpecial = removeSpecial.replaceAll("^ +| +$|( )+", delimiter1);
		removeSpecial = removeSpecial.toLowerCase();
		removeSpecial = removeSpecial.trim();
		stringToArray1 = removeSpecial.split(delimiter1);
		
		for (int h = 0; h < stringToArray1.length; h++)
		{
			summ.add(stringToArray1[h]);
		}
		
		summary.put(docNumber, summ);
		
	}
	
	private static void postingsFile(Map<String,List<List<List<Integer>>>> postingsMap, String titleAndAbstract, Integer docNum)
	{		
		String delimiter1 = " ";
		String delimiter2 = "\n";			
		String removeSpecial;
		String[] stringToArray;
		HashMap<String,Integer> wordCount = new HashMap<String,Integer>();	//temp map
		HashMap<String,List<Integer>> position = new HashMap<String,List<Integer>>();	//temp map
		removeSpecial = titleAndAbstract.replaceAll(delimiter2, delimiter1);
		removeSpecial = removeSpecial.replaceAll("[^a-zA-Z\\s]", delimiter1);
		removeSpecial = removeSpecial.replaceAll("^ +| +$|( )+", delimiter1);
		removeSpecial = removeSpecial.toLowerCase();
		removeSpecial = removeSpecial.trim();
		stringToArray = removeSpecial.split(delimiter1);
		
		// word count and position
		for (int i = 0; i < stringToArray.length; i++)
		{
			List<Integer> pos = new ArrayList<Integer>();
			Integer count = wordCount.get(stringToArray[i]);
			if (wordCount.containsKey(stringToArray[i]) == false)
			{
				//List<Integer> pos = new ArrayList<Integer>();
				pos.add(i);
				wordCount.put(stringToArray[i], 1);
				position.put(stringToArray[i], pos);
			}
			else
			{
				wordCount.put(stringToArray[i], count+1);
				pos = position.get(stringToArray[i]);
				pos.add(i);
				position.put(stringToArray[i], pos);
			}
	 
		}
		Iterator<Entry<String, Integer>> it = wordCount.entrySet().iterator();
		//Iterator<Entry<String, List<Integer>>> it1 = position.entrySet().iterator();
		int count = 0;
		while (it.hasNext() && count < wordCount.size()) 
		{
			List<List<Integer>> listOfDocFreqPost = new ArrayList<List<Integer>>();
			List<List<List<Integer>>> listofListOfDocFreqPost = new ArrayList<List<List<Integer>>>();
			Map.Entry<String, Integer> pairs = it.next();
			
			String key = pairs.getKey();
			List<Integer> doc = new ArrayList<Integer>();
			List<Integer> freq = new ArrayList<Integer>();
			doc.add(docNum);
			freq.add(pairs.getValue());
			
			List<Integer> posOfKey = new ArrayList<Integer>();
			posOfKey = position.get(key);
			//[[.I],[freq],[position]]
			listOfDocFreqPost.add(doc);
			listOfDocFreqPost.add(freq);
			listOfDocFreqPost.add(posOfKey);
			count+=1;
			//[[[.I],[freq],[position]]]
			listofListOfDocFreqPost.add(listOfDocFreqPost);
			//termFreqPos.put(docNum, listOfDocFreqPost);
			//test variables
			//System.out.println(key + " - " + docNum + " - " + freq + " - " + listOfFreqPost + "\n");
			
			if (postingsMap.containsKey(key) == false)
			{
				postingsMap.put(key, listofListOfDocFreqPost);
			}
			else
			{
				List<List<List<Integer>>> tempList = new ArrayList<List<List<Integer>>>();
				//[[[.I],[freq],[position]],[[.I],[freq],[position]],[[.I],[freq],[position]]]
				tempList = postingsMap.get(key);
				tempList.add(listOfDocFreqPost);
				postingsMap.put(key, tempList);
			}
			
			
			
		}
		
		
		
		
	}
	
	private static void setTitleOnly(HashMap<Integer, String> titleOnly, String title, int docNum) 
	{
		String formatTitle = title.replaceAll("\n", " ").trim();
		titleOnly.put(docNum, formatTitle);
		
	}
	
	private static void createDictPost(BufferedReader bufferedReader, HashMap<String,List<List<List<Integer>>>> postingsHashMap) throws IOException
	{
		StringBuffer titleAbstractBuffer = new StringBuffer();
		StringBuffer titleBuffer = new StringBuffer();
		StringBuffer docBuffer = new StringBuffer();
		
		String line;
		String freq1;
		String title;
		int docNumber = 0;
		int totalDoc = 0;
		
		HashMap<String,Integer> titleCount = new HashMap<String,Integer>();			
		HashMap<Integer,List<String>> summary = new HashMap<Integer,List<String>>();
		HashMap<Integer, String> titleOnly = new HashMap<Integer, String>();
		
		while ((line = bufferedReader.readLine()) != null) 
		{				
			// document ID
			if (line.startsWith(".I")) 
			{
				docBuffer.append(line);
				docBuffer.append("\n");
				docNumber = Integer.parseInt(line.replaceAll(".I ", ""));
				totalDoc+=1;
				//line = bufferedReader.readLine();	
			}
			// document frequency
			else if (line.equals(".T"))
			{	
				line = bufferedReader.readLine();
				//reset titleabstractbuffer
				titleAbstractBuffer.setLength(0);
				titleBuffer.setLength(0);
				// if no title, won't add .W to list and .B
				while (line.equals(".W") == false && line.equals(".B") == false)
				{
					titleAbstractBuffer.append(line);
					titleAbstractBuffer.append("\n");
					titleBuffer.append(line);
					titleBuffer.append("\n");
					line = bufferedReader.readLine();
				}
				// appends abstract if there is one
				if (line.equals(".W"))
				{
					line = bufferedReader.readLine();
					while (line.equals(".B") == false && line.equals(null) == false)
					{
						titleAbstractBuffer.append(line);
						titleAbstractBuffer.append("\n");
						line = bufferedReader.readLine();
					}
					
				}
				// sends .T and .W together if possible
				freq1 = titleAbstractBuffer.toString();
				title = titleBuffer.toString();
				setTitleOnly(titleOnly, title, docNumber);
				setDocumentFrequency(titleCount, freq1);
				setSummary(summary, freq1,docNumber);
				postingsFile(postingsHashMap,freq1,docNumber);
				
			}// else line is .T
		}//while loop at top
			
		bufferedReader.close();
		writeDF(titleCount);
		writeSummary(summary);
		writeIDF(titleCount, totalDoc);
		writePost(postingsHashMap);
		writeTitleMap(titleOnly);
	}
	






	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException 
	{

		try 
		{
			
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter text file to create dictionary and positings file ending in '.all': ");
			String filename = reader.nextLine();
			
			FileReader text = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(text);
			HashMap<String,List<List<List<Integer>>>> postingsHashMap = new HashMap<String,List<List<List<Integer>>>>();
			//String find = "logically";
			
			createDictPost(bufferedReader, postingsHashMap);			
			

		} 
			catch (IOException e) 
				{
				e.printStackTrace();
				}
	}
	
	

	

}
