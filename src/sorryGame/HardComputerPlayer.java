package sorryGame;

import java.util.Map;

public class HardComputerPlayer extends ComputerPlayer {

	public HardComputerPlayer(GameBoard board, String color) {
		super(board, color);
	}

	@Override
	public void move(int card) {
		Map<String, Pawn[]> pawnMap = board.getPawns();
		for (Map.Entry<String, Pawn[]> pawns : pawnMap.entrySet()){
			if(!pawns.getKey().equalsIgnoreCase(getColor())){
				for(Pawn pawn : pawns.getValue()){
					switch(card){
						case 0:
							playerPawns = pawnMap.get(color);
							destination = pawn.startIndex;
							for(Pawn p : playerPawns){
								if(p.getLocation() == p.startSquare.getLocation()){
									if((destination - pawn.getLocation() +60)%60 < (destination - p.getLocation() + 60)%60){
										board.makeMove(card, p.getID(), p.getLocation(), destination);
									}
								}
							}
							break;
						case 11:
							playerPawns = pawnMap.get(color);
							destination = pawn.startIndex;
							for(Pawn p : playerPawns){
								if((destination - pawn.getLocation() +60)%60 < (destination - p.getLocation() + 60)%60){
									board.makeMove(card, p.getID(), p.getLocation(), destination);
								}
							}
							break;
						default:
							// if a move does not result in a bump ]
							System.out.println(pawn.getLocation());
							if (pawn.getLocation() == -1 && (card == 1 || card == 2) && !board.getGameArray()[pawn.startIndex].isOccupied()) {
								board.makeMove(card, pawn.getID(), pawn.getLocation(), pawn.startIndex);
								return;
							}
							else if (pawn.getLocation() >= 0 && pawn.getLocation() <= 59) {
								if (board.willBumpPiece(card, pawn.getLocation())) {
									if (board.validateMove(card, pawn.getID(), pawn.getLocation(),
														   ((pawn.getLocation() + card) % 60), 0, 0)) {
										//make rthe first move that results in a bump
										board.makeMove(card, pawn.getID(), pawn.getLocation(),
													   ((pawn.getLocation() + card) % 60));
										return;
									}
								}
								else {
									System.out.println("should move " + pawn.getID() + " from " + pawn.getLocation() +  " to " + ((pawn.getLocation() + card) % 60));
									board.makeMove(card, pawn.getID(), pawn.getLocation(), ((pawn.getLocation() + card) % 60));
									return;
								}
							}						
							break;					
					}
				}
			}
		}
	}

}
