package de.ukrainewin.store.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//import org.elasticsearch.client.internal.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.http.HttpHost;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;

@RestController
@RequestMapping("api/med")
public class MedicamentController {
	
	//@Autowired
	//FoodService foodService;
	
	@GetMapping("{id}")
	    public List</*Food*/String> listSuggestedMedicamentsId(@PathVariable String id) {
	        System.out.println("listSuggestedMedicamentsId");

			RestClient restClient = RestClient
					.builder(HttpHost.create("http://localhost:9200"))
					.build();
			ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
			ElasticsearchClient client = new ElasticsearchClient(transport);

	        return List.of("id med", "exists");//foodService.list();
	    }
	
	
	
	
	  @GetMapping
	    public List</*Food*/String> listSuggestedMedicaments(@RequestParam Optional<String> search) {
	        System.out.println("listSuggestedMedicaments");
			if (search.isPresent()) {
	            //return foodService.search(search.get());
	        }
	        return Arrays.asList(new String[]{"id med", "null"});//foodService.list();
	    }

}
