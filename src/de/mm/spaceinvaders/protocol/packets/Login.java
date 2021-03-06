package de.mm.spaceinvaders.protocol.packets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import io.netty.buffer.ByteBuf;
import de.mm.spaceinvaders.io.PacketHandler;
import de.mm.spaceinvaders.protocol.Packet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Login extends Packet
{

	private String name, uuid;
	private int version;

	@Override
	public void read(ByteBuf buf)
	{
		this.name = readString(buf);
		this.uuid = readString(buf);
		this.version = buf.readInt();
	}

	@Override
	public void write(ByteBuf buf)
	{
		writeString(buf, name);
		writeString(buf, uuid);
		buf.writeInt(version);
	}

	@Override
	public void handle(PacketHandler handler) throws Exception
	{
		handler.handle(this);
	}

}
