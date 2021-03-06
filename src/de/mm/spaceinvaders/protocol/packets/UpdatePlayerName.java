package de.mm.spaceinvaders.protocol.packets;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import de.mm.spaceinvaders.io.PacketHandler;
import de.mm.spaceinvaders.protocol.Packet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdatePlayerName extends Packet
{

	private String uuid;
	private String newName;

	@Override
	public void read(ByteBuf buf)
	{
		this.uuid = readString(buf);
		this.newName = readString(buf);
	}

	@Override
	public void write(ByteBuf buf)
	{
		writeString(buf, uuid);
		writeString(buf, newName);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}
}
