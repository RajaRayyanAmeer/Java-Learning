public class MinExample
{
 public static int min(int a, int b)
 {
  if (a < b)
  {
   return a;
  }
  else
  {
   return b;
  }  
 }

 public static float min(float a, float b)
 {
  if (a < b)
  {
   return a;
  }
  else
  {
   return b;
  }      
 }

 public static void main(String[] args)
 {
  System.out.println("Smaller of 10 and 20 (int): " + min(10, 20));
  System.out.println("Smaller of 0.1 and 4.9 (float): " + min(0.1f, 4.9f));
 }
}