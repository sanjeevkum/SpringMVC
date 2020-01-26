package com.learning;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	//public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j)
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t1"));
		
		AddService as = new AddService();
		int k = as.add(i,j);
		
		//Model View Object
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("display"); //which view want to call
		mv.addObject("result",k); // what data need to pass
		
		return mv;
	}
}
