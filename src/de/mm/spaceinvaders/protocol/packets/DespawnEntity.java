package de.mm.spaceinvaders.protocol.packets;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import de.mm.spaceinvaders.io.PacketHandler;
import de.mm.spaceinvaders.protocol.Packet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DespawnEntity extends Packet
{
	private String uuid;

	@Override
	public void read(ByteBuf buf)
	{
		this.uuid = readString(buf);
	}

	@Override
	public void write(ByteBuf buf)
	{
		writeString(buf, uuid);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}
}
