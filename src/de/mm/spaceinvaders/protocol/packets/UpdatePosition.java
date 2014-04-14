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
public class UpdatePosition extends Packet
{
	private String uuid;
	private float x, y;
	private double rotation;

	@Override
	public void read(ByteBuf buf)
	{
		this.uuid = readString(buf);
		this.x = buf.readFloat();
		this.y = buf.readFloat();
		this.rotation = buf.readDouble();
	}

	@Override
	public void write(ByteBuf buf)
	{
		writeString(buf, uuid);
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
