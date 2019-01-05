package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RabinKarp {
  public int rabinKarp(String text, String pattern){
    int tLen = text.length();
    int pLen = pattern.length();
    long hash = hash(text.toCharArray(), pLen);
    long pHash = hash(pattern.toCharArray(), pLen);
    for(int i=0;i<=tLen-pLen ; i++){
      hash = recalculateHash(text.toCharArray(), i-1, i+pLen-1, hash, pLen);
      if(hash == pHash)
        return i;
    }

    return -1;
  }

  private final int HASH_PRIME = 101;
  public long recalculateHash(char[] text, int oldIndex, int newIndex, long oldHash, int patternLength){
    if(oldIndex<0)
      return oldHash;

    // Substract oldIndex from oldHash
    long newHash = oldHash - text[oldIndex];

    // Divide the hash by HASH_PRIME
    newHash/=HASH_PRIME;

    // Add new index multed by Math.pow(PRIME, patternLength)
    newHash += text[newIndex]*Math.pow(HASH_PRIME, patternLength-1);

    // return new hash
    return newHash;
  }

  public long hash(char[] text, int end){
    long hash = 0;
    for(int i=0;i<end;i++){
      hash += text[i]*Math.pow(HASH_PRIME,i);
    }

    return hash;
  }


  @Test
  public void test(){
    String[] inputs = {"abcdefab","fab"};
    int expected = 5;
    assertEquals(expected, rabinKarp(inputs[0], inputs[1]));
  }
}
