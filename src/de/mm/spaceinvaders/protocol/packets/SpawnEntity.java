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
public class SpawnEntity extends Packet
{

	private String uuid;
	private double x, y;
	private double rotation;
	private byte type;

	@Override
	public void read(ByteBuf buf)
	{
		this.uuid = readString(buf);
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.rotation = buf.readDouble();
		this.type = buf.readByte();
	}

	@Override
	public void write(ByteBuf buf)
	{
		writeString(buf, uuid);
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(rotation);
		buf.writeByte(type);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}
}
