package Suburbia;

public class TurnProcesssor {
	
	private Game m_game;
	
	public TurnProcesssor(Game game)
	{
		m_game = game;
	}
	
	public void ProcessTurn(Player player, Tile placedTile)
	{
		ProcessTileEffects(player, placedTile);
		ProcessAdjacentTiles(placedTile);
		ProcessNonAdjacentTiles(placedTile);
		UpdateOtherPlayers(placedTile);
	}
	
	public void ProcessTileEffects(Player player, Tile placedTile)
	{
		for(int i = 0; i < placedTile.m_Effects.size(); i++)
		{
			Effect effect = placedTile.m_Effects.get(i);
			switch (effect.m_EffectBy)
			{
			case SELF:
				//Apply Effect of tile
				break;
			case ADJACENT:
				for (int j = 0; j < Tile.Neighbors; j++)
				{
					if(placedTile.m_Neighbors[j] != null)
					{
						CheckTileInteraction(effect, placedTile, placedTile.m_Neighbors[j]);						
					}
				}
				break;
			case ALL:
				for (int pIndex = 0; pIndex < m_game.m_Players.size(); pIndex++)
				{
					for (int tIndex = 0; tIndex < m_game.m_Players.get(pIndex).m_Tiles.size(); tIndex++)
					{
						CheckTileInteraction(effect, placedTile, m_game.m_Players.get(pIndex).m_Tiles.get(tIndex));
					}
				}
				break;
			case YOURS:
				for (int tIndex = 0; tIndex < player.m_Tiles.size(); tIndex++)
				{
					CheckTileInteraction(effect, placedTile, player.m_Tiles.get(tIndex));
				}
				break;
			case OTHERS:
				for (int pIndex = 0; pIndex < m_game.m_Players.size(); pIndex++)
				{
					if(m_game.m_Players.get(pIndex) != player)
					{
						for (int tIndex = 0; tIndex < m_game.m_Players.get(pIndex).m_Tiles.size(); tIndex++)
						{
							CheckTileInteraction(effect, placedTile, m_game.m_Players.get(pIndex).m_Tiles.get(tIndex));
						}
					}
				}
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
	
	public void CheckTileInteraction(Effect effect, Tile placedTile, Tile otherTile)
	{

	}
}
