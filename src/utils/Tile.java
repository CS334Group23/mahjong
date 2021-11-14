package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import gui.TileLabel;

public class Tile {
	public final static int SUIT_SIZE = 4 * 9;
	public final static int DRAGON_SIZE = 4 * 3;
	public final static int WIND_SIZE = 4 * 4;
	public final static int FLOWER_SIZE = 1 * 8;
	public final static int FACEDOWN_SIZE = 1;
	public final static int SUIT_NUM = 3;
	public final static int TILE_WIDTH_USER = 90;
	public final static int TILE_HEIGHT_USER = 90;
	public final static int TILE_WIDTH_AI = 70;
	public final static int TILE_HEIGHT_AI = 70;
	public final static int TILE_WIDTH_MELD = 70;
	public final static int TILE_HEIGHT_MELD = 70;
	public final static int TILE_WIDTH_BOARD = 60;
	public final static int TILE_HEIGHT_BOARD = 60;
	
	private static Map<Integer, String> engNameMap = new HashMap<Integer, String>();
	private static Map<Integer, String> chnNameMap = new HashMap<Integer, String>();
	private final String engFilename = "resource/TileName.txt";
	private final String chnFilename = "resource/TileName_CHN.txt";
	private int id;
	private Type type;
	private int rankIndex;
	private String name;
	private String chnName;
	private String url;
	
	
	public Tile(int id) {
		this.id = id;
		this.type = idToType(id);
		this.rankIndex = idToRankIndex(id);
		engNameMap = fileToMap(engFilename);
		chnNameMap = fileToMap(chnFilename);
		this.name = idToName(id);
		this.chnName = idToChnName(id);
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
		return engNameMap.get(nameIndex);
	}
	
	public static String idToChnName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return chnNameMap.get(nameIndex);
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
	
	public String getChnName() {
		return chnName;
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
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static ArrayList<Tile> idToTileList(ArrayList<Integer> idList) {
		ArrayList<Tile> result = new ArrayList<>();
		for(int id : idList) {
			result.add(new Tile(id));
		}
		return result;
	}
	
	public static ArrayList<Integer> tileToIdList(ArrayList<Tile> tileList){
		ArrayList<Integer> result = new ArrayList<>();
		for(Tile tile : tileList) {
			result.add(tile.getId());
		}
		return result;
	}
	
	public static String tileListToString (ArrayList<Tile> tileList) {
		String s = "";
		for(Tile t: tileList) {
			s = s+(t.getChnName()+" /");
		}
		return s;
	}
	
	public static boolean isSameType(Tile tile1, Tile tile2) {
		if(tile1.getType() == tile2.getType()) {
			if(tile1.getRankIndex() == tile2.getRankIndex())
				return true;
		}
		return false;
	}
	
	public static ArrayList<Tile> sortTileList(ArrayList<Tile> tiles) {
		ArrayList<Tile> sortedTiles = null;
		tiles.sort(new tileComparator());
		
		sortedTiles = tiles;
		return sortedTiles;
	}
	
	public static ArrayList<TileLabel> sortTileLabelList(ArrayList<TileLabel> tileLabels) {
		ArrayList<TileLabel> sortedTileLabels = null;
		tileLabels.sort(new tileLabelComparator());
		
		sortedTileLabels = tileLabels;
		return sortedTileLabels;
	}
}

class tileComparator implements Comparator<Tile>{

	@Override
	public int compare(Tile o1, Tile o2) {
		int o1Id = o1.getId();
		int o2Id = o2.getId();
		
		if(o1Id == o2Id) return 0;
		
		return o1Id < o2Id ? -1 : 1;
	}
	
}

class tileLabelComparator implements Comparator<TileLabel>{

	@Override
	public int compare(TileLabel o1, TileLabel o2) {
		Tile tile1 = o1.getTile();
		Tile tile2 = o2.getTile();
		int o1Id = tile1.getId();
		int o2Id = tile2.getId();
		
		if(o1Id == o2Id) return 0;
		
		return o1Id < o2Id ? -1 : 1;
	}
	
}
