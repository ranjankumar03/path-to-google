package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A student is taking a test on n different subjects. For
each i th subject they have already answered
answered[i] questions and have time to answer a total
of q more questions overall. For each i th subject, the
number of questions answered has to be at least
needed{i] in order to pass. Determine the maximum
number of subjects the student can pass if the
q additional answered questions are optimally
distributed among the subjects.
For example, there are n = 2 subjects and needed = {4,
5] answered questions, respectively, to pass. The
student has answered answered = [2, 4] questions in
the two subjects so far, and can answer another q =
I questions in all subjects combined. The best
outcome is to answer an additional question in the
second subject to pass it, and it is not possible to pass
the first subject. The maximum number of subjects
that can be passed is T.
Function Description
Complete the function maxSubjectsNumber in the
editor below. The function must return an integer that
represents the maximum number of subjects that can
be passed.
maxSubjectsNumber has the following parameter(s):
answered{answered[0],… answered[n-7]j: an array
of integers
an array of
integers
q. an integer

constraints
1<n<10 raised to power 5
0<=answered[i], needed[i], q<=10 raised to power 9
 
Total Complexity: O(nlogn) (dominated by sorting)
*/
public class MaxSubjectsNumber {

    public static void main(String[] args){

        List<Integer> answered = new ArrayList<Integer>(Arrays.asList(2, 4));
        List<Integer> needed = new ArrayList<>(Arrays.asList(4,5));
        int q = 1;

        System.out.println(maxSubjectsNumber(answered, needed , q));
    }
    
    private static int maxSubjectsNumber(List<Integer> answered, List<Integer> needed, int q) {

        int len = answered.size();
        List<Integer> remaining = new ArrayList<>();

        for(int i=0;i<len;i++){
            int diff = Math.max(0, needed.get(i)- answered.get(i));
            remaining.add(diff);
        }

        Collections.sort(remaining);

        int maxSubjectPassed = 0;
        
        for(int i=0;i<len;i++){
            if(q>=remaining.get(i)){
                q-=remaining.get(i);
                maxSubjectPassed++;
            }else{
                break;
            }
        }

        return maxSubjectPassed;
    }
}
