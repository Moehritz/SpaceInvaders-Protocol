package de.mm.spaceinvaders.io;

import de.mm.spaceinvaders.protocol.Packet;
import de.mm.spaceinvaders.protocol.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToByteEncoder;

@Sharable
public class SpaceEncoder extends MessageToByteEncoder<Packet>
{

	@Override
	protected void encode(ChannelHandlerContext ctx, Packet p, ByteBuf out)
			throws Exception
	{
		out.writeInt(Protocol.prot.getPacketId(p.getClass()));
		p.write(out);
		

		System.out.println("OUT - " + p.getClass().getName());
	}

}
