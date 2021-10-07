package utils;

import java.util.HashMap;
import java.util.Map;

public class Tile {
	public final static int SUIT_SIZE = 4 * 9;
	public final static int DRAGON_SIZE = 4 * 3;
	public final static int WIND_SIZE = 4 * 4;
	public final static int FLOWER_SIZE = 1 * 8;
	public final static int SUIT_NUM = 3;
	
	private int id;
	private Type type;
	private int rankIndex;
	private String name;
	
	public Tile(int id) {
		this.id = id;
		this.type = idToType(id);
		this.rankIndex = idToRankIndex(id);
		this.name = idToName(id);
	}
	
	public static Type idToType(int id) { //later need to add exception handling
		int typeIndex;
		if((typeIndex = id % SUIT_SIZE) < SUIT_NUM) {
			return Type.getType(typeIndex);
		}
		else if((id -= SUIT_NUM*SUIT_SIZE) < DRAGON_SIZE) {
			return Type.DRAGON;
		}
		else if((id -= DRAGON_SIZE) < WIND_SIZE) {
			return Type.WIND;
		}
		else {
			return Type.FLOWER;
		}
	}
	
	public static int idToRankIndex(int id) {
		Type type = idToType(id);
		id -= type.getStartId();
		if(type == Type.FLOWER) {
			return id;
		}
		else {
			return id / 4;
		}
	}
	
	public static String idToName(int id) {
		return "Dot One"; //need to implement this method later
	}
	
	public int getId() {
		return id;
	}

	public Type getType() {
		return type;
	}
	
	public int getRankIndex() {
		return rankIndex;
	}
	
	public String getName() {
		return name;
	}
	
	
}
