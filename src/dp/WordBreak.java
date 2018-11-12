package dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {
    /*
     * Complete the wordBreak function below.
     */
    static String[] wordBreak(String strWord, String[] strDict) {
        /*
         * Write your code here.
         */
        List<String> list = Arrays.asList(strDict);
        Set<String> set = new HashSet<String>();
        List<String> results = new ArrayList<>();
        set.addAll(list);
        //wordBreak(strWord, set, 0, results, "");
        wordBreak(strWord, 0, set, results, "");
        return results.toArray(new String[0]);
    }

    static boolean wordBreak(String strWord, Set<String> dict, int start, Set<String> result, String resultStr) {
        if(start==strWord.length()) {
            return true;
        }
        for(String dictWord : dict){
            if(dictWord.length() > strWord.length()-start)
                continue;
            String subString = strWord.substring(start, start+dictWord.length());
            if(dictWord.equals(subString)){
                resultStr += resultStr.isEmpty() ? subString : ""+subString;
                if(wordBreak(strWord, dict, start + subString.length(), result, resultStr))
                    result.add(resultStr);
            }
        }

        return false;
    }

    static List<String> wordBreak(String strWord, int start, Set<String> dict){
        if(start== strWord.length()) {
            List<String> result =  new ArrayList<String>();
            result.add("");
            return result;
        }

        List<String> result = new ArrayList<>();
        String token = "";
        for(int i=start; i<strWord.length(); i++){
            token+=strWord.charAt(i);
            if(dict.contains(token)){
                List<String> furtherWords = wordBreak(strWord, i+1, dict);
                // Assuming all words are contained in dict, so no null check on furtherWords
                String word = token;
                furtherWords = furtherWords.stream().map(v -> word+" "+v).collect(Collectors.toList());
                result.addAll(furtherWords);

            }
        }

        return result;

    }

    static void wordBreak(String strWord, int start, Set<String> dict, List<String> results, String result){
        if(start== strWord.length()) {
            results.add(result);
        }

        String token = "";
        for(int i=start; i<strWord.length(); i++){
            token += strWord.charAt(i);
            if(dict.contains(token)){
                String result2 = result.isEmpty()? token : result+" "+token;
                wordBreak(strWord, i+1, dict, results, result2);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] dict = new String[]{"apple", "app", "le", "pie","sss"};
        String word = "applepie";
        String res[] = wordBreak(word, dict);
        System.out.println(Arrays.toString(res));
    }

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String strWord = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int strDictCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] strDict = new String[strDictCount];

        for (int strDictItr = 0; strDictItr < strDictCount; strDictItr++) {
            String strDictItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            strDict[strDictItr] = strDictItem;
        }

        String[] res = wordBreak(strWord, strDict);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(res[resItr]);

            if (resItr != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.close();

        scanner.close();
    }

}
