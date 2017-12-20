package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class test {
	
	private static String[] getStopWords() throws FileNotFoundException
	{
		FileReader text = new FileReader("stopwords.txt");
		BufferedReader bufferedReader = new BufferedReader(text);
		String line;
		String delimiter1 = " ";
		String delimiter2 = "\n";
		StringBuffer docBuffer = new StringBuffer();
		String processString;
		String removeSpecial;
		String[] stopWords = null;
		
		try 
		{
			while ((line = bufferedReader.readLine()) != null) 
			{
				docBuffer.append(line);
				docBuffer.append("\n");				
			}
			bufferedReader.close();
			processString = docBuffer.toString();
			


			removeSpecial = processString.replaceAll(delimiter2, delimiter1);
			removeSpecial = removeSpecial.replaceAll("[^a-zA-Z\\s]", delimiter1);
			removeSpecial = removeSpecial.replaceAll("^ +| +$|( )+", delimiter1);
			removeSpecial = removeSpecial.toLowerCase();
			removeSpecial = removeSpecial.trim();
			stopWords = removeSpecial.split(delimiter1);
			/*
			for ( int i = 0; i < stopWords.length; i++)
			{
				System.out.println(stopWords[i]);
			}
			*/
			
		} 
		
		catch (IOException e) 
			{
				e.printStackTrace();
			}
		return stopWords;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException 
	{
		
		try 
		{
			String[] stopWords = getStopWords();
			
			File postings=new File("postings1");
	        FileInputStream fis=new FileInputStream(postings);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	        Map<String,List<List<List<Integer>>>> postingsMap=(Map<String,List<List<List<Integer>>>>)ois.readObject();

	        ois.close();
	        fis.close();
	        
			File summ=new File("summ");
	        FileInputStream fis1=new FileInputStream(summ);
	        ObjectInputStream ois1=new ObjectInputStream(fis1);

	        Map<Integer, List<String>> summMap=(Map<Integer, List<String>>)ois1.readObject();

	        ois1.close();
	        fis1.close();
	        
			File df=new File("df");
	        FileInputStream fis2=new FileInputStream(df);
	        ObjectInputStream ois2=new ObjectInputStream(fis2);

	        Map<String, Integer> dfMap=(Map<String, Integer>)ois2.readObject();

	        ois2.close();
	        fis2.close();
	        
			File titles=new File("titles");
	        FileInputStream fis3=new FileInputStream(titles);
	        ObjectInputStream ois3=new ObjectInputStream(fis3);

	        Map<Integer, String> titleMap=(Map<Integer, String>)ois3.readObject();

	        ois3.close();
	        fis3.close();
	        
	        
	        
	        
	        
	        Scanner reader = new Scanner(System.in);	        
	        
	        int stopWordCheck = 0;
	        while(true)
			{
	        
	        System.out.println("Enter query or stopwordon or stopwordoff or ZZEND: ");
			String query = reader.nextLine();
			if (query.equals("ZZEND"))
			{
				break;
			}
			else if (query.equals("stopwordon"))
			{
				stopWordCheck = 1;
				System.out.println("Stop words on");
			}
			else if (query.equals("stopwordoff"))
			{
				stopWordCheck = 0;
				System.out.println("Stop words off");
			}
			
			else if (query.equals("liststopwords"))
			{
				for (int a = 0; a < stopWords.length; a++)
				{
					System.out.println(stopWords[a]);
				}
			}
			
			else if (dfMap.containsKey(query))
			{	
				int dfValue = dfMap.get(query);
				System.out.println("\n");
				System.out.println("Document frequency = " + dfValue + "\n");
				
				List<List<List<Integer>>> allPostings = new ArrayList<List<List<Integer>>>();
				allPostings = postingsMap.get(query);
				
				for ( int i = 0; i < allPostings.size(); i++)
				{
					List<List<Integer>> docPostInfo = new ArrayList<List<Integer>>();
					docPostInfo = allPostings.get(i);
					
					
					List<Integer> docIDList = docPostInfo.get(0);
					int docID = docIDList.get(0);
					System.out.println("Document ID is " + docID);
					//need to implement title
					
					String titleOfDoc = titleMap.get(docID);
					System.out.println("Title of Document is " + titleOfDoc);
					
					List<Integer> termFreqList = docPostInfo.get(1);
					int termFreq = termFreqList.get(0);
					System.out.println("Term occured " + termFreq + " time(s) in document");
					
					
					List<Integer> posOfWordsList = new ArrayList<Integer>();
					posOfWordsList = docPostInfo.get(2);
					System.out.println("Position of the words is " + posOfWordsList);
					
					
					int posOfWord = docPostInfo.get(2).get(0);
					
					List<String> summList = new ArrayList<String>();
					summList = summMap.get(docID);
					List<String> theTerms = new ArrayList<String>();
					
					if ((summList.size() - posOfWord) > 10)
					{
						int countWord = 10;
						int up = posOfWord;
						if (stopWordCheck == 1)
						{
							while (countWord > 0 && up < summList.size())
							{
								String checkStopWord = summList.get(up);
								if (Arrays.asList(stopWords).contains(checkStopWord) == false)
								{
									theTerms.add(summList.get(up));
									countWord--;
									
								}
								up++;
							}
						}
						else if (stopWordCheck == 0)
						{
							while (countWord > 0)
							{
							
								theTerms.add(summList.get(up));
								countWord--;
								up++;
							}
						}
					}
					else
					{
						for (int j = posOfWord; j < summList.size(); j++)
						theTerms.add(summList.get(j));
					}
					
					System.out.println("Words starting from position " + posOfWord + " contains " + theTerms + "\n");
					
				}
					
			}

			
			}// while loop
			

		} 
			catch (IOException e) 
				{
				e.printStackTrace();
				}
	}
	
	
}
