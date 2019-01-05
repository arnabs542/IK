package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IpAddress {
  public String[] getSeries(String ipv4Address, int count){
    String ipv4NwAddress = ipv4Address.substring(0, ipv4Address.lastIndexOf('.'));
    String ipv4HostAddress = ipv4Address.substring(ipv4Address.lastIndexOf('.')+1);
    int ipAddr = Integer.parseInt(ipv4HostAddress);
    String[] outputs = new String[count];
    for(int i =0; i < count; i++){
      outputs[i] = ipv4NwAddress+"."+(ipAddr++);
    }

    return outputs;
  }

  @Test
  public void test(){
    String input = "192.168.1.2";
    int count = 3;
    String[] expected = {"192.168.1.2","192.168.1.3","192.168.1.4"};
    assertArrayEquals(expected, getSeries(input, count));
  }

}