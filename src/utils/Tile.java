/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Tile.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Class Tile.
 */
public class Tile implements Comparable<Tile> {
	
	/** The Constant SUIT_SIZE. */
	public final static int SUIT_SIZE = 4 * 9;
	
	/** The Constant DRAGON_SIZE. */
	public final static int DRAGON_SIZE = 4 * 3;
	
	/** The Constant WIND_SIZE. */
	public final static int WIND_SIZE = 4 * 4;
	
	/** The Constant FLOWER_SIZE. */
	public final static int FLOWER_SIZE = 1 * 8;
	
	/** The Constant FACEDOWN_SIZE. */
	public final static int FACEDOWN_SIZE = 1;
	
	/** The Constant SUIT_NUM. */
	public final static int SUIT_NUM = 3;
	
	/** The Constant TILE_WIDTH_USER. */
	public final static int TILE_WIDTH_USER = 90;
	
	/** The Constant TILE_HEIGHT_USER. */
	public final static int TILE_HEIGHT_USER = 90;
	
	/** The Constant TILE_WIDTH_AI. */
	public final static int TILE_WIDTH_AI = 70;
	
	/** The Constant TILE_HEIGHT_AI. */
	public final static int TILE_HEIGHT_AI = 70;
	
	/** The Constant TILE_WIDTH_MELD. */
	public final static int TILE_WIDTH_MELD = 70;
	
	/** The Constant TILE_HEIGHT_MELD. */
	public final static int TILE_HEIGHT_MELD = 70;
	
	/** The Constant TILE_WIDTH_BOARD. */
	public final static int TILE_WIDTH_BOARD = 60;
	
	/** The Constant TILE_HEIGHT_BOARD. */
	public final static int TILE_HEIGHT_BOARD = 60;
	
	/** The Constant TOTAL_TILES. */
	public final static int TOTAL_TILES = 144;
	
	/** The Constant TOTAL_TILES_WITHOUT_FLOWERS. */
	public final static int TOTAL_TILES_WITHOUT_FLOWERS = 136;
	
	/** The eng name map. */
	private static Map<Integer, String> engNameMap = new HashMap<Integer, String>();
	
	/** The chn name map. */
	private static Map<Integer, String> chnNameMap = new HashMap<Integer, String>();
	
	/** The eng filename. */
	private final String engFilename = "resource/TileName.txt";
	
	/** The chn filename. */
	private final String chnFilename = "resource/TileName_CHN.txt";
	
	/** The id. */
	private int id;
	
	/** The type. */
	private Type type;
	
	/** The rank index. */
	private int rankIndex;
	
	/** The name. */
	private String name;
	
	/** The chn name. */
	private String chnName;
	
	/** The url. */
	private String url;
	
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param id the id
	 */
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
	
	/**
	 * Id to type.
	 *
	 * @param id the id
	 * @return the type
	 */
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
	
	/**
	 * Id to rank index.
	 *
	 * @param id the id
	 * @return the int
	 */
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
	
	/**
	 * Id to name.
	 *
	 * @param id the id
	 * @return the string
	 */
	public static String idToName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return engNameMap.get(nameIndex);
	}
	
	/**
	 * Id to chn name.
	 *
	 * @param id the id
	 * @return the string
	 */
	public static String idToChnName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return chnNameMap.get(nameIndex);
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Gets the rank index.
	 *
	 * @return the rank index
	 */
	public int getRankIndex() {
		return rankIndex;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the chn name.
	 *
	 * @return the chn name
	 */
	public String getChnName() {
		return chnName;
	}
	
	/**
	 * Compare to.
	 *
	 * @param tile the tile
	 * @return the int
	 */
	@Override
	public int compareTo(Tile tile) {

		if(this.id<tile.id) {
			return -1;
			
		}
		if(this.id>tile.id) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * File to map.
	 *
	 * @param filename the filename
	 * @return the map
	 */
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
	
	/**
	 * Sets the string url.
	 */
	private void setStringUrl() {
		String temp = "resource/static/tiles/";
		String tileType = this.type.toString().toLowerCase();
		String tileIndex = String.valueOf(this.rankIndex + 1);
		this.url =  temp + tileType + "-" + tileIndex + ".png";
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Id to tile list.
	 *
	 * @param idList the id list
	 * @return the array list
	 */
	public static ArrayList<Tile> idToTileList(ArrayList<Integer> idList) {
		ArrayList<Tile> result = new ArrayList<>();
		for(int id : idList) {
			result.add(new Tile(id));
		}
		return result;
	}
	
	/**
	 * Tile to id list.
	 *
	 * @param tileList the tile list
	 * @return the array list
	 */
	public static ArrayList<Integer> tileToIdList(ArrayList<Tile> tileList){
		ArrayList<Integer> result = new ArrayList<>();
		for(Tile tile : tileList) {
			result.add(tile.getId());
		}
		return result;
	}
	
	/**
	 * Tile list to string.
	 *
	 * @param tileList the tile list
	 * @return the string
	 */
	public static String tileListToString (ArrayList<Tile> tileList) {
		String s = "";
		for(Tile t: tileList) {
			s = s+(t.getChnName()+" /");
		}
		return s;
	}
	
	/**
	 * Checks if is same tile face.
	 *
	 * @param tile1 the tile 1
	 * @param tile2 the tile 2
	 * @return true, if is same tile face
	 */
	public static boolean isSameTileFace(Tile tile1, Tile tile2) {
		if(tile1.getType() == tile2.getType()) {
			if(tile1.getRankIndex() == tile2.getRankIndex())
				return true;
		}
		return false;
	}
	
	/**
	 * Sort tile list.
	 *
	 * @param tiles the tiles
	 * @return the array list
	 */
	public static ArrayList<Tile> sortTileList(ArrayList<Tile> tiles) {
		ArrayList<Tile> sortedTiles = null;
		Collections.sort(tiles);
		sortedTiles = tiles;
		return sortedTiles;
	}
	
}

