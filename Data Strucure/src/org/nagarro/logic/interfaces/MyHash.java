package org.nagarro.logic.interfaces;

public interface MyHash<K , V> extends Iterable<K> {
	
	public boolean put(K key , V value);
	
	public void remove (K key);
	
	public boolean contains(K key);
	
	public int size();
	
	public void traverse();
	
	

}
