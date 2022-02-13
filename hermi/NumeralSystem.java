package com.hermi;

import java.util.Scanner;

class NumeralSystem {

    public static void main(String[] args) {
        ConvertDecimal obj = new ConvertDecimal();
        TODecimal toDecimal=new TODecimal();
        Scanner scan=new Scanner(System.in);
        System.out.println("Type a number");
        String input= scan.nextLine();
        System.out.println("Choose the input base \n 1. Decimal \n 2. Octal \n 3. Hexa Decimal \n 4. Binary ");
        String choice = scan.nextLine();
        if(choice.equals("1"))
            obj.convert(input);
        else if(choice.equals("2"))
//            System.out.println(toDecimal.AnyToDecimal(input,8));
            obj.convert( toDecimal.AnyToDecimal(input.substring(1),8));
        else if(choice.equals("3"))
            obj.convert( toDecimal.AnyToDecimal(input.substring(2),16));
        else if(choice.equals("4"))
            obj.convert( toDecimal.AnyToDecimal(input,2));

    }
}
class ConvertDecimal{

    void convert(String decimalnum)
    {
        double num= Double.parseDouble(decimalnum);
        System.out.println("Decimal Value is : " + num);

        String binary = Decimalconv(num,2);
        System.out.println("Binary Value is : " + binary);

        String octal = Decimalconv(num,8);
        System.out.println("Octal Value is : 0" + octal);

        String hexa = Decimalconv(num,16);
        System.out.println("HexaDecimal Value is : 0x" + hexa);
    }
   public String Decimalconv(double num,int base){
        double fractionalPart= 0,number;
        int rem=0,integralPart;
        StringBuilder s,j;
        s=new StringBuilder();

        int n=(int) num;
        fractionalPart=num-n;

        while(n!=0) {
            rem=n%base;
            n=n/base;

            if(base==16){
                String h;
                if(rem==10)
                    s.insert(0,"A");
                else if(rem==11)
                    s.insert(0,"B");
                else if(rem==12)
                    s.insert(0,"C");
                else if(rem==13)
                    s.insert(0,"D");
                else if(rem==14)
                    s.insert(0,"E");
                else if(rem==15)
                    s.insert(0,"F");
                else
                    s.insert(0,rem);
            }
            else
                s.insert(0,rem);
        }
//        System.out.print(s+".");
       s.append(".");
        j=new StringBuilder();
        //j.append(".");
        while(fractionalPart!=0) {
            integralPart=(int) (fractionalPart*base);

            if(base==16){
                String h;
                if(integralPart==10)
                    j.insert(0,"A");
                else if(integralPart==11)
                    j.insert(0,"B");
                else if(integralPart==12)
                    j.insert(0,"C");
                else if(integralPart==13)
                    j.insert(0,"D");
                else if(integralPart==14)
                    j.insert(0,"E");
                else if(integralPart==15)
                    j.insert(0,"F");
                else
                    j.insert(0,integralPart);
            }
            else
                j.insert(0,integralPart);

            number=fractionalPart*base;
            fractionalPart=number-integralPart;
        }
        String afterDot= j.toString();
        StringBuffer str= new StringBuffer(afterDot);
        s.append(str.reverse().toString());
        return s.toString();    //1110000.10010

    }
}
class TODecimal
{

    public String AnyToDecimal(String convnum, int base){
       try{ String []strNum=convnum.split("[.]");
        StringBuffer sbf = new StringBuffer(strNum[1]);
        StringBuffer tempo=sbf.reverse();
        int onum= Integer.parseInt(strNum[0]);
        int onum2 = Integer.parseInt(tempo.toString());
        StringBuilder s=new StringBuilder(),j=new StringBuilder();
        int num=0, p = 0,p2=1;
        double num2=0;
        while(onum!=0){
            int temp = onum%10;
            num += temp*Math.pow(base, p);
            onum = onum/10;
            p++;
        }
        while(onum2!=0){
            int temp = onum2%10;
            num2 += temp*Math.pow(base, -p2);
            onum2 = onum2/10;
            p2++;
        }
        s.append(num+num2);
        return s.toString();
       }
       catch(Exception e) {
           int num = Integer.parseInt(convnum, base);
           return Integer.toString(num);
       }

    }

}
