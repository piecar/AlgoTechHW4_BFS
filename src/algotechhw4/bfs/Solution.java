/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algotechhw4.bfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author piecar
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        class Node {
            private int vert;
            private String color;
            private int dist;
            private int parent;
            
            Node(int key, String val){
                this.vert = key;
                this.color = val;
                this.dist = Integer.MAX_VALUE;
                this.parent = 0;
            }
            
            int getVert(){
                return vert;
            }
            String getColor(){
                return color;
            }            
            int getDist(){
                return dist;
            }
            int getParent(){
                return parent;
            }
            void setColor(String color){
                this.color = color;
            }
            void setDist(int dist){
                this.dist = dist;
            }
            void setParent(int parent){
                this.parent = parent;
            }
        }
        
        System.out.print("STDIN: ");
        Scanner scan = new Scanner(System.in);   
        //Scanner scan = new Scanner(new File("SampleInput.txt"));
        int numGraphs = scan.nextInt();
        for(int i=1; i <= numGraphs; i++)
        {
            int numVerts = scan.nextInt();
            int numEdges = scan.nextInt();
            ArrayList[] adjList = new ArrayList[numVerts+1];
            Node[] nodes = new Node[numVerts+1];
            LinkedList queue = new LinkedList();
            
            //Populate adjacency list with linked lists
            for(int j=1; j <= numVerts; j++)
            {
                ArrayList adjVerts = new ArrayList();
                adjList[j] = adjVerts;
                nodes[j] = new Node(j, "W");
            }
            
            // Create adjacency List with all nodes initilized to white
            for(int j=1; j <= numEdges; j++)
            {
                int x = scan.nextInt();
                int y = scan.nextInt();
                
                adjList[x].add(y);
                adjList[y].add(x);
            }
            
            int start = scan.nextInt();
            nodes[start].setColor("G");
            nodes[start].setDist(0);
            queue.add(start);
            
            //Graph Traversal
            while(!queue.isEmpty())
            {
                int curr = (Integer) queue.remove();
                for(int j=0; j < adjList[curr].size(); j++)
                {
                    int neighbor = (Integer) adjList[curr].get(j);
                    if(nodes[neighbor].getColor().equals("W"))
                    {
                        nodes[neighbor].setColor("G");
                        nodes[neighbor].setParent(curr);
                        nodes[neighbor].setDist(nodes[curr].getDist() + 6);
                        queue.add(neighbor);
                    }
                }
                nodes[curr].setColor("B");
            }
            //Set all int MAX_VALUE node distances to -1
            for(int j=1; j < nodes.length; j++){
                if(nodes[j].getDist() == Integer.MAX_VALUE)
                {
                    nodes[j].setDist(-1);
                }
            }
            
            //Output
//            System.out.println("OUT: Graph " + i + "\n");
//            for(int j=1; j < nodes.length; j++){
//                System.out.println( "For vertex " + j + " the distance is " +
//                        nodes[j].getDist());
//            }
//            System.out.println( " ");
            for(int j=1; j < nodes.length; j++){
                if(start != j){
                System.out.print( nodes[j].getDist() + " ");
                }
            }
            System.out.println( " ");
                
            
        }
    }
    
}
