package br.com.fiap.gs1.controllers;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView salvar(@Valid ViagemDTO viagem, BindingResult bindingResult ) throws ParseException {
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			return new ModelAndView("cadastro/index");
		}
		
		Viagem viagemEntity = modelMapper.map(viagem, Viagem.class);

		//calcular data de retorno
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dataDecolagem = formato.parse(viagemEntity.getDataDecolagem()); 
		Date dataRetorno = formato.parse(viagemEntity.getDataDecolagem());       
		dataRetorno.setDate(dataRetorno.getDate()+viagemEntity.getDuracaoEstadia());
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); 
		viagemEntity.setDataRetornoTerra(formatoData.format(dataRetorno));
		viagemEntity.setDataDecolagem(formatoData.format(dataDecolagem));
		System.out.println("DATA: "+ viagemEntity.getDataRetornoTerra());
		//a repository faz a interação com o banco de dados
		viagemRepository.save(viagemEntity);
		
		return new ModelAndView ("redirect:/viagens");
	}
	
	@GetMapping("viagens/{id}/edit")
	public ModelAndView edit(@PathVariable int id, ViagemDTO request) {
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);

		if (optionalViagem.isPresent()) {
			Viagem viagem = optionalViagem.get();
			request.fromViagem(viagem);
			ModelAndView model = new ModelAndView("alteracao/index");
			model.addObject("idViagem", viagem.getIdViagem());
			return model;
		}

		//
		return new ModelAndView("redirect:/viagens");
	}
	
	@PostMapping("/viagens/{id}")
	public ModelAndView update(@PathVariable int id, @Valid ViagemDTO request, BindingResult bindingResult) throws ParseException {

		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("alteracao/index");
			model.addObject("idViagem", id);
			return model;
		}
		
		Optional<Viagem> optionalViagem = viagemRepository.findById(id);
		
		if(optionalViagem.isPresent()){
			Viagem viagem = modelMapper.map(request, Viagem.class);
			viagem.setIdViagem(id);
			//calcular data de retorno
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dataDecolagem = formato.parse(viagem.getDataDecolagem()); 
			Date dataRetorno = formato.parse(viagem.getDataDecolagem());       
			dataRetorno.setDate(dataRetorno.getDate()+viagem.getDuracaoEstadia());
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); 
			viagem.setDataRetornoTerra(formatoData.format(dataRetorno));
			viagem.setDataDecolagem(formatoData.format(dataDecolagem));
			System.out.println("DATA: "+ viagem.getDataRetornoTerra());
			viagemRepository.save(viagem);
			return new ModelAndView("redirect:/viagens");
		}
		
		return new ModelAndView("redirect:/produtos");
	}

	
	@GetMapping("/viagens/{id}/delete")
	public ModelAndView delete(@PathVariable int id) {
		ModelAndView model = new ModelAndView("redirect:/viagens");
		
		this.viagemRepository.deleteById(id);
		model.addObject("mensagem", "Viagem removida com sucesso!");
		return model;
	}
	

}
