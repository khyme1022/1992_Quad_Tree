import java.util.*;
import java.io.*;

class Main {
  public static char[][] arr;
  public static StringBuilder sb= new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    for(int i=0;i<N;i++){
      arr[i] = br.readLine().toCharArray();
    }
    square(0,0,N,N);
    System.out.print(sb);
  }

  public static void square(int x1,int y1,int x2,int y2){
    
    boolean tf = true;
    for(int i=x1;i<x2;i++){
      if(!tf) break;
      for(int j=y1;j<y2;j++){
        if(!tf) break;
        if(arr[i][j]!=arr[x1][y1]) tf=false;
      }
    }
    if(tf&&arr[x1][y1]=='1') sb.append("1");
    else if(tf&&arr[x1][y1]=='0') sb.append("0");
    else {
      sb.append("(");
      int x = (x1+x2)/2;
      int y = (y1+y2)/2;
      square(x1,y1,x,y);
      square(x1,y,x,y2);
      square(x,y1,x2,y);
      square(x,y,x2,y2);
      sb.append(")");
    }

  }
}