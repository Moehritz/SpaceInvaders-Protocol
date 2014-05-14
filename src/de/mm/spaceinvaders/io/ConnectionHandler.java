package de.mm.spaceinvaders.io;

import de.mm.spaceinvaders.protocol.Packet;
import de.mm.spaceinvaders.protocol.PacketWrapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ConnectionHandler extends ChannelHandlerAdapter
{

	private final Channel ch;
	private final PacketHandler handler;

	public ConnectionHandler(Channel ch, PacketHandler handler)
	{
		this.ch = ch;
		this.handler = handler;
		handler.setConnection(this);
	}

	public void closeConnection()
	{
		if (ch == null || !ch.isOpen())
		{
			return;
		}
		ch.close();
	}

	public void sendPackets(Packet... packets)
	{
		for (final Packet p : packets)
		{
			ch.write(p);
		}
		ch.flush();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		handler.connected();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		handler.disconnected();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		PacketWrapper p = (PacketWrapper) msg;
		try
		{
			p.getPacket().handle(handler);
		}
		finally
		{
			p.release();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception
	{
		cause.printStackTrace();
		handler.disconnected();
	}
}
