// Attendence manager App v-1.0.1

import java.util.*;
/**
 * project2
 */
class Node{
    protected String subName;
    protected int attend,absent,totalClasses;
    protected double attendPer;
    protected Node nextNode;
}

public class project2 {

    public static void enterSub(Node startNode){
        Node p,q;
        char ch;
        Scanner sc=new Scanner(System.in);
        p=startNode;
        System.out.print("Enter the subject name : ");
        p.subName=sc.next();
        System.out.println("Select the option : Present(P) | Absent(A)");
        char choice=sc.next().charAt(0);
        if (choice=='P' || choice=='p')
            p.attend++;
        else
            p.absent++;
        p.totalClasses++;

        System.out.println("Do you want to enter more? [YES(Y) | NO(N)]");
        ch=sc.next().charAt(0);
        while (ch=='y' || ch=='Y'){
            q=new Node();
            System.out.print("Enter the subject name : ");
            q.subName=sc.next();
            System.out.print("");
            System.out.println("Select the option : Present(P) | Absent(A)");
            char choice1=sc.next().charAt(0);
            if (choice1=='P' || choice1=='p')
                q.attend++;
            else
                q.absent++;
            q.totalClasses++;
            p.nextNode=q;
            p=q;
            System.out.println("Do you want to enter more? [YES(Y) | NO(N)]");
            ch=sc.next().charAt(0);   
        }

    }

    public static void displaySub(Node startNode){
        System.out.println("Here's all the details of your Curricullum.");
        while(startNode!=null)
		{
            System.out.println("Subject Name : "+startNode.subName);
            System.out.println("Total classes : "+startNode.totalClasses);
            System.out.println("Classes Attended : "+startNode.attend);
            System.out.println("Classes Absent : "+startNode.absent);
            System.out.println();
            startNode=startNode.nextNode;
		}
    } 

    public static void searchSub(Node startNode){
        Node p=startNode;
        if (startNode==null) {
            System.out.println("Oops!! No Data");
            System.exit(0);
        } else {
            Scanner sc=new Scanner(System.in);
            int sub=1;
            while (startNode !=null) {
                System.out.println(sub+" : "+startNode.subName);
                startNode=startNode.nextNode;
                sub++;
            }
            System.out.print("Enter the choice : ");
            String ch=sc.next();
            updateAttendance(p,ch);
        }
    }

    public static void updateAttendance(Node startNode,String choice){
        
        Scanner in=new Scanner(System.in);
        Node p,q;
        q=null;
        p=startNode;
        while(p!=null){
            if (choice.equalsIgnoreCase(p.subName)) {
                System.out.print("Select the option : Present(P) | Absent(A)");
                char ch=in.next().charAt(0);
                if (ch=='P' || ch=='p')
                    p.attend++;
                else
                    p.absent++;
                p.totalClasses++;
                System.out.println("Attendance Updated !!");
            }
            p=p.nextNode;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
		Node p=new Node();
		char token;
		do
		{
            System.out.println("Welcome to Attendance Manager App.");
			System.out.println("				             ");
			System.out.println("***** M E N U *****");
			System.out.println("0: Exit");
			System.out.println("1: Creation");
            System.out.println("2: Display");
            System.out.println("3: Update Attendance");
			System.out.println("*******************");
			System.out.print("Enter your choice");
            int ch=in.nextInt();
			switch(ch)
			{
				case 0:System.out.println("Program Terminated.");
					System.exit(0);
                break;
                
				case 1:enterSub(p);
				break;
				
				case 2:displaySub(p);
                break;
                
                case 3:searchSub(p);
                break;
				
                default: System.out.println("Wrong choice !!    // Please check your input //");
				
			}
			System.out.println("Do you want to continue? [Yes(Y) | No(N)]");
			token=in.next().charAt(0);
		}while(token=='y' || token=='Y');
    }
}
