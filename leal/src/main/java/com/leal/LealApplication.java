package com.leal;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leal.domain.Cidade;
import com.leal.domain.Cliente;
import com.leal.domain.Endereco;
import com.leal.domain.Estado;
import com.leal.domain.enuns.TipoCliente;
import com.leal.domain.repositories.CidadeRepository;
import com.leal.domain.repositories.ClienteRepository;
import com.leal.domain.repositories.EnderecoRepository;
import com.leal.domain.repositories.EstadoRepository;

@SpringBootApplication
public class Senai3Application implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Senai3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Osasco", est2);
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
		
		Cliente cli1 = new  Cliente(null, "Thiago Leal", "12234578908", "lealthiagom@hotmail.com", 
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new  Cliente();
		cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
		cli2.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		
        Endereco e1 = new Endereco(null, "Rua Maravilha", "84","", "roosevelt", "38534534",cli1,c1);
        Endereco e2 = new Endereco(null, "Rua randan", "99","", "Centro", "06678014",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
