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
public class ShootProjectile extends Packet
{

	private double x, y;
	private double rotation;

	@Override
	public void read(ByteBuf buf)
	{
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.rotation = buf.readDouble();
	}

	@Override
	public void write(ByteBuf buf)
	{
		buf.writeDouble(x);
		buf.writeDouble(x);
		buf.writeDouble(rotation);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}

}
