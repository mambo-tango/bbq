package com.tango.bbq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tango.bbq.repository.FistRepository;

@Controller
public class FirstController {

  @Autowired
  private FistRepository repository;
  
  @RequestMapping("/monitor")
  public String home(Model model) {
//	  Map<String, String> map = new HashMap<String, String>();
//	  map.put("testKey", "testValue");
//	  CSVUtils.readeCsv();
//	  model.addAttribute("testkey","testvalue");
//	  model.addAttribute(map);
	  Map<String, String> map = repository.queryTest(null, "2016-11-19");
//	  model.addAttribute("date","2016/11/10-1h,2016/11/10-2h,2016/11/10-3h,2016/11/10-4h,2016/11/10-5h,2016/11/10-6h,2016/11/10-7h");
//	  model.addAttribute("data","2100,3600,2404,3640,4690,3900,3100");
	  model.addAttribute("date",map.get("date"));
	  model.addAttribute("data",map.get("data"));
      return "monitorChart";
  }
  
  
  
}
