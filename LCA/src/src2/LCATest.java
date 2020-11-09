package src2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import src2.LCA;

public class LCATest {

	@Test
	public void testFindLCA() {
		LCA tree = new LCA();
		tree.root = new Node(9);
		tree.root.left = new Node(6);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(1);
		tree.root.right.right = new Node(8);
		/*
		 * 			 9 
		 * 			/ \ 
		 * 		   6   2 
		 * 		  / \ / \ 
		 * 		  5 3 1 8
		 */
		assertEquals(6, tree.findLCA(5, 3));
		assertEquals(6, tree.findLCA(6, 3));
		assertEquals(9, tree.findLCA(5, 8));
		assertNotEquals(2, tree.findLCA(9, 8));
		assertNotEquals(6, tree.findLCA(1, 3));
		assertNotEquals(9, tree.findLCA(1, 8));
	}

	@Test
	public void testFindPath() {
		LCA tree = new LCA();
		tree.root = new Node(18);
		tree.root.left = new Node(35);
		tree.root.right = new Node(86);
		tree.root.left.left = new Node(38);
		tree.root.left.right = new Node(94);
		tree.root.right.left = new Node(93);
		tree.root.right.right = new Node(36);
		List<Integer> path = new ArrayList<>();
		path.add(tree.root.data);
		/*
		 			 18 
		 			/ \ 
		 		   35 86 
		 		  / \ / \ 
		 		38 94 93 36
		 */
		assertTrue(tree.findPath(tree.root, 35, path));
		assertTrue(tree.findPath(tree.root, 93, path));
		assertTrue(tree.findPath(tree.root, 36, path));
		assertFalse(tree.findPath(tree.root, 3, path));
		assertFalse(tree.findPath(tree.root, 245, path));
		assertFalse(tree.findPath(tree.root, 0, path));
	}
	
	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA of empty tree:", -1, tree.findLCA(0, 0));
	}
	
	@Test
	public void testOneNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		assertEquals("LCA of a one node tree:", -1, tree.findLCA(1, 0));
	}
	
	@Test
	public void testNonExistentNode() {
		LCA tree = new LCA();
		tree.root = new Node(18);
		tree.root.left = new Node(35);
		tree.root.right = new Node(86);
		tree.root.left.left = new Node(38);
		tree.root.left.right = new Node(94);
		tree.root.right.left = new Node(93);
		tree.root.right.right = new Node(36);
		/*
		 	   18 
			   / \ 
	   		  35 86 
	  		 / \ / \ 
			38 94 93 36
		 */
		assertEquals("LCA of 72 and 91", -1, tree.findLCA(72, 91));
	   	assertEquals("LCA of 18 and 109", -1, tree.findLCA(18, 109));
	}
	
	
	@Test
	public void testSameNodes() {
		LCA tree = new LCA();
		tree.root = new Node(9);
		tree.root.left = new Node(9);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(9);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(9);
		assertEquals("LCA of 9 and 9: ", 9, tree.findLCA(9, 9));
	}
	
	@Test 
	public void unevenTree() { 
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.right = new Node(3);
		assertEquals("LCA of uneven tree:", 2, tree.findLCA(2, 3));	
		assertEquals("LCA of uneven tree:", 1, tree.findLCA(3, 1));
	}

}
