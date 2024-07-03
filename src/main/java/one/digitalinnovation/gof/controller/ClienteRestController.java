package one.digitalinnovation.gof.controller;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

import java.util.List;


@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@Operation(summary = "Rota responsável por buscar todos os clientes")
	@ApiResponse(responseCode = "200", description = "Clientes retornados com sucesso")
	public ResponseEntity<List<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Rota responsável  por buscar um  Cliente pelo id")
	@ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@PostMapping
	@Operation(summary = "Rota responsável por inserir um novo Cliente")
	@ApiResponse(responseCode = "201", description = "Cliente salvo com sucesso")
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Rota responsável  por atualizar um  Cliente pelo id")
	@ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Rota responsável  por deletar um  Cliente")
	@ApiResponse(responseCode = "204", description = "Sem conteúdo")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
