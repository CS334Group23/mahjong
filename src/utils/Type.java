/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Type.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Type.
 * The Enumerate class which represent the type of a Tile
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
	
	/** The start id of this type of Tile. */
	private final int startId;
	
	/** The hash map of index and type. */
	private static Map<Integer, Type> indexMap = new HashMap<Integer, Type>();
	static {
		for (Type t : Type.values()) {
			indexMap.put(t.typeIndex, t);
		}
	}
	
	/**
	 * Instantiates a new type.
	 *
	 * @param typeIndex the type index of the type
	 * @param startId the start id of the type
	 */
	private Type(int typeIndex, int startId) {
		this.typeIndex = typeIndex;
		this.startId = startId;
	}
	
	/**
	 * Gets the type according to the index of the type index.
	 *
	 * @param idx the type index
	 * @return the type
	 */
	public static Type getType(int idx) {
		return indexMap.get(idx);
	}
	
	/**
	 * Gets the type index of the type.
	 *
	 * @return the type index of the type.
	 */
	public int getTypeIndex() {
		return typeIndex;
	}
	
	/**
	 * Gets the start id of the type.
	 *
	 * @return the start id of the type.
	 */
	public int getStartId() {
		return startId;
	}
	
	/**
	 * Checks if tow type is same.
	 *
	 * @param type another type to compare with
	 * @return true, if is two type are the same
	 */
	public boolean isSameType(Type type) {
		if(this.getTypeIndex()==type.getTypeIndex())
			return true;
		return false;
	}
}
