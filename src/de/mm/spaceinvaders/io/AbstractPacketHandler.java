package de.mm.spaceinvaders.io;

import de.mm.spaceinvaders.protocol.packets.ChangeName;
import de.mm.spaceinvaders.protocol.packets.ChatMessage;
import de.mm.spaceinvaders.protocol.packets.GameStart;
import de.mm.spaceinvaders.protocol.packets.JoinGame;
import de.mm.spaceinvaders.protocol.packets.Login;
import de.mm.spaceinvaders.protocol.packets.ResetGame;
import de.mm.spaceinvaders.protocol.packets.UpdatePlayerName;
import de.mm.spaceinvaders.protocol.packets.UpdatePosition;
import de.mm.spaceinvaders.protocol.packets.UserJoin;
import de.mm.spaceinvaders.protocol.packets.UserLeave;

public abstract class AbstractPacketHandler
{

	public void handle(Login login) throws Exception
	{
	}

	public void handle(ChatMessage chatMessage) throws Exception
	{
	}

	public void handle(ChangeName changeName) throws Exception
	{
	}

	public void handle(UserJoin join) throws Exception
	{
	}

	public void handle(UserLeave leave) throws Exception
	{
	}

	public void handle(UpdatePosition pos) throws Exception
	{
	}

	public void handle(GameStart start) throws Exception
	{
	}

	public void handle(UpdatePlayerName update) throws Exception
	{
	}

	public void handle(ResetGame reset) throws Exception
	{
	}

	public void handle(JoinGame game) throws Exception
	{
	}

}
