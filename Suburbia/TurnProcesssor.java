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
		ProcessAdjacentTiles(player, placedTile);
		ProcessNonAdjacentTiles(player, placedTile);
		UpdateOtherPlayers(player, placedTile);
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
				//Go though the adjacent tiles to the placed tile
				for (int j = 0; j < Tile.Neighbors; j++)
				{
					if(placedTile.m_Neighbors[j] != null)
					{
						ApplyTileInteraction(player, effect, placedTile, placedTile.m_Neighbors[j]);						
					}
				}
				break;
			case ALL:
				//Go through each player's tiles
				for (int pIndex = 0; pIndex < m_game.m_Players.size(); pIndex++)
				{
					for (int tIndex = 0; tIndex < m_game.m_Players.get(pIndex).m_Tiles.size(); tIndex++)
					{
						ApplyTileInteraction(player, effect, placedTile, m_game.m_Players.get(pIndex).m_Tiles.get(tIndex));
					}
				}
				break;
			case YOURS:
				//Only go though the current player's tiles
				for (int tIndex = 0; tIndex < player.m_Tiles.size(); tIndex++)
				{
					ApplyTileInteraction(player, effect, placedTile, player.m_Tiles.get(tIndex));
				}
				break;
			case OTHERS:
				//Go though all other player's tiles, but not the current player's
				for (int pIndex = 0; pIndex < m_game.m_Players.size(); pIndex++)
				{
					if(m_game.m_Players.get(pIndex) != player)
					{
						for (int tIndex = 0; tIndex < m_game.m_Players.get(pIndex).m_Tiles.size(); tIndex++)
						{
							ApplyTileInteraction(player, effect, placedTile, m_game.m_Players.get(pIndex).m_Tiles.get(tIndex));
						}
					}
				}
				break;
			case AFTER:
				//Could merge this with all but only have the effect apply if the other tile has the effect
				break;
			case SPECIAL:
				
				break;
			}
		}
	}
	
	public void ProcessAdjacentTiles(Player player, Tile placedTile)
	{
		for(int i = 0; i < Tile.Neighbors; i++)
		{
			if(placedTile.m_Neighbors[i] != null)
			{
				for(int j = 0; j < placedTile.m_Neighbors[i].m_Effects.size(); j++)
				{
					if(placedTile.m_Neighbors[j].m_Effects.get(j).m_EffectBy == EffectBy.ADJACENT)
					{
						ApplyTileInteraction(player, placedTile.m_Neighbors[i].m_Effects.get(j), placedTile, placedTile);
					}
				}
			}
		}
	}

	public void ProcessNonAdjacentTiles(Player player, Tile placedTile)
	{
		for(int i = 0; i < player.m_Tiles.size(); i++)
		{
			for(int j = 0; j < player.m_Tiles.get(i).m_Effects.size(); j++)
			{
				if(player.m_Tiles.get(i).m_Effects.get(j).m_EffectBy == EffectBy.ALL || player.m_Tiles.get(i).m_Effects.get(j).m_EffectBy == EffectBy.YOURS)
				{
					ApplyTileInteraction(player, player.m_Tiles.get(i).m_Effects.get(j), player.m_Tiles.get(i), placedTile);
				}
			}
		}
	}
	
	public void UpdateOtherPlayers(Player player, Tile placedTile)
	{
		for(int k = 0; k < m_game.m_Players.size(); k++)
		{
			if(m_game.m_Players.get(k) != player)
			{
				for(int i = 0; i < m_game.m_Players.get(k).m_Tiles.size(); i++)
				{
					for(int j = 0; j < m_game.m_Players.get(k).m_Tiles.get(i).m_Effects.size(); j++)
					{
						if(m_game.m_Players.get(k).m_Tiles.get(i).m_Effects.get(j).m_EffectBy == EffectBy.ALL || m_game.m_Players.get(k).m_Tiles.get(i).m_Effects.get(j).m_EffectBy == EffectBy.OTHERS)
						{
							ApplyTileInteraction(player, player.m_Tiles.get(i).m_Effects.get(j), player.m_Tiles.get(i), placedTile);
						}
					}
				}
			}
		}
	}
	
	public void ApplyTileInteraction(Player player, Effect effect, Tile triggeredTile, Tile triggeringTile)
	{
		//Assume the effect's m_EffectBy field is correct for the given tiles
		//What we want to check here is the effect TileType or TileSubType
		boolean Apply = false;
		if(effect.m_SubType)
		{
			if(triggeringTile.m_TileSubType == effect.m_TileSubType)
			{
				Apply = true;
			}
		}
		else
		{
			if(triggeringTile.m_TileType == effect.m_TileType)
			{
				Apply = true;
			}
		}
		
		if(Apply)
		{
			switch(effect.m_EffectType)
			{
			case INCOME:
				player.m_Income += effect.m_Amount;
				break;
			case REPUTATION:
				player.m_Reputation += effect.m_Amount;
				break;
			case MONEY:
				player.m_Money += effect.m_Amount;
				break;
			case POPULATION:
				player.m_Population += effect.m_Amount;
				break;
			default:
				break;
			}
		}
	}
}
