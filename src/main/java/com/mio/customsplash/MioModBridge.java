package com.mio.customsplash;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MioModBridge {
    private static DatagramSocket socket;
    private static boolean isFinished=false;
    public static void startServer(){
        try {
            socket = new DatagramSocket();
            socket.connect(new InetSocketAddress("127.0.0.1", 6666));
            MioCustomSplash.logger.info("mod与启动器连接成功");
//            socket.close();
        }catch (Exception e){
            MioCustomSplash.logger.error("调用startServer失败:"+e.toString());
        }

    }
    private static void send(String s) throws Exception {
//        if (socket.isClosed()&&!isFinished){
//            startServer();
//        }
        byte[] data = s.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.send(packet);
    }
    public static void stop(){
        try {
            socket.close();
        }catch (Exception e){

        }
    }
    public static void sendProgress(int progress){
        if (isFinished)return;
        try {
//            MioCustomSplash.logger.info("progress:"+progress);
            send(progress+"");
            if(progress==100){
                isFinished=true;
            }
        } catch (Exception e) {
            MioCustomSplash.logger.error("sendProgress exception:"+e.toString());
        }
    }
    public static void sendStatus(String status){
        if (isFinished)return;
        try {
//            MioCustomSplash.logger.info("status:"+status);
            send(status);
        } catch (Exception e) {
            MioCustomSplash.logger.error("sendStatus exception:"+e.toString());
        }
    }
}
