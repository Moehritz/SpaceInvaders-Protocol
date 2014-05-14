package de.mm.spaceinvaders.io;

import io.netty.channel.ChannelPipeline;

public class PipelineInitiator
{
	private static FramePrepender framePrepender = new FramePrepender();
	private static SpaceEncoder spaceEncoder = new SpaceEncoder();

	public static void initPipeline(ChannelPipeline p)
	{
		p.addLast(framePrepender);
		p.addLast(new FrameDecoder());
		p.addLast(spaceEncoder);
		p.addLast(new SpaceDecoder());
	}
}
