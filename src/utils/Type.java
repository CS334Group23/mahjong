package utils;

import java.util.HashMap;
import java.util.Map;

public enum Type{
	BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72), DRAGON(3, 108), FLOWER(5, 136), WIND(4, 120);
	
	private final int typeIndex;
	private final int startId;
	private static Map<Integer, Type> indexMap = new HashMap<Integer, Type>();
	static {
		for (Type t : Type.values()) {
			indexMap.put(t.typeIndex, t);
		}
	}
	private Type(int typeIndex, int startId) {
		this.typeIndex = typeIndex;
		this.startId = startId;
	}
	
	public static Type getType(int idx) {
		return indexMap.get(idx);
	}
	
	public int getTypeIndex() {
		return typeIndex;
	}
	
	public int getStartId() {
		return startId;
	}
	
	
}