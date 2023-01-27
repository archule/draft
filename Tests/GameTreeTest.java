package Tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTreeTest {

    @Test
    public void testAddChild() {
        GameTree root = new GameTree(new GameState(), null, null);
        GameTree child = root.addChild(new GameState(), new Action());
        assertEquals(1, root.children.size());
        assertEquals(root, child.parent);
    }

    @Test
    public void testUpdate() {
        GameTree root = new GameTree(new GameState(), null, null);
        root.update(5);
        assertEquals(1, root.visits);
        assertEquals(5, root.reward, 0.1);
    }

    @Test
    public void testSelectChild() {
        GameTree root = new GameTree(new GameState(), null, null);
        GameTree child1 = root.addChild(new GameState(), new Action());
        child1.update(5);
        GameTree child2 = root.addChild(new GameState(), new Action());
        child2.update(10);
        assertEquals(child2, root.selectChild());
    }

    @Test
    public void testIsLeaf() {
        GameTree leaf = new GameTree(new GameState(), null, null);
        assertTrue(leaf.isLeaf());
        GameTree root = new GameTree(new GameState(), null, null);
        root.addChild(new GameState(), new Action());
        assertFalse(root.isLeaf());
    }
}

