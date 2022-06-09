package br.com.fiap.gs1.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.gs1.repositories.ViagemRepository;
import br.com.fiap.gs1.dtos.ViagemDTO;
import br.com.fiap.gs1.models.Viagem;


@Controller
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelView = new ModelAndView("home");
		return modelView;
	}
	
	@GetMapping("/viagens")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("listagem/index");
		
		List<Viagem> viagensDaRepository = viagemRepository.findAll();
		modelView.addObject("listarViagens", viagensDaRepository);
		
		return modelView;
	}
	
	@GetMapping("/viagens/cadastro")
	public ModelAndView criar(ViagemDTO viagem) {
		ModelAndView modelView = new ModelAndView("cadastro/index");
		return modelView;
	}
	
	
	@PostMapping("/viagens")
	public ModelAndView salvar(@Valid ViagemDTO viagem, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			return new ModelAndView("cadastro/index");
		}
		
		Viagem viagemEntity = modelMapper.map(viagem, Viagem.class);
		
		//a repository faz a interação com o banco de dados
		viagemRepository.save(viagemEntity);
		
		return new ModelAndView ("redirect:/viagens");
	}
	

}
