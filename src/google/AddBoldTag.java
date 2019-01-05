package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBoldTag {
  String bOpen = "<b>";
  String bClosed = "</b>";

  // Best 6 msec
  public String addBoldTagBest(String s, String[] dict) {
    int len = s.length();
    boolean[] bold = new boolean[len];
    for (String d: dict){
      int start = 0;
      while(start<len){
        start = s.indexOf(d,start);
        if (start<0) break;
        int end = start+d.length()-1;
        for (int i=start;i<=end;i++){
          bold[i] = true;
        }
        start++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0;i<bold.length;i++){
      if (bold[i] && (i==0|| !bold[i-1] ))
        sb.append("<b>");
      sb.append(s.charAt(i));
      if (bold[i] && (i+1==s.length() || !bold[i+1]))
        sb.append("</b>");
    }
    return sb.toString();
  }

  public String addBoldTag(String s, String[] dict) {
    boolean[] status = new boolean[s.length()];
    int counter = 0;
    while(counter < s.length()) {
      for (String word : dict) {
        if (s.startsWith(word, counter)) {
          for (int j = counter; j < counter + word.length(); j++)
            status[j] = true;

          counter = counter+word.length()-1;
        }
      }
      counter++;
    }

    StringBuilder builder = new StringBuilder();
    for(int i=0;i<status.length;){
      if(!status[i])
        builder.append(s.charAt(i++));
      else {
        builder.append(bOpen);
        int j=i;
        while(j<s.length() && status[j]){
          builder.append(s.charAt(j));
          j++;
        }
        builder.append(bClosed);
        i = j;
      }
    }

    return builder.toString();
  }

  @Test
  public void test(){
    String input = "Everything for world in peace";
    String[] dict = {"world","peace"};
    String expected = "Everything for <b>world</b> in <b>peace</b>";
    assertEquals(expected, addBoldTag(input, dict));
  }

  @Test
  public void test2(){
    String input = "aaabbcc";
    String[] dict = {"a","b","c"};
    String expected = "<b>aaabbcc</b>";
    assertEquals(expected, addBoldTag(input, dict));
  }

}
