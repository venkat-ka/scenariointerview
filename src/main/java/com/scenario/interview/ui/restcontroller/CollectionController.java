package com.scenario.interview.ui.restcontroller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scenario.interview.entity.PriorityStudenRankEntity;
import com.scenario.interview.entity.UsersEntity;

@RequestMapping("/collection")
@RestController
public class CollectionController {
	
	@GetMapping("/")
	public String getHome() {
	return "check in";
	}
	
	
	// LinkedList LinkedHashSet
	
	@GetMapping("/hashset")
	public HashSet<String> HashSet(){
		HashSet<String> hashSet  = new HashSet<String>();
		hashSet.add("HashSet is unorder set");
		hashSet.add("HashSet contain unique value");
		hashSet.add("HashSet implecitly implement HashTable");
		hashSet.add("HashSet have one null element not more than one");
		return hashSet;
	}
	
	@GetMapping("/linkedHashset")
	public LinkedHashSet<String> linkedHashlist(){
		LinkedHashSet<String> linkedHashSet  = new LinkedHashSet<String>();
		linkedHashSet.add("Ordered Version of HashSet which maintain a doubly linked list"
				+ "accross all element");
		linkedHashSet.add("Implicilty implement doubly linked list but in Java 8 Tree Map implemented");
		linkedHashSet.add("It preserves the insertion order");
		
		
		return linkedHashSet;
	}
	
	@GetMapping("/treeset")
	public TreeSet<String> treeset_sortedInt(){
		TreeSet<String> implfrm_srtedSet_treeset = new TreeSet<>();
		TreeSet<Integer> IntergeTree = new TreeSet<>();
		IntergeTree.add(4);
		IntergeTree.add(7);
		IntergeTree.add(6);
		IntergeTree.add(1);
		IntergeTree.add(3);
		implfrm_srtedSet_treeset.add("5. It has Sortedset interface");
		implfrm_srtedSet_treeset.add("7. all the element must implement comparable interface");
		implfrm_srtedSet_treeset.add("2. TreeSet is class.why comparable interface implemented because"
				+ "this TreeSet has unique feature that is all the value stored will be in sorted ascending order");
		implfrm_srtedSet_treeset.add("3. TreeSet uses storage as a Self balacning binary search tree like Red Black Tree");
		//return IntergeTree;
		return implfrm_srtedSet_treeset;
	}
	@GetMapping(path="/hashmap")
	public ArrayList<Map> hashmap(){
		HashMap<Integer, String> hashVlue = new HashMap<Integer, String>();
		hashVlue.put(1,"Map interface is unique interface because it doesn't extend collection interface");
		hashVlue.put(1, "Map has one null key and mulitple null value in nature");
		hashVlue.put(2, "Map doesn't contain duplicate key");
		hashVlue.put(3, "Map is non-syncrosized in nature");
		Hashtable<Integer, String> hshTble = new Hashtable<>();
		hshTble.put(1, "Only difference in HashMap and Hashtable is");
		hshTble.put(2, "HashTable is synchrised in nature");
		hshTble.put(3, "HashTable doesnot allow any null key or values");
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(1,"SortedMap extends treeMap class");
		treeMap.put(2, "To sort in Ascending order for that it uses Red_Black Tree Implementation");
		treeMap.put(3, "It cannot store any null key but store more that one null values");
		treeMap.put(4, "It is not synchronised but to make synchroze we explicitly call Collections.synchronizedMap()");
		
		ArrayList list = new ArrayList<>();
		list.add(hashVlue);
		list.add(hshTble);
		list.add(treeMap);
		return list;
	}
	@GetMapping(path="/priority-queue")
	public PriorityQueue<String> priQuEx(){
		PriorityQueue<String> prQue = new PriorityQueue<>();
		prQue.add("Queue is FIFO means it every element exists in rear end only But Priority Queue will access as per nature orer [ascending order]");
		prQue.add("priority will associated with each element irrespective of insertion order");
		prQue.offer("first");
		
		
		PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
		PriorityQueue<PriorityStudenRankEntity> integerQueueWithComparator = new PriorityQueue<>();
		
		integerQueue.add(3);
		
		integerQueue.add(2);
		
		integerQueue.add(1);
		
		integerQueueWithComparator.add(new PriorityStudenRankEntity(0, "firstw10", 10));
		integerQueueWithComparator.add(new PriorityStudenRankEntity(1, "firstw4", 4));
		integerQueueWithComparator.add(new PriorityStudenRankEntity(2, "firstw50", 50));
		integerQueueWithComparator.add(new PriorityStudenRankEntity(3, "firstw6", 6));
		
		Iterator<PriorityStudenRankEntity> prItr = integerQueueWithComparator.iterator();
		while(prItr.hasNext()) {
			System.out.println("The Item of the queue = "+integerQueueWithComparator.poll().toString());
		}
		
		return prQue;
	}
	
	@GetMapping("/failfastsafe")
	public Map<Integer, String> failFastandFailSafeEx(){
		
		ConcurrentHashMap<Integer, String> mapFfFs = new ConcurrentHashMap<>();
		//Map<Integer, String> mapFfFs = new HashMap<>();
		mapFfFs.put(1, "ConcurrentModification Exception will through on while making modification on iteration that is FailFast");
		
		mapFfFs.put(2, "In Fail Safe no exception will through on modification while iteration because clone of the collection");
		
		mapFfFs.put(3, "synchromise Collection is slower than concurrect collection perpective of Perfomance and scalability. Main reason of blocking meachanism");
		
		Iterator itr = mapFfFs.keySet().iterator();
		while(itr.hasNext()) {
			System.out.println(mapFfFs.get(itr.next()));
			mapFfFs.put(4, "Modifyied Data");
		}
		return mapFfFs;
	}
	
	@GetMapping("/internalprocessInHashMap")
	public Map<Integer, String> interWorkHashMap(){
		Map<Integer, String> intWrk = new HashMap<>();
		intWrk.put(1, "HashMap will work on Hashing mechanism");
		intWrk.put(2, "While calling put method the system will take key data to form hash indexing that called as bucket number. The key value pair will locate in the hash index number");
		intWrk.put(3, "When the different key has a same index allocated in the table then it is called collision. That collision will solved by singly linked list");
		intWrk.put(4, "Singly linked list will solve by checking the key data using equals method this will be doe in Get method");
		return intWrk;
	}
}

