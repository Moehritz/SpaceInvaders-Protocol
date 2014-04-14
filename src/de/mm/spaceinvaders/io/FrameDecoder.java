package de.mm.spaceinvaders.io;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class FrameDecoder extends ByteToMessageDecoder
{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
			throws Exception
	{
		while (in.readableBytes() > 8)
		{
			in.markReaderIndex();
			if (!in.isReadable())
			{
				in.resetReaderIndex();
				return;
			}
			int l = in.readInt();
			if (in.readableBytes() < l)
			{
				in.resetReaderIndex();
				return;
			}
			out.add(in.readBytes(l));
		}
	}
}