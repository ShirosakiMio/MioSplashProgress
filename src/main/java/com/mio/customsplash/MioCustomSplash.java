package com.mio.customsplash;

import alexiil.mc.mod.load.ModLoadingListener;
import alexiil.mc.mod.load.frame.FrameDisplayer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;


@Mod(modid = MioCustomSplash.MODID, name = MioCustomSplash.NAME, version = MioCustomSplash.VERSION)
public class MioCustomSplash
{
    public static final String MODID = "splashprogress";
    public static final String NAME = "SplashProgress";
    public static final String VERSION = "1.0";

    public static Logger logger= LogManager.getLogger("MioSplashProgress");

    private static FrameDisplayer displayer;
    static {
        MioModBridge.startServer();
        displayer = new FrameDisplayer();
        displayer.start();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
//        logger=event.getModLog();
    }

    @EventHandler
    public static void construct(FMLConstructionEvent event) {
        ModLoadingListener.setup();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

}

