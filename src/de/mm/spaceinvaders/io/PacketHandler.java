package de.mm.spaceinvaders.io;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import de.mm.spaceinvaders.protocol.Packet;

public abstract class PacketHandler extends AbstractPacketHandler
{

	@NonNull
	@Getter
	@Setter
	private ConnectionHandler connection;

	public void handle(Packet packet) throws Exception
	{
	}

	public void connected() throws Exception
	{
	}

	public void disconnected() throws Exception
	{
	}
}
