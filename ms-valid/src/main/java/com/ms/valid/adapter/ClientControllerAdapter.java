package com.ms.valid.adapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.valid.domain.dto.ClientDTO;
import com.ms.valid.domain.entity.ClientEntity;
import com.ms.valid.service.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientControllerAdapter {

	private ClientService clientService;
	private ModelMapper modelMapper;

	@Autowired
	public ClientControllerAdapter(ClientService clientService, ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.clientService = clientService;
	}

	@GetMapping(value = "/find-all-client")
	public ResponseEntity<List<ClientDTO>> consultClients() {

		Type listType = new TypeToken<List<ClientDTO>>() {}.getType();

		List<ClientDTO> lstClientDTO = modelMapper.map(clientService.FindClients(), listType);

		return new ResponseEntity<>(lstClientDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/save-client")
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {

		System.out.println(" ENTRO A CONTROLLER _ " + clientDTO);
		
		return new ResponseEntity<ClientDTO>(modelMapper
				.map(clientService.saveClient(modelMapper.map(clientDTO, ClientEntity.class)), ClientDTO.class),
				HttpStatus.OK);

	}
	
	@GetMapping(value = "/find-id-client/{id}")
	public ResponseEntity<ClientDTO> consultClientById(@PathVariable Long id) {
		
		return new ResponseEntity<>(modelMapper.map(clientService.findByIdClient(id), ClientDTO.class), HttpStatus.OK);
		
	}
	

	@PutMapping(value="/saves-clients")
	public ResponseEntity<List<ClientDTO>> saveUsuarios(@RequestBody List<ClientDTO> lstClientDTO) {
		List<ClientDTO> lstClientDtoResponse = new ArrayList<>();
		
		for (ClientDTO clientDTO: lstClientDTO) {
			
			lstClientDtoResponse.add(modelMapper.map(clientService.saveClient(modelMapper.map(clientDTO, ClientEntity.class)), ClientDTO.class));
		}
		
		
		return new ResponseEntity<List<ClientDTO>>(lstClientDtoResponse, HttpStatus.OK);
	}

}
