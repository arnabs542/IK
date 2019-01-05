package google;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 */
public class NextClosestTime {
  public String nextClosestTime(String time) {
    String[] times = time.split(":");
    int[] digits = new int[4];
    int hours = Integer.parseInt(times[0]);
    int min = Integer.parseInt(times[1]);
    digits[0] = hours/10;
    digits[1] = hours%10;
    digits[2] = min/10;
    digits[3] = min%10;
    Integer[] validTimes = getTimes(digits);
    Arrays.sort(validTimes);
    // Check for next min minutes between min and 60 from validTimes.
    int nextValidMin = getNextValid(min, 60, validTimes);
    StringBuilder nextValidTime = new StringBuilder();
    if(nextValidMin!=-1 && nextValidMin>min) {
      nextValidTime.append(hours);
      nextValidTime.append(":");
      if(nextValidMin<10) nextValidTime.append("0");
      nextValidTime.append(nextValidMin);
      return nextValidTime.toString();
    }

    // Get the next valid hour
    int nextValidHour = getNextValid(hours, 24, validTimes);
    if(nextValidHour!=-1){
      if(nextValidHour<10) nextValidTime.append("0");
      nextValidTime.append(nextValidHour);
      nextValidTime.append(":");
      if(nextValidMin<10) nextValidTime.append("0");
      nextValidTime.append(nextValidMin);
      return nextValidTime.toString();
    }

    return nextValidTime.toString();
  }

  private Integer[] getTimes(int[] digits) {
    List<Integer> validTimes = new ArrayList<>();
    for(int tensDigit : digits){
      for(int onesDigit : digits){
        int time = tensDigit*10+onesDigit;
        if(time<60) validTimes.add(time);
      }
    }
    return validTimes.toArray(new Integer[0]);
  }

  private int getNextValid(int min, int max, Integer[] validTimes) {
    for(int validTime : validTimes){
      if(validTime>min && validTime<max)
        return validTime;
    }

    return validTimes[0];
  }

  @Test
  public void test(){
    String input = "12:03";
    String expected = "12:10";
    assertEquals(expected, nextClosestTime(input));
  }
}
