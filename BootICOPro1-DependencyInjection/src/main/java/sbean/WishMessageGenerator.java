package sbean;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator 
{ 
   @Autowired
   private LocalDateTime time;
   
   public String showWishMessage(String name)
   {
	   
	   return null;
   }
}
