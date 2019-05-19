package com.habuma.spittr.alerts;

import com.habuma.spittr.model.Spittle;

public interface ReveiveSpittleMessage {
   Object retrieveSpittleAlert();
   void handlerSpittleAlert(Spittle spittle);
}
