package de.mm.spaceinvaders.protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.mm.spaceinvaders.protocol.packets.ChangeName;
import de.mm.spaceinvaders.protocol.packets.ChatMessage;
import de.mm.spaceinvaders.protocol.packets.GameStart;
import de.mm.spaceinvaders.protocol.packets.JoinGame;
import de.mm.spaceinvaders.protocol.packets.Login;
import de.mm.spaceinvaders.protocol.packets.ResetGame;
import de.mm.spaceinvaders.protocol.packets.Respawn;
import de.mm.spaceinvaders.protocol.packets.UpdatePlayerName;
import de.mm.spaceinvaders.protocol.packets.UpdatePosition;
import de.mm.spaceinvaders.protocol.packets.UserJoin;
import de.mm.spaceinvaders.protocol.packets.UserLeave;

public class Protocol
{

	public static int PROTOCOL_VERSION = 1;

	public static Protocol prot;

	private Map<Integer, Class<? extends Packet>> packets = new HashMap<>();

	public Protocol()
	{
		prot = this;

		packets.put(0, ChatMessage.class);
		packets.put(1, Login.class);
		packets.put(2, ChangeName.class);
		packets.put(3, UserJoin.class);
		packets.put(4, UserLeave.class);
		packets.put(5, UpdatePosition.class);
		packets.put(6, GameStart.class);
		packets.put(7, UpdatePlayerName.class);
		packets.put(8, ResetGame.class);
		packets.put(9, JoinGame.class);
		packets.put(10, Respawn.class);
	}

	public Packet createPacket(int id)
	{
		try
		{
			return packets.get(id).newInstance();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public int getPacketId(Class<? extends Packet> c)
	{
		for (Entry<Integer, Class<? extends Packet>> e : packets.entrySet())
		{
			if (e.getValue().equals(c)) return e.getKey();
		}
		return 0;
	}

}
