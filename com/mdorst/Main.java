package com.mdorst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public static Node createTree(String path)
    {
        try (Scanner scanner = new Scanner(new File(path)))
        {
            Node root = new Node(scanner.nextInt());
            Node row_start = root;
            Node node_above = null;
            for (int i = 0; i < 80; i++)
            {
                Node n = row_start;
                for (int j = 1; j < 80; j++)
                {
                    n.right = new Node(scanner.nextInt());
                    // for all rows except the top row...
                    if (i > 0)
                    {
                        node_above.down = n;
                        node_above = node_above.right;
                    }
                    n = n.right;
                }
                node_above = row_start;
                row_start.down = new Node(scanner.nextInt());
                row_start = row_start.down;
            }
            return root;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Node(0);
        }
    }
}
