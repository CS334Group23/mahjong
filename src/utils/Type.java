/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Type.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Enum Type.
 */
public enum Type{
	
	/** The bamboo. */
	BAMBOO(0, 0), 
 /** The character. */
 CHARACTER(1, 36), 
 /** The dot. */
 DOT(2, 72), 
 /** The dragon. */
 DRAGON(3, 108), 
 /** The facedown. */
 FACEDOWN(6, 144), 
 /** The flower. */
 FLOWER(5, 136), 
 /** The wind. */
 WIND(4, 120);
	
	/** The type index. */
	private final int typeIndex;
	
	/** The start id. */
	private final int startId;
	
	/** The index map. */
	private static Map<Integer, Type> indexMap = new HashMap<Integer, Type>();
	static {
		for (Type t : Type.values()) {
			indexMap.put(t.typeIndex, t);
		}
	}
	
	/**
	 * Instantiates a new type.
	 *
	 * @param typeIndex the type index
	 * @param startId the start id
	 */
	private Type(int typeIndex, int startId) {
		this.typeIndex = typeIndex;
		this.startId = startId;
	}
	
	/**
	 * Gets the type.
	 *
	 * @param idx the idx
	 * @return the type
	 */
	public static Type getType(int idx) {
		return indexMap.get(idx);
	}
	
	/**
	 * Gets the type index.
	 *
	 * @return the type index
	 */
	public int getTypeIndex() {
		return typeIndex;
	}
	
	/**
	 * Gets the start id.
	 *
	 * @return the start id
	 */
	public int getStartId() {
		return startId;
	}
	
	/**
	 * Checks if is same type.
	 *
	 * @param type the type
	 * @return true, if is same type
	 */
	public boolean isSameType(Type type) {
		if(this.getTypeIndex()==type.getTypeIndex())
			return true;
		return false;
	}
}
