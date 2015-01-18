package Suburbia;

public class TurnProcesssor {
	
	private Game m_game;
	
	public TurnProcesssor(Game game)
	{
		m_game = game;
	}
	
	public void ProcessTurn(Player player, Tile placedTile)
	{
		ProcessTileEffects(placedTile);
		ProcessAdjacentTiles(placedTile);
		ProcessNonAdjacentTiles(placedTile);
		UpdateOtherPlayers(placedTile);
	}
	
	public void ProcessTileEffects(Tile placedTile)
	{
		for(int i = 0; i < placedTile.m_Effects.size(); i++)
		{
			switch (placedTile.m_Effects.get(i).m_EffectBy)
			{
			case SELF:
				//Apply Effect of tile
				break;
			case ADJACENT:
				for (int j = 0; j < Tile.Neighbors; j++)
				{
					if(placedTile.m_Neighbors[j] != null)
					{
						
					}
				}
				break;
			case ALL:
				break;
			case YOURS:
				break;
			case OTHERS:
				break;
			case AFTER:
				break;
			case SPECIAL:
				break;
			}
		}
	}
	
	public void ProcessAdjacentTiles(Tile placedTile)
	{
		
	}

	public void ProcessNonAdjacentTiles(Tile placedTile)
	{
		
	}
	
	public void UpdateOtherPlayers(Tile placedTile)
	{
		
	}
}
