package utils;

import java.util.ArrayList;

public class Checker {
	public static ArrayList<Meld> checkChow(ArrayList<Tile> wall, Tile another) {
		ArrayList<Meld> result = new ArrayList<>();
		if(another.getType()!=Type.BAMBOO && another.getType()!=Type.CHARACTER && another.getType()!=Type.DOT) {
			return result;
		}
		//check chow
		for(Tile a : wall) {
			if(a.getType() == another.getType() && a.getRankIndex() == another.getRankIndex()-1) {
				for(Tile b : wall){
					if(a.getType() == b.getType() && b.getRankIndex() == a.getRankIndex()-1) {
						result.add(new Meld(b, a, another, null));
						break;
					}
				}
				for (Tile b : wall) {
					if( a.getType() == b.getType() && b.getRankIndex() == another.getRankIndex()+1) {
						result.add(new Meld(a, another, b, null));
						break;
					}
				}
				break;
			}
		}
		for(Tile a : wall) {
			if(a.getType() == another.getType() && a.getRankIndex() == another.getRankIndex()+1) {
				for(Tile b : wall){
					if(a.getType() == b.getType() && b.getRankIndex() == a.getRankIndex()+1) {
						result.add(new Meld(another, a, b, null));
						break;
					}
				}
				break;
			}
		}
//		System.out.println(result.size());
//		System.out.println(result.get(0).getcomb_type());
//		System.out.println(result.get(0).getFirst().getChnName());
//		System.out.println(result.get(0).getSecond().getChnName());
//		System.out.println(result.get(0).getThird().getChnName());
//		System.out.println(result.get(0).getForth().getChnName());
		return result;
	}
		
		
	public static Meld checkPong(ArrayList<Tile> wall, Tile another) {	
		int insertPosition = 0;
		for(; insertPosition<wall.size(); insertPosition++) {
			if(wall.get(insertPosition).getId()>another.getId()){
				break;
			}
		}
		ArrayList<Tile> context = new ArrayList<>();
		for(int i=(0<=insertPosition-2?insertPosition-2:0);i<=insertPosition+1&&i<wall.size();i++) {
			if(i==insertPosition) {
				context.add(another);
			}
			context.add(wall.get(i));
		}
		if(insertPosition == wall.size()) {
			context.add(another);
		}
		
		//check pong
		for(int i=0; i+2<context.size();i++) {
			if(context.get(i).getType() == context.get(i+1).getType() && context.get(i).getType() == context.get(i+2).getType()) {
				if(context.get(i).getRankIndex() == context.get(i+1).getRankIndex() && context.get(i).getRankIndex() == context.get(i+2).getRankIndex()) {
					return new Meld(context.get(i),context.get(i+1),context.get(i+2),null);
				}
			}
		}
		return null;
	}
		
	public static Meld checkKong(ArrayList<Tile> wall, Tile another) {
		int insertPosition = 0;
		for(; insertPosition<wall.size(); insertPosition++) {
			if(wall.get(insertPosition).getId()>another.getId()){
				break;
			}
		}
		ArrayList<Tile> context = new ArrayList<>();
		for(int i=(0<=insertPosition-3?insertPosition-3:0);i<=insertPosition+2&&i<wall.size();i++) {
			if(i==insertPosition) {
				context.add(another);
			}
			context.add(wall.get(i));
		}
		if(insertPosition == wall.size()) {
			context.add(another);
		}
		
		//check kong
		for(int i=0; i+3<context.size();i++) {
			if(context.get(i).getType() == context.get(i+1).getType() && context.get(i).getType() == context.get(i+2).getType() && context.get(i).getType() == context.get(i+3).getType()) {
				if(context.get(i).getRankIndex() == context.get(i+1).getRankIndex() && context.get(i).getRankIndex() == context.get(i+2).getRankIndex() && context.get(i).getRankIndex() == context.get(i+3).getRankIndex()) {
					return new Meld(context.get(i),context.get(i+1),context.get(i+2),context.get(i+3));
				}
			}
		}
		return null;
	}
}
