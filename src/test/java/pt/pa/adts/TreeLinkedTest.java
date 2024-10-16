package pt.pa.adts;

import javax.swing.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TreeLinkedTest {

    Tree<String> tree;
    Position<String> anchovy;
    Position<String> tuna;
    Position<String> shark;
    Position<String> eagles;
    Position<String> mackerel;
    Position<String> barracuda;
    Position<String> dolphin;
    Position<String> snakes;
    Position<String> rabbits;
    Position<String> sardine;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        String root = "Ecosystem";
        tree = new TreeLinked<>(root);
        anchovy = tree.insert(tree.root(), "Anchovy");
        tuna = tree.insert(tree.root(), "Tuna");
        shark = tree.insert(tree.root(), "Shark");
        eagles = tree.insert(tree.root(), "Eagles");
        mackerel = tree.insert(tuna, "Mackerel");
        barracuda = tree.insert(tuna, "Barracuda");
        dolphin = tree.insert(shark, "Dolphin");
        snakes = tree.insert(eagles, "Snakes");
        rabbits = tree.insert(eagles, "Rabbits");
        sardine = tree.insert(barracuda, "Sardine");
    }

    @org.junit.jupiter.api.Test
    void size() {
    assertEquals(11, tree.size());
    tree.insert(tree.root(),"test");
    assertEquals(12, tree.size());
    }

    @org.junit.jupiter.api.Test
    void testSize() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    assertFalse(tree.isEmpty());
    tree.remove(tree.root());
    assertTrue(tree.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void replace() {
    }

    @org.junit.jupiter.api.Test
    void root() {
    }

    @org.junit.jupiter.api.Test
    void parent() {
    }

    @org.junit.jupiter.api.Test
    void children() {
        ArrayList<Position<String>> list = new ArrayList<>();
        list.add(mackerel);
        list.add(barracuda);
        assertEquals(list, tree.children(tuna));
        assertThrows(InvalidPositionException.class, () -> tree.children(null));
    }

    @org.junit.jupiter.api.Test
    void isInternal() {
    }

    @org.junit.jupiter.api.Test
    void isExternal() {
        Position<String> testPos = tree.insert(tree.root(), "test");
        assertTrue(tree.isExternal(testPos));
        tree.insert(testPos, "test2");
        assertFalse(tree.isExternal(testPos));
        tree.remove(testPos);
        assertThrows(InvalidPositionException.class, () -> tree.isExternal(null));
    }

    @org.junit.jupiter.api.Test
    void isRoot() {
        assertTrue(tree.isRoot(tree.root()));
        Position<String> testPos = tree.insert(tree.root(), "test");
        assertFalse(tree.isRoot(testPos));
        assertThrows(InvalidPositionException.class, () -> tree.isRoot(null));
    }

    @org.junit.jupiter.api.Test
    void insert() {
    }

    @org.junit.jupiter.api.Test
    void testInsert() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void positions() {
    }

    @org.junit.jupiter.api.Test
    void elements() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ecosystem");
        list.add("Anchovy");
        list.add("Tuna");list.add("Mackerel");
        list.add("Barracuda");
        list.add("Sardine");
        list.add("Shark");
        list.add("Dolphin");
        list.add("Eagles");
        list.add("Snakes");
        list.add("Rabbits");
        assertEquals(list, tree.elements());
    }

    @org.junit.jupiter.api.Test
    void height() {
    }

    @org.junit.jupiter.api.Test
    void move() {
    }

    @org.junit.jupiter.api.Test
    void isAncestor() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void testInsertShouldReturnCorrectPosition() {
        Position<String> testPos = tree.insert(sardine, "test");
        assertEquals("test", testPos.element());
    }

    @org.junit.jupiter.api.Test
    void testRemoveShouldReturnCorrectPosition() {
        String correctString = tree.remove(sardine);
        assertEquals("Sardine", correctString);
    }

    @org.junit.jupiter.api.Test
    void testInsertThrowsInvalidPositionException() {
        assertThrows(InvalidPositionException.class, () -> tree.insert(null, "test"));
    }

    @org.junit.jupiter.api.Test
    void degree() {
        assertEquals(4, tree.degree(tree.root()));
        Position<String> testPos = tree.insert(tree.root(), "test");
        assertEquals(5, tree.degree(tree.root()));
    }
}