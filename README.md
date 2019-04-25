# viterbi-algo-for-hmm-java
Viterbi algorithm was proposed by Andrew Viterbi in 1967 with a purpose of using a decoding algorithm for noisy communication channels. It is a dynamic programming algorithm that is used to discover the maximum probabilities associated with a given state or a problem. This algorithm has a lot of applications in today’s digital world. Some of the major applications have been listed as follows:

Applications:
1.	Speech Recognition
2.	Speech Synthesis
3.	Keyword Spotting
4.	Computational Linguistics
5.	Bioinformatics

In this project, Java Programming Language is used to demonstrate the working of one of the famous algorithms used in Python Programming i.e. “Viterbi Algorithm for HMMs”. The core idea of the project is to show the working of this algorithm to the user.
The inputs are used in the coding and results are shown on the basis of those inputs. The code of the project is simple and easy to understand as comments have been provided at each required step.

Project Assumptions
In this project, I have considered a scenario where a group of people living in a specific area are either healthy or they have fever. After being diagnosed by a doctor, the patient will reply cold, dizzy or normal as the status of his/her health condition. According to doctor, these states of patients are actually difficult to observe and are hidden from him. Based on these observations following assumptions have been made:
1.	I have taken two states as inputs for our algorithm namely- “Healthy” and “Fever”.
2.	The patient observations are- cold, dizzy and normal.
3.	I have taken some starting probability values according to the doctor.
4.	As the health conditions may change, so we have taken some probability values as transition probabilities for showing transition between health conditions of patients.
5.	An emission probability representing how likely a patient feels on a particular day is also considered as an input for this system.
Resulting Observations
By implementing this algorithm, I have calculated the most likely sequence of patients’ health conditions. In the output, following points have been shown:
1.	Viterbi Path
2.	Probability of given state
3.	Total Probability of the system

Instructions to run
1.	Save the code file as MyViterbiAlgo.java
2.	Go to command prompt, move to the location where your file is located and then type following commands over there-
javac MyViterbiAlgo.java (To compile the code) and press Enter.
java MyViterbiAlgo (To execute the code) and press Enter.

