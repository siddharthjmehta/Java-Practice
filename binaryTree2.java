import java.util.ArrayList;
import java.util.LinkedList;


public class binaryTree2 {

public static void main(String args[])
{
new binaryTree2().run();
}

public static class Node
{
Node left;
Node right;
int value;
public Node(int value)
{
this.value=value;
}
}

public void run()
{
Node rootnode =new Node(25);
  insert(rootnode, 11);
  insert(rootnode, 15);
  insert(rootnode,20);
  insert(rootnode,6);
  insert(rootnode, 16);
  insert(rootnode,-16);
  insert(rootnode, 23);
  insert(rootnode, 79);
 
  insert(rootnode,-23);
       
  printInOrder(rootnode);
 
  int maxdeep = maxDepth(rootnode);
  int mindeep = minDepth(rootnode);
  System.out.println( " Maxdepth = "+maxdeep+ " mindepth = " + mindeep);
  int diff = maxdeep - mindeep;
  if(diff <=1)
  {
  System.out.println(" The tree is balanced...");
  }
  else
  {
  System.out.println(" The tree is not balanced...");
  }
 
  //to insert an array to tree
  int array[] = {1,2,3,4,5,6,7,12,13,14};
  Node arrnode=addToTree(array, 0, array.length-1);
  printInOrder(arrnode);
  ArrayList<LinkedList<Node>> lss =findLevelLinkedList(rootnode);
 
  //common ancestor

 Node common =commonAncester(arrnode, new Node(4),new Node(14) );
  System.out.println(" The common node = "+common.value);
 
  //level of a tree

  int level1=maxDepth(rootnode)-1;
  System.out.println(" level of the tree = "+level1);
 
  //to find the sum of the tree

  System.out.println(" Finding the sum of the tree..");
  ArrayList<Integer> coolbuffer = new ArrayList<Integer>();
  findSum(rootnode,26,coolbuffer,0);
}

public void insert(Node node, int value)
{
if(value<node.value)
{
if(node.left!= null)
{
insert(node.left,value);
}
else
{
node.left=new Node(value);
}
}
else
{
if(node.right!=null)
{
insert(node.right, value);
}
else
{
node.right = new Node(value);
}
}
}


//code for inorder

public void printInOrder(Node node)
{
if(node!=null)
{
printInOrder(node.left);
System.out.println("Traversed "+node.value);
printInOrder(node.right);
}
}

//code to find the maximum depth

public static int maxDepth(Node node)
{
if(node==null)
return 0;
return 1+ Math.max(maxDepth(node.left), maxDepth(node.right));
}

//code to find the minimum depth

public static int minDepth(Node node)
{
if(node==null)
return 0;
return 1+ Math.min(minDepth(node.left), minDepth(node.right));
}

//code for add to tree

public static Node addToTree(int arr[], int start, int end)
{
if(end < start)
{
return null;
}
else
{
int mid = (end +start)/2;
Node newnode = new Node(arr[mid]);
newnode.left = addToTree(arr, start, mid-1);
newnode.right =addToTree(arr, mid+1, end);
return newnode;
}
}

//code to find elements in each level

public ArrayList<LinkedList<Node>> findLevelLinkedList(Node node)
{
int level=0;
ArrayList<LinkedList<Node>> result =new ArrayList<LinkedList<Node>>();
LinkedList<Node> list = new LinkedList<Node>();
list.add(node);
result.add(level,list);
while(true)
{
list = new LinkedList<Node>();
for(int i=0; i<result.get(level).size(); i++)
{
Node n = (Node) result.get(level).get(i);
if(n!=null)
{
if(n.left!=null) list.add(n.left);
if(n.right != null) list.add(n.right);
}
}
if(list.size()>0)
{
result.add(level+1,list);
}
else
{
break;
}
level++;
}
return result;
}

//code to find the common ancestors in the list

public Node commonAncester(Node node, Node p, Node q)
{
if(covers(node.left,p)&&covers(node.left,q))
{
return commonAncester(node.left, p, q);
}
if(covers(node.right,p)&& covers(node.right,q))
{
return commonAncester(node.right, p, q);
}
return node;
}

public boolean covers(Node node, Node p)
{
if(node==null)
{
return false;
}
if(node==p)
{
return true;
}
return (covers(node.left,p)|| covers(node.right,p));
}

//find all path whose sum is equal to the given sum

public void findSum(Node node, int sum, ArrayList<Integer> buffer, int level)
{
if(node==null)
return;
int temp =sum;
buffer.add(node.value);
for(int i=level; i>-1; i--)
{   
//System.out.println(" Level = "+i);
temp -= buffer.get(i);
//System.out.println(" Temp ="+temp);
if(temp==0)
{
print(buffer,i,level);
}
}
ArrayList<Integer> c1=(ArrayList<Integer>) buffer.clone();
ArrayList<Integer> c2= (ArrayList<Integer>) buffer.clone();
findSum(node.left,sum,c1,level+1);
findSum(node.right,sum,c2,level+1);
}


public void print(ArrayList<Integer> buffer, int level, int i2)
{
for(int i=level; i<=i2; i++)
{
System.out.println(buffer.get(i) + " ");
}
System.out.println();
}
}
