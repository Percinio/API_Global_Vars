package br.com.clickbus.sistemadevariaveisglobais.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.clickbus.sistemadevariaveisglobais.controller.dto.DetalhesDaVariavelDto;
import br.com.clickbus.sistemadevariaveisglobais.controller.dto.VariavelDto;
import br.com.clickbus.sistemadevariaveisglobais.controller.form.AtualizacaoVariavelForm;
import br.com.clickbus.sistemadevariaveisglobais.controller.form.VariavelForm;
import br.com.clickbus.sistemadevariaveisglobais.repository.ViacaoRepository;
import br.com.clickbus.sistemadevariaveisglobais.repository.VariaveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

@RestController
@RequestMapping("/variaveis")
public class VariavelController {
	
	@Autowired
	private VariaveisRepository variaveisRepository;
	
	@Autowired
	private ViacaoRepository viacaoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeVariaveis")
	public Page<VariavelDto> lista(@RequestParam(required = false) String nomeViacao,
								   @PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (nomeViacao == null) {
			Page<Variavel> variaveis = variaveisRepository.findAll(paginacao);
			return VariavelDto.converter(variaveis);
		} else {
			Page<Variavel> variaveis = variaveisRepository.findByViacaoNome(nomeViacao, paginacao);
			return VariavelDto.converter(variaveis);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeVariaveis", allEntries = true)
	public ResponseEntity<VariavelDto> cadastrar(@RequestBody @Valid VariavelForm form, UriComponentsBuilder uriBuilder) {
		Variavel variavel = form.converter(viacaoRepository);
		variaveisRepository.save(variavel);
		
		URI uri = uriBuilder.path("/variaveis/{id}").buildAndExpand(variavel.getId()).toUri();
		return ResponseEntity.created(uri).body(new VariavelDto(variavel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaVariavelDto> detalhar(@PathVariable Long id) {
		Optional<Variavel> variavel = variaveisRepository.findById(id);
		if (variavel.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaVariavelDto(variavel.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeVariaveis", allEntries = true)
	public ResponseEntity<VariavelDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVariavelForm form) {
		Optional<Variavel> optional = variaveisRepository.findById(id);
		if (optional.isPresent()) {
			Variavel variavel = form.atualizar(id, variaveisRepository);
			return ResponseEntity.ok(new VariavelDto(variavel));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeVariaveis", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Variavel> optional = variaveisRepository.findById(id);
		if (optional.isPresent()) {
			variaveisRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}