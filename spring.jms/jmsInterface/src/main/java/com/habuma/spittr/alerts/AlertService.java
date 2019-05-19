package com.habuma.spittr.alerts;

import com.habuma.spittr.model.Spittle;

public interface AlertService {
  void sendSpittleAlert(Spittle spittle);
  Spittle getSpittle();
}
