package org.nagarro.logic.interfaces;

import org.nagarro.logic.nodes.HashNode;

public interface MyHash<K , V> extends Iterable<HashNode<K, V>> {
	
	public boolean put(K key , V value);
	
	public void remove (K key);
	
	public V get(K key);
	
	public boolean contains(K key);
	
	public int size();
	
	public void traverse();
	
	

}
