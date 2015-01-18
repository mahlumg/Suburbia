package Suburbia;

import java.util.*;

public class Tile {

	int m_Owner;
	int m_TileID;
	int m_Cost;
	boolean m_Lake;
	TileType m_TileType;
	TileSubType m_TileSubType;
	Vector<Effect> m_Effects;
	Tile m_Neighbors[];
	
	public Tile(int ID)
	{
		m_TileID = ID;
		m_Owner = 0;
	}
}
