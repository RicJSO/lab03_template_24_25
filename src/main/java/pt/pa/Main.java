package pt.pa;

import pt.pa.adts.Position;
import pt.pa.adts.Tree;
import pt.pa.adts.TreeLinked;

/**
 *
 * @author amfs
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String root = "Ecosystem";
        Tree<String> tree = new TreeLinked<>(root);
        Position<String> anchovy = tree.insert(tree.root(), "Anchovy");
        Position<String> tuna = tree.insert(tree.root(), "Tuna");
        Position<String> shark = tree.insert(tree.root(), "Shark");
        Position<String> eagles = tree.insert(tree.root(), "Eagles");
        Position<String> mackerel = tree.insert(tuna, "Mackerel");
        Position<String> barracuda = tree.insert(tuna, "Barracuda");
        Position<String> dolphin = tree.insert(shark, "Dolphin");
        Position<String> snakes = tree.insert(eagles, "Snakes");
        Position<String> rabbits = tree.insert(eagles, "Rabbits");
        Position<String> sardine = tree.insert(barracuda, "Sardine");

        System.out.println(tree.toString());


    }


}
