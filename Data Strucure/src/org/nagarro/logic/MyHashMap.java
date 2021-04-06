package org.nagarro.logic;

import java.util.Iterator;
import org.nagarro.logic.Iterators.MyHashMapIterator;
import org.nagarro.logic.interfaces.MyHash;
import org.nagarro.logic.nodes.HashNode;

public class MyHashMap<K, V> implements MyHash<K, V> {

	private HashNode<K, V>[] myHashMap;
	private int capacity;
	private int size;

	public MyHashMap() {
		this.capacity = 10;
		this.myHashMap = new HashNode[capacity];
		this.size = 0;
	}

	private void growArray() {
		capacity += capacity / 2;
		HashNode<K, V>[] tempMap = myHashMap;
		myHashMap = new HashNode[capacity];
		for (int i = 0; i < tempMap.length; i++) {
			HashNode<K, V> tempNode = tempMap[i];
			while (tempNode != null) {
				long hashKey = hashCode(tempNode.getKey());
				hashKey = hashKey % capacity;
				HashNode<K, V> temp = new HashNode<>(tempNode.getKey(), tempNode.getValue());
				temp.setNextNode(myHashMap[(int) hashKey]);
				myHashMap[(int) hashKey] = temp;
				tempNode = tempNode.getNextNode();
			}

		}
		tempMap = null;

	}

	private long hashCode(K key) {
		long hashValue = 5381;
		String keyHash = key.toString();
		for (int i = 0; i < keyHash.length(); i++) {
			hashValue = hashValue * 33 + keyHash.charAt(i);
		}
		return hashValue;
	}

	@Override
	public Iterator<HashNode<K, V>> iterator() {
		return new MyHashMapIterator<>(capacity, myHashMap, size);
	}

	@Override
	public boolean put(K key, V value) {
		long hashKey = hashCode(key);
		hashKey = hashKey % capacity;
		HashNode<K, V> head = myHashMap[(int) hashKey];
		while (head != null) {
			if (key.equals(head.getKey())) {
				head.setValue(value);

				return true;
			}
			head = head.getNextNode();
		}

		HashNode<K, V> tempNode = new HashNode<>(key, value);
		tempNode.setNextNode(myHashMap[(int) hashKey]);
		myHashMap[(int) hashKey] = tempNode;
		size++;
		if ((capacity - (size / 4) <= size)) {
			growArray();
		}
		return true;
	}

	@Override
	public void remove(K key) {
		long hashKey = hashCode(key);
		hashKey = hashKey % capacity;
		HashNode<K, V> head = myHashMap[(int) hashKey];
		HashNode<K, V> prev = null;
		while (head != null && !head.getKey().equals(key)) {
			prev = head;
			head = head.getNextNode();
		}
		if (head != null) {
			size--;
			if (prev != null) {
				prev.setNextNode(head.getNextNode());
			} else {
				myHashMap[(int) hashKey] = null;
			}
		} else {
			throw new IllegalStateException("Hash Does Not Contain this Key");
		}

	}

	@Override
	public boolean contains(K key) {
		long hashKey = hashCode(key);
		hashKey = hashKey % capacity;
		HashNode<K, V> tempNode = myHashMap[(int) hashKey];

		while (tempNode != null) {
			if (key.equals(tempNode.getKey())) {

				return true;
			}
			tempNode = tempNode.getNextNode();
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void traverse() {
		for (int i = 0, j = 0; i < capacity; i++) {
			HashNode<K, V> tempNode = myHashMap[i];
			while (tempNode != null) {
				System.out.print("[" + tempNode.getKey() + ":" + tempNode.getValue() + "]");
				j++;
				if (j < size()) {
					System.out.print("==>");
				}
				tempNode = tempNode.getNextNode();
			}

		}
		System.out.println();
	}

	@Override
	public V get(K key) {
		long hashKey = hashCode(key);
		hashKey = hashKey % capacity;
		HashNode<K, V> tempNode = myHashMap[(int) hashKey];

		while (tempNode != null) {
			if (key.equals(tempNode.getKey())) {

				return tempNode.getValue();
			}
			tempNode = tempNode.getNextNode();
		}
		throw new IllegalStateException("Hash Does Not Contain this Key");
	}

}
