package test;

import org.junit.Assert;
import org.junit.Test;

import net.datastructures.SinglyLinkedList;

public class TestRemoveOdd {
	
	@Test
	public void testRemoveLast1() {		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();		
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		
		SinglyLinkedList<String> listRet = new SinglyLinkedList<String>();				
		listRet.addLast("B");
		listRet.addLast("D");
		Assert.assertEquals(list.removeOdd(), listRet);
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();				
		listRes.addLast("A");
		listRes.addLast("C");		
		Assert.assertEquals(list, listRes);
		
		Assert.assertEquals(list.size(), 2);	
		
		list.addFirst("0");
		list.addLast("9");
		
		listRes.addFirst("0");
		listRes.addLast("9");
		Assert.assertEquals(list, listRes);
		
		
		
	}

	@Test
	public void testRemoveLast2() {		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();		
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");		
		
		SinglyLinkedList<String> listRet = new SinglyLinkedList<String>();				
		listRet.addLast("B");		
		Assert.assertEquals(list.removeOdd(), listRet);
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();				
		listRes.addLast("A");
		listRes.addLast("C");		
		Assert.assertEquals(list, listRes);
		
		Assert.assertEquals(list.size(), 2);
		
		list.addFirst("0");
		list.addLast("9");
		
		listRes.addFirst("0");
		listRes.addLast("9");
		Assert.assertEquals(list, listRes);
		
	}
	
	@Test
	public void testRemoveLast3() {		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();		
		list.addLast("A");
		list.addLast("B");		
		
		SinglyLinkedList<String> listRet = new SinglyLinkedList<String>();				
		listRet.addLast("B");		
		Assert.assertEquals(list.removeOdd(), listRet);
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();				
		listRes.addLast("A");
		Assert.assertEquals(list, listRes);
		
		Assert.assertEquals(list.size(), 1);			
	}
	
	@Test
	public void testRemoveLast4() {		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();		
		list.addLast("A");
		
		SinglyLinkedList<String> listRet = new SinglyLinkedList<String>();						
		Assert.assertEquals(list.removeOdd(), listRet);
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();				
		listRes.addLast("A");		
		Assert.assertEquals(list, listRes);
		
		Assert.assertEquals(list.size(), 1);			
	}
	
	@Test
	public void testRemoveLast5() {		
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();		
				
		SinglyLinkedList<String> listRet = new SinglyLinkedList<String>();						
		Assert.assertEquals(list.removeOdd(), listRet);
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();							
		Assert.assertEquals(list, listRes);
		
		Assert.assertEquals(list.size(), 0);			
	}
		
}
