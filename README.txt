Instructions (On windows)
1) Ensure that "cacm.all" file and "stopwords.txt" is in the same directory as "invert.jar" and "test.jar"
2) Use the terminal to locate the folder containing "invert.jar" and "test.jar"
3) Using the command prompt window, type "java -jar invter.jar"
4) Enter the file containing the articles (such as cacm.all)
5) It will create Dictionary.txt and Postings.txt which are required files for part 1.
	- Dictionary.txt contains all the words and the document frequency
	- Postings.txt contains all the terms and the documents they can be found in, along with term frequency in that document, and the position
6) Next run the test program by typing "java -jar test.jar"
7) Here you can type in your single word query. Stop words is off by default and can be turned on by typing "stopwordon" or turned off by typing "stopwordoff"
8) You can also exit by typing "ZZEND"
9) Please ignore all other text files as they are used to check the invert.jar is working properly.

Report

Process for Reading in the Characters in CACM.ALL

	For creating the "invert.jar", I mainly used HashMaps and Lists to sort through the words and document ID. I first read through the "cacm.all" line by line,
then I would add only the title to "titleBuffer" which is located between ".T" and ".W" or ".B". It would also find the ".I (number)", and just keep the number  in "docBuffer" 
which is the document ID. During the same pass through, I would also add all the words in the title and the abstract to "titleAbstractBuffer". Next I would convert all the titleBuffer
and titleAbstractBuffer to string using an in built method called "toString()" to process the strings. After trimming all the special characters, new line characters, and extra spaces,
the string would be converted to an array of strings and iterated through to fill in the hashmaps. 


Examples from Output

input = logically

Document frequency = 9

Document ID is 971
Title of Document is Time Sharing in a Traffic Control Program
Term frequency is 1
Position of the words is [18]
Words starting from position 18 contains [logically, distinct, computer, programs, all, competing, for, machine, time, to]

Document ID is 1155
Title of Document is Experiments with a Deductive Question-Answering Program
Term frequency is 1
Position of the words is [178]
Words starting from position 178 contains [logically, equivalent, ones, before, being, given, to, deducom, and, some]

Document ID is 1255
Title of Document is A Method of Data List Processing With Application to EEG Analysis
Term frequency is 1
Position of the words is [49]
Words starting from position 49 contains [logically, arranged, into, five, groups, as, an, example, the, computation]

Document ID is 1908
Title of Document is Time-Sharing and Batch-Processing:  An Experimental Comparison of Their Values in a Problem -  Solving Situation
Term frequency is 1
Position of the words is [91]
Words starting from position 91 contains [logically, significant, results, indicate, equal, cost, for, usage, of, the]

Document ID is 2035
Title of Document is Conversational Access to a 2048-Word Machine
Term frequency is 1
Position of the words is [122]
Words starting from position 122 contains [logically, similar, to, a, disk, priority, was, given, to, the]

Document ID is 2054
Title of Document is On the Feasibility of Voice Input to an On-line Computer Processing System
Term frequency is 1
Position of the words is [143]
Words starting from position 143 contains [logically, feasible, to, handle, at, least, users, at, a, time]

Document ID is 2060
Title of Document is GEDANKEN-A Simple Typeless Language Based on the Principle of Completeness and the Reference Concept
Term frequency is 1
Position of the words is [123]
Words starting from position 123 contains [logically, equivalent, structure, regardless, of, its, internal, representation, more, generally]

Document ID is 2726
Title of Document is Combining Decision Rules in a Decision Table
Term frequency is 1
Position of the words is [30]
Words starting from position 30 contains [logically, equivalent, to, the, quien, mccluskey, method, for, finding, prime]

Document ID is 3111
Title of Document is Secure Communications Over Insecure Channels
Term frequency is 1
Position of the words is [89]
Words starting from position 89 contains [logically, new, kind, of, protection, against, the, passive, eaves, dropper]

input = stopwordon // this turns on stop words
input = logically 

Document frequency = 9

Document ID is 971
Title of Document is Time Sharing in a Traffic Control Program
Term frequency is 1
Position of the words is [18]
Words starting from position 18 contains [logically, distinct, computer, programs, all, competing, machine, time, satisfy, these]

Document ID is 1155
Title of Document is Experiments with a Deductive Question-Answering Program
Term frequency is 1
Position of the words is [178]
Words starting from position 178 contains [logically, equivalent, ones, before, being, given, deducom, some, redundant, facts]

Document ID is 1255
Title of Document is A Method of Data List Processing With Application to EEG Analysis
Term frequency is 1
Position of the words is [49]
Words starting from position 49 contains [logically, arranged, into, five, groups, example, computation, power, spectral, density]

Document ID is 1908
Title of Document is Time-Sharing and Batch-Processing:  An Experimental Comparison of Their Values in a Problem -  Solving Situation
Term frequency is 1
Position of the words is [91]
Words starting from position 91 contains [logically, significant, results, indicate, equal, cost, usage, two, computer, systems]

Document ID is 2035
Title of Document is Conversational Access to a 2048-Word Machine
Term frequency is 1
Position of the words is [122]
Words starting from position 122 contains [logically, similar, disk, priority, given, design, efficient, tape, algorithms, minimize]

Document ID is 2054
Title of Document is On the Feasibility of Voice Input to an On-line Computer Processing System
Term frequency is 1
Position of the words is [143]
Words starting from position 143 contains [logically, feasible, handle, least, users, time, ibm, computer]

Document ID is 2060
Title of Document is GEDANKEN-A Simple Typeless Language Based on the Principle of Completeness and the Reference Concept
Term frequency is 1
Position of the words is [123]
Words starting from position 123 contains [logically, equivalent, structure, regardless, its, internal, representation, more, generally, any]

Document ID is 2726
Title of Document is Combining Decision Rules in a Decision Table
Term frequency is 1
Position of the words is [30]
Words starting from position 30 contains [logically, equivalent, quien, mccluskey, method, finding, prime, implicants, if, some]

Document ID is 3111
Title of Document is Secure Communications Over Insecure Channels
Term frequency is 1
Position of the words is [89]
Words starting from position 89 contains [logically, new, kind, protection, against, passive, eaves, dropper, suggests, further]

