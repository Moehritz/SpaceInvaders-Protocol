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
	
	public ConnectionHandler(Channel ch, PacketHandler handler) {
		this.ch = ch;
		this.handler = handler;
		handler.setConnection(this);
	}

	public void close()
	{
		if (ch == null || !ch.isOpen())
		{
			return;
		}
		try
		{
			ch.close().await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void write(Packet... packets)
	{
		for (Packet p : packets)
		{
			ch.writeAndFlush(p);
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		handler.connected();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		// TODO
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
		System.out.println("Exception: " + cause.getMessage());
		cause.printStackTrace();
	}
}
