package com.project.blogforum.listener;


import com.project.blogforum.annotation.Log;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



@Component
public class RestAppEventListener {

    //@EventListener(condition = "#springApp.args.length > 1")
    //@EventListener({CurrencyEvent.class,CurrencyConversionEvent.class})
    //@Order(Ordered.HIGHEST_PRECEDENCE)
    //@Async
    @EventListener
    @Log(printParamsValues=true)
    public void restAppHandler(SpringApplicationEvent springApp){
    }
}