package Suburbia;

import java.util.*;


public class Tile {

	public static int Neighbors = 6;
	public static int NeighborSouth = 0;
	public static int NeighborSouthWest = 1;
	public static int NeighborNorthWest = 2;
	public static int NeighborNorth = 3;
	public static int NeighborNorthEast = 4;
	public static int NeighborSouthEast = 5;
	

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
		m_Neighbors = new Tile[Neighbors];
	}
}
