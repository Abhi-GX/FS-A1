import java.util.*;



public class FlatLinked {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of top-level nodes: ");
        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> input = new ArrayList<>();

        System.out.println("Enter each line as: horizontalNode [child1 child2 ...]");
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            List<Integer> row = new ArrayList<>();
            for (String p : parts) {
                row.add(Integer.parseInt(p));
            }
            input.add(row);
        }

        Node head = buildList(input);
        Node temp=head;
        printList(head);
        while(temp!=null && temp.nexth!=null){
          Node dum=new Node(-1);
          Node temp1=temp;
          Node temp2=temp.nexth;
          Node temp22=temp2.nexth;
          temp=dum;
          while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
              dum.nextv=temp1;
              temp1=temp1.nextv;
            }else{
              dum.nextv=temp2;
              temp2=temp2.nextv;
            }
            dum=dum.nextv;
          }
          if(temp1 != null){
            dum.nextv = temp1;
          }
          if(temp2 != null){
            dum.nextv = temp2;
          }
          
          System.out.println(" hello");
          temp=temp.nextv;
          temp.nexth=temp22;
        }
        System.out.println("\nMulti-level List Structure:");
        printList(temp);
    }

    public static Node buildList(List<List<Integer>> data) {
        Node head=new Node(-1);
        Node temp=head;
        for(List<Integer> row : data){
          Node temp2=new Node(row.get(0));
          // System.out.println("head : "+temp2.val);
          temp.nexth=temp2;
          for(int i=1;i<row.size();i++){
            temp2.nextv=new Node(row.get(i));
            temp2=temp2.nextv;
            // System.out.print(" "+temp2.val);
          }
          temp=temp.nexth;
        }
        return head.nexth;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.println("\n  head:"+ "- " + node.val);
            Node temp=node;
            while (temp.nextv != null) {
                System.out.print(" "+temp.nextv.val);
                temp=temp.nextv;
            }
            node = node.nexth;
        }
    }
}
class Node {
    int val;
    Node nexth; // horizontal
    Node nextv; // vertical

    Node(int val) {
        this.val = val;
    }
}
