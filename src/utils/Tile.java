package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Tile {
	public final static int SUIT_SIZE = 4 * 9;
	public final static int DRAGON_SIZE = 4 * 3;
	public final static int WIND_SIZE = 4 * 4;
	public final static int FLOWER_SIZE = 1 * 8;
	public final static int FACEDOWN_SIZE = 1;
	public final static int SUIT_NUM = 3;
	public final static int TILE_WIDTH = 120;
	public final static int TILE_HEIGHT = 120;
	public final static int TILE_WIDTH_OTHERS = 90;
	public final static int TILE_HEIGHT_OTHERS = 90;
	
	private static Map<Integer, String> nameMap = new HashMap<Integer, String>();
	private final String filename = "resource/TileName.txt";
	private int id;
	private Type type;
	private int rankIndex;
	private String name;
	private String url;
	
	
	public Tile(int id) {
		this.id = id;
		this.type = idToType(id);
		this.rankIndex = idToRankIndex(id);
		nameMap = fileToMap(filename);
		this.name = idToName(id);
		this.setStringUrl();
	}
	
	public static Type idToType(int id) { //later need to add exception handling
		int typeIndex;
		if((typeIndex = id / SUIT_SIZE) < SUIT_NUM) {
			return Type.getType(typeIndex);
		}
		else if((id -= SUIT_NUM*SUIT_SIZE) < DRAGON_SIZE) {
			return Type.DRAGON;
		}
		else if((id -= DRAGON_SIZE) < WIND_SIZE) {
			return Type.WIND;
		}
		else if((id -= WIND_SIZE) < FLOWER_SIZE) {
			return Type.FLOWER;
		}
		else {
			return Type.FACEDOWN;
		}
	}
	
	public static int idToRankIndex(int id) {
		Type type = idToType(id);
		id -= type.getStartId();
		if(type == Type.FLOWER || type == Type.FACEDOWN) {
			return id;
		}
		else {
			return id / 4;
		}
	}
	
	public static String idToName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return nameMap.get(nameIndex);
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
	public int compareTo(Tile tile) {

		if(this.id<tile.id) {
			return -1;
			
		}
		if(this.id>tile.id) {
			return 1;
		}
		return 0;
	}
	
	public Map<Integer,String> fileToMap(String filename){
		String delimiter = ":";
		Map<Integer, String> map = new HashMap<>();
        try(Stream<String> lines = Files.lines(Paths.get(filename))){
            lines.filter(line -> line.contains(delimiter)).forEach(
                line -> map.putIfAbsent(Integer.valueOf(line.split(delimiter)[0]), line.split(delimiter)[1])
            );
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return map;
	}
	
	private void setStringUrl() {
		String temp = "resource/static/tiles/";
		String tileType = this.type.toString().toLowerCase();
		String tileIndex = String.valueOf(this.rankIndex + 1);
		this.url =  temp + tileType + "-" + tileIndex + ".png";
	}
	
	public String getUrl() {
		return url;
	}
}
