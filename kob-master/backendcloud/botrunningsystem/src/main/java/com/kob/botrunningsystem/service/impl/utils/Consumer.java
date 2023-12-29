package com.kob.botrunningsystem.service.impl.utils;

import lombok.SneakyThrows;
import org.joor.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class Consumer extends Thread{
    private Bot bot;
    private  static RestTemplate restTemplate;

    private final static String receiveBotMoveUrl="http://127.0.0.1:3000/pk/receive/bot/move";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        Consumer.restTemplate=restTemplate;
    }
    public void startTimeout(long timeout,Bot bot){
        this.bot=bot;
        this.start();

        try {
            this.join(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            this.interrupt();//中断当前线程
        }

    }
    private String addUid(String code,String uid){
        int k = code.indexOf(" implements java.util.function.Supplier<Integer>");
        return code.substring(0,k)+uid+code.substring(k);
    }
    @SneakyThrows
    @Override
    public void run() {
        UUID uuid =UUID.randomUUID();
        String uid = uuid.toString().substring(0,8);
        Supplier<Integer> botInterface = Reflect.compile(
                "com.kob.botrunningsystem.utils.Bot"+uid,
                addUid(bot.getBotCode(),uid)
        ).create().get();

        File file =  new File("input.txt");
        try(PrintWriter fout = new PrintWriter(file)){
                fout.println(bot.getInput());
                fout.flush();
        }
        Integer direction = botInterface.get();
        System.out.println("move: "+bot.getUserId()+" "+direction);
        MultiValueMap<String,String> data = new LinkedMultiValueMap<>();
        data.add("user_id",bot.getUserId().toString());
        data.add("direction",direction.toString());
        restTemplate.postForObject(receiveBotMoveUrl,data,String.class);
    }
}
