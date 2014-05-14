package de.mm.spaceinvaders.protocol.packets;

import io.netty.buffer.ByteBuf;
import de.mm.spaceinvaders.io.PacketHandler;
import de.mm.spaceinvaders.protocol.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Respawn extends Packet
{
	private float x, y;
	private double rotation;

	@Override
	public void read(ByteBuf buf)
	{
		this.x = buf.readFloat();
		this.y = buf.readFloat();
		this.rotation = buf.readDouble();
	}

	@Override
	public void write(ByteBuf buf)
	{
		buf.writeFloat(x);
		buf.writeFloat(x);
		buf.writeDouble(rotation);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}
}
