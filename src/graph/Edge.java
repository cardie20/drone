package graph;

import java.util.Map;



public class Edge {
	
	
	private String dstUrb;
	private int weight;
	private Direction direction;
	
	
	public String getDstUrb() {
		return dstUrb;
	}
	public void setDstUrb(String dstUrb) {
		this.dstUrb = dstUrb;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Edge(String dstUrb, int weight, Direction direction) {
		
		this.dstUrb = dstUrb;
		this.weight = weight;
		this.direction = direction;
	}
	
	public String toString(){
		return "Id dst " +  dstUrb + " weigth " + weight + " direction "+ direction;
	}
	
	
	
}
