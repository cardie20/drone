package graph;

public enum Direction {
	RIGTH ,
	LEFT ,
	UP ,
	DOWN ;
	 	
	
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
