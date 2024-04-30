package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.User;
import br.com.dicasdeumdev.api.domain.dto.UserDTO;
import br.com.dicasdeumdev.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    public static final String ID = "/{id}";
    @Autowired
    private ModelMapper mapper;
    /*
    o ModelMapper é usado para converter um objeto e de um tipo para um objeto de outro tipo
    por exemplo, existe duas classes uma classe Pessoa e uma PessoaDTO, e voce quer converter
    a classe Pessoa em PessoaDTO, então você usaria o ModelMapper para fazer essa conversão
     */

    @Autowired
    private UserService service;

    @GetMapping(value = ID) // localhost:8080/user/{id} o id seria o numero do cliente cadastrado (1, 2, ...)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> listDTO = service.findAll().stream()
                .map(x -> mapper.map(x, UserDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    /*
    esse método retorna uma resposta HTTP com status 200(ok) e uma lista de objetos
    UserDTO que representa todoa os usuários recuperados do serviço ou do Repositório
    do banco de dados
     */

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID)
                .buildAndExpand(service.create(obj).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    /*
    o método create recebe um Objeto chamado UserDTO cria um novo usuario, gera
    um URI e para o novo recurso craido ele retorna uma resposta HTTP 201 com o URI
    do novo uruário como parte da resposta
     */

    @PutMapping(value = ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(obj), UserDTO.class));
    }
    /*
    quando uma solicitação PUT é feita para o URI, esse metodo atualiza
    o usuário com o id escolhido atualizando os dados desejados e retorna
    o usuário atualizado
     */

    @DeleteMapping(value = ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
