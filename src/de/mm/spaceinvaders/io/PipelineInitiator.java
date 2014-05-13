package de.mm.spaceinvaders.io;

import io.netty.channel.ChannelPipeline;

public class PipelineInitiator
{
	private static FramePrepender framePrepender = new FramePrepender();
	private static FrameDecoder frameDecoder = new FrameDecoder();
	private static SpaceEncoder spaceEncoder = new SpaceEncoder();
	private static SpaceDecoder spaceDecoder = new SpaceDecoder();

	public static void initPipeline(ChannelPipeline p)
	{
		p.addLast(framePrepender);
		p.addLast(frameDecoder);
		p.addLast(spaceEncoder);
		p.addLast(spaceDecoder);
	}
}
