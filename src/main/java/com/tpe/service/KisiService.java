package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpe.domain.Kisi;
import com.tpe.repository.KisiRepository;


@Service
public class KisiService {
	
	public static KisiRepository kisiRepository;
	@Autowired
	public KisiService(KisiRepository kisiRepository) {
		this.kisiRepository=kisiRepository;
	}
	
	
	public Kisi ekleKisi(Kisi kisi){
		
		return kisiRepository.save(kisi);
	}
	
	public List<Kisi> getirKisi(){
		return kisiRepository.findAll();
	}
	
	//idIleKisiGüncelle methodu yzziniz put ile patch arasinda ki fark nedir
	public Kisi idIleKisiGüncelle(Integer id, Kisi updateKisi) {
	Kisi bulunanKisi=	kisiRepository.findById(id).orElseThrow(()->
		new IllegalStateException(id + " li kisi bulunamadiu"));
	
	if(updateKisi.getAd()!=null) {
		bulunanKisi.setAd(updateKisi.getAd());
	}
	if(updateKisi.getSoyad()!=null) {
		bulunanKisi.setSoyad(updateKisi.getSoyad());
	}
	if (updateKisi.getYas()!=0) {
		bulunanKisi.setYas(updateKisi.getYas());
	}
		return kisiRepository.save(bulunanKisi);
	}
	
	


	}
