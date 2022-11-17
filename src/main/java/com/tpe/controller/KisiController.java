package com.tpe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpe.domain.Kisi;
import com.tpe.service.KisiService;


@RestController
public class KisiController {
	
	
	@Autowired
	private ApplicationContext applicationContext ;
	
	@RequestMapping("/beans")
	@GetMapping
	public Map<String,String> getBeans(){
	 String[]	beanNames= applicationContext.getBeanDefinitionNames();
		Map<String, String> map=new HashMap<>();
		
		for (String beanName : beanNames) {
			map.put(beanName, applicationContext.getBean(beanName).toString());
		}
	
		return map;
	}

	public KisiService kisiService;
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService=kisiService;
	}
	
	@PostMapping("/kisiler/ekle")
	public Kisi yeniKisiEkle(@RequestBody Kisi kisi) {
		return kisiService.ekleKisi(kisi);
	}
	
	@GetMapping(path="/kisiler")
	public List<Kisi> kisilerGetir(){
		return kisiService.getirKisi();
	}
	
	@PatchMapping(path="/kisiler/yenile/{id}")
	public Kisi patchUpdate(@PathVariable Integer id, @RequestBody Kisi kisi) {
		return kisiService.idIleKisiGüncelle(id, kisi);
	}

}
