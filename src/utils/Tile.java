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

/**
 * The Class Tile.
 * The Tile class which represent a Tile in the game and contains the basic information and function needed for a Tile。
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
	
	/** The Hash map between English name and id. */
	private static Map<Integer, String> engNameMap = new HashMap<Integer, String>();
	
	/** The Hash map between Chinese name and id. */
	private static Map<Integer, String> chnNameMap = new HashMap<Integer, String>();
	
	/** The file path of the English name file. */
	private final String engFilename = "resource/TileName.txt";
	
	/** The file path of the Chinese name file. */
	private final String chnFilename = "resource/TileName_CHN.txt";
	
	/** The id. */
	private int id;
	
	/** The type. */
	private Type type;
	
	/** The rank index for the Tile with the same Type. */
	private int rankIndex;
	
	/** The English name. */
	private String name;
	
	/** The Chinese name. */
	private String chnName;
	
	/** The url to the Tile picture. */
	private String url;
	
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param id the id of the Tile
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
	 * Deduce the type of a Tile from its id。
	 *
	 * @param id the id of the Tile
	 * @return the type of the Tile
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
	 * Deduce the rank index of a Tile from its id。
	 *
	 * @param id the id of the Tile
	 * @return the rank index of the Tile
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
	 * Get the English of a Tile according to its id.
	 *
	 * @param id the id of the Tile
	 * @return the string of the English name of the Tile
	 */
	public static String idToName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return engNameMap.get(nameIndex);
	}
	
	/**
	 * Get the Chinese of a Tile according to its id.
	 *
	 * @param id the id of the Tile
	 * @return the string of the Chinese name of the Tile
	 */
	public static String idToChnName(int id) {
		Type type = idToType(id);
		int rankIndex = idToRankIndex(id);
		int nameIndex = type.getTypeIndex()*10+rankIndex;
		return chnNameMap.get(nameIndex);
	}
	
	/**
	 * Gets the id of the Tile
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the type of the Tile
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Gets the rank index of the Tile
	 *
	 * @return the rank index
	 */
	public int getRankIndex() {
		return rankIndex;
	}
	
	/**
	 * Gets the English name of the Tile.
	 *
	 * @return the English name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the Chinese name of the Tile.
	 *
	 * @return the Chinese name
	 */
	public String getChnName() {
		return chnName;
	}
	
	/**
	 * Comparison between two Tile
	 *
	 * @param tile another Tile to compare with
	 * @return a integer represent the relative size of the Tile
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
	 * read the name resource file and store it in accordance hash map.
	 *
	 * @param filename the path to the name resource file
	 * @return the accordance hash map
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
	 * Set the url to the picture of the Tile.
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
	 * @return the a string of url
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
	 * Transfer an integer id list to a Tile list.
	 *
	 * @param idList the id list
	 * @return the Tile list
	 */
	public static ArrayList<Tile> idToTileList(ArrayList<Integer> idList) {
		ArrayList<Tile> result = new ArrayList<>();
		for(int id : idList) {
			result.add(new Tile(id));
		}
		return result;
	}
	
	/**
	 * Transfer a Tile list to an integer id list.
	 *
	 * @param tileList the tile list
	 * @return the integer id list
	 */
	public static ArrayList<Integer> tileToIdList(ArrayList<Tile> tileList){
		ArrayList<Integer> result = new ArrayList<>();
		for(Tile tile : tileList) {
			result.add(tile.getId());
		}
		return result;
	}
	
	/**
	 * Get a formated string of Chinese names from a Tile list.
	 *
	 * @param tileList the tile list
	 * @return the Chinese name string
	 */
	public static String tileListToString (ArrayList<Tile> tileList) {
		String s = "";
		for(Tile t: tileList) {
			s = s+(t.getChnName()+" /");
		}
		return s;
	}
	
	/**
	 * Checks if two Tile have same tile face.
	 *
	 * @param tile1 the tile 1
	 * @param tile2 the tile 2
	 * @return true, if two tile has same tile face
	 */
	public static boolean isSameTileFace(Tile tile1, Tile tile2) {
		if(tile1.getType() == tile2.getType()) {
			if(tile1.getRankIndex() == tile2.getRankIndex())
				return true;
		}
		return false;
	}

}

