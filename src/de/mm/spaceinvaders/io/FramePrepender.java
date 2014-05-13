package de.mm.spaceinvaders.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class FramePrepender extends MessageToByteEncoder<ByteBuf>
{

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out)
			throws Exception
	{
		out.writeInt(in.readableBytes());
		out.writeBytes(in);
	}
}