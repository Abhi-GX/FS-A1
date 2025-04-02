import java.util.*;

class TreapNode {
    int data;
    int priority;
    TreapNode left, right;
    int size; // Size of subtree rooted at this node

    TreapNode(int data) {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
        this.size = 1;
    }
}

public class Treap {
    static int k;

    public static int getSize(TreapNode root) {
        return (root == null) ? 0 : root.size;
    }

    public static void updateSize(TreapNode root) {
        if (root != null)
            root.size = 1 + getSize(root.left) + getSize(root.right);
    }

    public static TreapNode rotateLeft(TreapNode root) {
        TreapNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        updateSize(root);
        updateSize(newRoot);
        return newRoot;
    }

    public static TreapNode rotateRight(TreapNode root) {
        TreapNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        updateSize(root);
        updateSize(newRoot);
        return newRoot;
    }

    public static TreapNode insertNode(TreapNode root, int data) {
        if (root == null)
            return new TreapNode(data);

        if (data <= root.data) {
            root.left = insertNode(root.left, data);
            if (root.left.priority > root.priority)
                root = rotateRight(root);
        } else {
            root.right = insertNode(root.right, data);
            if (root.right.priority > root.priority)
                root = rotateLeft(root);
        }
        updateSize(root);
        return root;
    }

    public static void inorder(TreapNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int findKthLargest(TreapNode root, int k) {
        if (root == null)
            return -1;

        int rightSize = getSize(root.right);
        if (rightSize + 1 == k)
            return root.data;
        else if (rightSize >= k)
            return findKthLargest(root.right, k);
        else
            return findKthLargest(root.left, k - rightSize - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k = n - p + 1;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreapNode root = null;
        for (int a : arr) {
            root = insertNode(root, a);
        }

        inorder(root);
        System.out.println();
        System.out.println("The " + p + "-th largest element is: " + findKthLargest(root, k));

        sc.close();
    }
}

