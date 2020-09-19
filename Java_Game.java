public class Java_Game {
   public static void main(String[] args) {
          // TODO自动生成的方法存根
  Scanner in = new Scanner(System.in);
  System.out.println("请猜一个0-100之间的整数：");
  int number = (int)(Math.random()*100+1); //Math.random()将随机生成[0,1）之间的数字
  int result=0;
  int count =0;
  do{
    result = in.nextInt();
    count += 1;
    if ( result>number)
    {
      System.out.println("偏大");
    }
    else if(result<number) {
      System.out.println("偏小");
    }
  }while(result!=number);
  System.out.println("***********************");
  System.out.println("恭喜你猜对了！！总共猜了"+count+"次");
  System.out.println("***********************");
   }

}