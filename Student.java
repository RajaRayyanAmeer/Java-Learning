import java.util.*;

public class Student {
    private String name;
    private int age;
    private int rollno;
    private float mids;
    private float assi;
    private float finals;

    public void setname(String n) {
        ;
        ;
        ;
        ;
        this.name = n;
    }

    public void setage(int ag) {
        this.age = ag;
    }

    public void setrollno(int roll) {
        this.rollno = roll;
    }

    public void setmids(float mi) {
        this.mids = mi;
    }

    public void setassi(float as) {
        this.assi = as;
    }

    public void setfinals(float fin) {
        this.finals = fin;
    }

    public String getname() {

        return name;
    }

    public int getage() {
        return age;
    }

    public int getrollno() {

        return rollno;
    }

    public float getmids() {

        return mids;
    }

    public float getassi() {

        return assi;
    }

    public float getfinals() {

        return finals;
    }

    public double totalmarks()// member function
    {
        return (mids * 0.2) + (assi * 0.2) + (finals * 0.6);
    }
}

class MS extends Student {
    public void grade(double totalmarks) {
        if (totalmarks > 90) {
            System.out.println("A");
        } else if (totalmarks > 85 && totalmarks < 90) {
            System.out.println("A-");
        } else if (totalmarks > 80 && totalmarks < 85) {
            System.out.println("B+");
        } else if (totalmarks > 75 && totalmarks < 80) {
            System.out.println("B");
        } else if (totalmarks > 70 && totalmarks < 75) {
            System.out.println("B-");
        } else if (totalmarks > 65 && totalmarks < 70) {
            System.out.println("C+");
        } else if (totalmarks > 60 && totalmarks < 65) {
            System.out.println("C");
        } else if (totalmarks > 55 && totalmarks < 60) {
            System.out.println("D+");
        } else if (totalmarks > 50 && totalmarks < 55) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

class PHD extends Student {
    public void grade(double totalmarks) {
        if (totalmarks > 95) {
            System.out.println("A");
        } else if (totalmarks > 80 && totalmarks < 95) {
            System.out.println("A-");
        } else if (totalmarks > 70 && totalmarks < 80) {
            System.out.println("B");
        } else if (totalmarks > 60 && totalmarks < 70) {
            System.out.println("B-");
        } else if (totalmarks > 50 && totalmarks < 60) {
            System.out.println("C");
        } else if (totalmarks > 40 && totalmarks < 50) {
            System.out.println("C-");
        } else if (totalmarks > 30 && totalmarks < 40) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

class Testing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Total Number Of students of Student: ");
        int strength = input.nextInt();
        for (int i = 1; i <= strength; i++) {
            System.out.print("Enter Catagory of Student(Masters/phd): ");
            String category = input.next();
            if (category.equalsIgnoreCase("Masters")) {
                MS msc = new MS();
                System.out.print("Enter name: ");
                msc.setname(input.next());
                System.out.print("Enter age: ");
                msc.setage(input.nextInt());
                System.out.print("Enter rollno: ");
                msc.setrollno(input.nextInt());
                System.out.print("Enter mids: ");
                msc.setmids(input.nextInt());
                System.out.print("Enter assignment: ");
                msc.setassi(input.nextInt());
                System.out.print("Enter finals: ");
                msc.setfinals(input.nextInt());
                msc.getname();
                msc.getage();
                msc.getrollno();
                msc.getmids();
                msc.getassi();
                msc.getfinals();
                double totalmsc = msc.totalmarks();
                System.out.println("Total marks" + totalmsc);
                System.out.print("Grade:  ");
                msc.grade(totalmsc);
            } else if (category.equalsIgnoreCase("PHD")) {
                PHD phd = new PHD();
                System.out.print("Enter name: ");
                phd.setname(input.next());
                System.out.print("Enter age: ");
                phd.setage(input.nextInt());
                System.out.print("Enter rollno: ");
                phd.setrollno(input.nextInt());
                System.out.print("Enter mids: ");
                phd.setmids(input.nextInt());
                System.out.print("Enter assignment: ");
                phd.setassi(input.nextInt());
                System.out.print("Enter finals: ");
                phd.setfinals(input.nextInt());
                phd.getname();
                phd.getage();
                phd.getrollno();
                phd.getmids();
                phd.getassi();
                phd.getfinals();
                double totalphd = phd.totalmarks();
                System.out.println("Total marks" + totalphd);
                System.out.print("Grade: ");
                phd.grade(totalphd);
            }
        }
        input.close();
    }
}