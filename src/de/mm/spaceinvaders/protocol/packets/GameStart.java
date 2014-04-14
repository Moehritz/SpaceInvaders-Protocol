package de.mm.spaceinvaders.protocol.packets;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import de.mm.spaceinvaders.io.PacketHandler;
import de.mm.spaceinvaders.protocol.Packet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GameStart extends Packet
{
	
	@Override
	public void read(ByteBuf buf)
	{
		
	}
	
	@Override
	public void write(ByteBuf buf)
	{
		
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}
}
