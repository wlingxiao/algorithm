package algorithm.tree;

import lombok.val;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTreeTest {

    @Test
    public void test_path1() {
        var tree = ListTree.genTree();

        val a1Path = ListTree.path1(tree, "A1");
        assertIterableEquals(List.of("A1"), a1Path);

        val b2Path = ListTree.path1(tree, "B2");
        assertIterableEquals(List.of("A1", "B2"), b2Path);

        val c3Path = ListTree.path1(tree, "C3");
        assertIterableEquals(List.of("A1", "B2", "C3"), c3Path);

        val d1Path = ListTree.path1(tree, "D1");
        assertIterableEquals(List.of("A1", "B2", "C2", "D1"), d1Path);
    }

    @Test
    public void test_path2() {
        var tree = ListTree.genTree();

        val a1Path = ListTree.path2(tree, "A1");
        assertIterableEquals(List.of("A1"), a1Path);

        val b2Path = ListTree.path2(tree, "B2");
        assertIterableEquals(List.of("A1", "B2"), b2Path);

        val c3Path = ListTree.path2(tree, "C3");
        assertIterableEquals(List.of("A1", "B2", "C3"), c3Path);

        val d1Path = ListTree.path2(tree, "D1");
        assertIterableEquals(List.of("A1", "B2", "C2", "D1"), d1Path);
    }

}
