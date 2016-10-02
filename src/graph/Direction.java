package graph;

public enum Direction {
	RIGTH (0),
	LEFT (1),
	UP (2),
	DOWN (3);
	 	
	public int value;
	Direction(final int value){
		this.value = value;
	}
	
	public Direction reverse (Direction direction){
		if (direction.equals(RIGTH)){
			return Direction.LEFT;
		}else if(direction.equals(LEFT)){
			return Direction.RIGTH;
		}else if(direction.equals(UP)){
			return direction.DOWN;
		}else{
			return direction.UP;
		}
	}

}
