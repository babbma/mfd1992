package com.app.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.Employee;
import com.app.entity.config.Constant;
import com.app.entity.easyui.Tree;

@Controller
@RequestMapping("/menu")
public class MenuController {

	private static final Map<Integer, Tree> map = new HashMap<Integer, Tree>();
	static{
		
		map.put(1, new Tree(1, "所有菜单", "closed",null,-1));
		map.put(11, new Tree(11, "管理员管理","closed",null, 1));
		map.put(12, new Tree(12, "订单管理","open",null, 1).setAttr("url", "order/list"));
		map.put(13, new Tree(13, "商品管理","open",null, 1).setAttr("url", "product/list"));
		map.put(111, new Tree(111,"新增管理员","open",null,11).setAttr("url", "emp/page/add"));
	}
	
	/**
	 * 找到指定pid的菜单
	 * @param pid 父亲节点的id
	 * @return 所有pid值符合条件的node集合
	 */
	public static List<Tree> getNodeListByPid(Integer pid,boolean admin){
		List<Tree> list = new ArrayList<Tree>();
		for(Tree item: map.values()){
			if(item.getPid()== pid){
				if(!admin && item.getId()!=11 ){
					list.add(item);
				}else if(admin){
					list.add(item);
				}
			}
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/getMenu")
	public List<Tree> getMenu(@RequestParam(required=false)Integer id,@ModelAttribute("session")Employee emp){
		if(id==null){
			id=-1;
		}
		boolean admin = emp.getRole()== Constant.ADMIN ;
		return getNodeListByPid(id, admin);
	}
}
