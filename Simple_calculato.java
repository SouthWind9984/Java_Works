import java.util.Scanner;

public class Simple_calculato {

  public static void main(String[] args) {
    // TODO 自动生成的方法存根
    Scanner in = new Scanner(System.in);
    break_up:                  //goto语句标识
    for(;;)                   //死循环
    {
      System.out.println("请输入两个整数用空格隔开（注意！！若输入-1将结束运算）：");
      int number1 = in.nextInt();
      int number2 = in.nextInt();
      if (number1 == -1 || number2 == -1)
        break break_up;            //终止
      System.out.println("请选择运算符（1加2减3乘4除）：");
      int op = in.nextInt();
      double result = 0;
        switch (op)
        {
          case 1:
            result = number1+number2;
            System.out.println(number1+"+"+number2+"="+result);
            break;
          case 2:
            result = number1-number2;
            System.out.println(number1+"-"+number2+"="+result);
            break;
          case 3:
            result = number1*number2;
            System.out.println(number1+"*"+number2+"="+result);
            break;
          case 4:
            result = (double) number1/number2;
            System.out.printf("%d/%d=%.2f\n",number1,number2,result);
            break;
          default:
            System.out.println("啊！什么？运算格式输入错误");
            break;
        }
    }
  }
}